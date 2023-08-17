package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signout")
public class Signout extends HttpServlet{

	private static final long serialVersionUID = -9210245680075908864L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Cookie[] cookies=request.getCookies();
		for(int i=0;i<cookies.length;i++){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
		response.sendRedirect("index.jsp");
	}
}