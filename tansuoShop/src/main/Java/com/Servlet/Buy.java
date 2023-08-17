package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.DBHelper;

@WebServlet("/buy")
public class Buy extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8618327416633206236L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		double p = Double.parseDouble(request.getParameter("p"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		int number = Integer.parseInt(request.getParameter("number"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
		String oid = uid+datetime.replace("-", "").replace(" ", "").replace(":", "");

		String sql = "INSERT INTO orders VALUES ('"+oid+"','"+datetime+"','"+uid+"','"+p+"',FALSE)";
		int state = DBHelper.executeUpdate(sql);
		if(state == 0){ 
			out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
			return;
		}else {
			sql = "INSERT INTO orderProduct VALUES ('" + oid + "','" + cid + "','" + number + "')";
			state = DBHelper.executeUpdate(sql);
			if (state == 0) {
				out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
				return;
			} else {
				out.print("<script>alert('下单成功');window.location='checkout.jsp?oid=" + oid + "&p=" + p + "'</script>");
			}
		}
	}
}