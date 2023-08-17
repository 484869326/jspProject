package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaBean.DBHelper;

@WebServlet("/upordown")
public class UpOrDown extends HttpServlet{


	private static final long serialVersionUID = 5487130331396161920L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int state = Integer.parseInt(request.getParameter("state"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String sql = "";
		int yesorno = 0;
		if (state == 0) {
			sql = "UPDATE good SET state=TRUE WHERE goodid = '"+cid+"'";
			yesorno = DBHelper.executeUpdate(sql);
			if(yesorno == 0){ 
				out.print("<script>alert('上架失败');window.location='management.jsp'</script>");
			}else {
				out.print("<script>alert('上架成功');window.location='management.jsp'</script>");
			}
		}else {
			sql = "UPDATE good SET state=FALSE WHERE goodid = '"+cid+"'";
			yesorno = DBHelper.executeUpdate(sql);
			if(yesorno == 0){ 
				out.print("<script>alert('下架失败');window.location='management.jsp'</script>");
			}else {
				out.print("<script>alert('下架成功');window.location='management.jsp'</script>");
			}
		}
	}
}