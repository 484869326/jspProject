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


@WebServlet("/doregister")
public class Doregister extends HttpServlet{



	private static final long serialVersionUID = 2141740120075277680L;

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
					String username = new String(request.getParameter("username").getBytes("iso8859-1"),"UTF-8");
		        	String tel=request.getParameter("tel").trim();
		    		String pwd=request.getParameter("pwd").trim();
		    		String email=request.getParameter("email").trim();
		    		List<Users> ls = null;

		    		if(tel.equals("") || pwd.equals("") || email.equals("") || username.equals("")){
		    			out.print("<script>alert('出现错误！请检查是否输入正确。');window.location='register.jsp'</script>");
		    		}else{
		    			String sql = "INSERT INTO users(telephone,password,mail,name) VALUES ('"+tel+"','"+pwd+"','"+email+"','"+username+"')";
						System.out.println(sql);
		    			int state = DBHelper.executeUpdate(sql);
		    			if(state != 0){
		    				sql="SELECT * FROM users WHERE telephone='"+tel+"'";
		    				try {
		    					ls = DBHelper.Login(sql);
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    				Users currentUser;
		    				currentUser = ls.get(0);
		    				//创建Cookie保存用户ID和昵称
		    				Cookie uid = new Cookie("uid" ,Integer.toString(currentUser.getUserid()));
		    				response.addCookie(uid);
		    				out.print("<script>alert('注册成功，请前往填写个人信息');window.location='profile.jsp'</script>");
		    			}else{
		    				out.print("<script>alert('注册失败。');window.location='register.jsp'</script>");
		    			}
		    		}
		        }
		        else
		        {
		        	out.println("<script>alert('验证码错误！');window.location='register.jsp'</script>");
		        }
		        out.flush();//将流刷新
		        out.close();//将流关闭
		
	}
}