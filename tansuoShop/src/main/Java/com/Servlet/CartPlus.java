package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.DBHelper;

@WebServlet("/cartplus")
public class CartPlus extends HttpServlet{


	private static final long serialVersionUID = 5487130331396161920L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		int num=Integer.parseInt(request.getParameter("num"));
		String sql = "UPDATE cart SET number="+(num+1)+" WHERE userid='"+uid+"' and goodid='"+cid+"'";
		int state = DBHelper.executeUpdate(sql);
		if(state == 0){ 
			out.print("<script>alert('操作失败！');window.location='cart.jsp'</script>");
		}else {
			out.print("<script>window.location='cart.jsp'</script>");
		}

	}
}