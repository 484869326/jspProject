package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.DBHelper;

@WebServlet("/deleteorder")
public class DeleteOrder extends HttpServlet{


	private static final long serialVersionUID = 5487130331396161920L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String oid = request.getParameter("oid");
		String uid = request.getParameter("uid");

		String sql = "DELETE FROM orderProduct WHERE orderid='"+oid+"'";
		//out.print("<script>alert('"+sql+"')</script>");
		int state = DBHelper.executeUpdate(sql);
		if(state != 0){ 
			sql = "DELETE FROM orders WHERE userid="+uid+" and orderid='"+oid+"'";
			state = DBHelper.executeUpdate(sql);
			if(state != 0){ 
				out.print("<script>alert('删除成功。');window.location='orders.jsp'</script>");
			}else {
				out.print("<script>alert('删除失败！');window.location='orders.jsp'</script>");
			}
		}else{
			out.print("<script>alert('删除失败！');window.location='orders.jsp'</script>");
		}

	}
}