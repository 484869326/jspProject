package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.DBHelper;
import com.JavaBean.Users;


@WebServlet("/dologin")
public class Dologin extends HttpServlet{


	private static final long serialVersionUID = -8945169060045680182L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//验证码
		String piccode=(String) request.getSession().getAttribute("piccode");
        String checkCode=request.getParameter("checkCode");  //取值
        checkCode=checkCode.toUpperCase();  //把字符全部转换为大写的（此语句可以用于验证码不区分大小写）
        if(checkCode.equals(piccode)) {
        	String userName = request.getParameter("userName").trim(); 
    		String userPwd = request.getParameter("userPwd").trim();

    		String sql = "SELECT * FROM users WHERE userid='"+userName+"' AND password='"+userPwd+"'";
    		List<Users> ls = null;
    		try {
    			ls = DBHelper.Login(sql);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		Users currentUser;
    		try {
    			currentUser = ls.get(0);
    			Cookie uid = new Cookie("uid" ,Integer.toString(currentUser.getUserid()));
    			response.addCookie(uid);
    			Cookie nickname = new Cookie("nickname" ,currentUser.getNickname());
    			response.addCookie(nickname);
    		}catch (Exception e) {
    			sql = "SELECT * FROM users WHERE telephone='"+userName+"' AND password='"+userPwd+"'";
    			try {
    				ls = DBHelper.Login(sql);
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			try{
    				currentUser = ls.get(0);
    				Cookie uid = new Cookie("uid" ,Integer.toString(currentUser.getUserid()));
    				response.addCookie(uid);
    				Cookie nickname = new Cookie("nickname" ,currentUser.getNickname());
    				response.addCookie(nickname);
    			}catch (Exception f) {
    				out.println("<script>alert('登录失败！');window.location='login.jsp'</script>");
    			}finally {
    				out.println("<script>alert('登录成功。');window.location='index.jsp'</script>");
    			}
    		}finally {
    			out.print("<script>alert('登录成功。');window.location='index.jsp'</script>");
    		}
        }
        else
        {
        	out.println("<script>alert('验证码错误！');window.location='login.jsp'</script>");
        }
        out.flush();//将流刷新
        out.close();//将流关闭
        
	}
}