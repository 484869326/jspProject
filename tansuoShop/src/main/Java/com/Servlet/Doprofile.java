package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.DBHelper;


@WebServlet("/doprofile")
public class Doprofile extends HttpServlet{


	private static final long serialVersionUID = 2141740120075277680L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		String uid = "";
		for(int i = 0 ;i < cookies.length ;i++){
			Cookie nicknameCookie = cookies[i];
			if(nicknameCookie.getName().equals("uid")){
				uid = nicknameCookie.getValue();
			}
		}
		//解决乱码问题    new String(获取的值.getBytes("iso8859-1"),"UTF-8"); 
		String nickname = new String(request.getParameter("nickname").getBytes("iso8859-1"),"UTF-8"); 
		String name = new String(request.getParameter("name").getBytes("iso8859-1"),"UTF-8"); 
		String telephone = request.getParameter("telephone").trim(); 
		String mail = request.getParameter("mail").trim();
		String address = new String(request.getParameter("address").getBytes("iso8859-1"),"UTF-8"); 
		
		String sql = "UPDATE users SET nickname='"+nickname+"',name='"+name+"',telephone='"+telephone+"',mail='"+mail+"',address='"+address+"' WHERE userid = '"+uid+"'";
		int state = DBHelper.executeUpdate(sql);
		if(state != 0){ 
			out.print("<script>alert('修改成功。');window.location='profile.jsp'</script>");
			Cookie nicheng = new Cookie("nickname" ,nickname);
			response.addCookie(nicheng);
		}else{
			out.print("<script>alert('修改失败！');window.location='profile.jsp'</script>");
		}
	}
}