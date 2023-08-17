package com.Servlet;

import java.util.Calendar;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JavaBean.Good;
import com.JavaBean.DBHelper;

@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet{


	private static final long serialVersionUID = 5487130331396161920L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		double p = Double.parseDouble(request.getParameter("p"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
		String oid = uid+datetime.replace("-", "").replace(" ", "").replace(":", "");

		String sql = "INSERT INTO orders VALUES ('"+oid+"','"+datetime+"','"+uid+"','"+p+"',FALSE)";
		int state = DBHelper.executeUpdate(sql);
		if(state == 0){ 
			out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
			return;
		}else {
			sql = request.getSession().getAttribute("sql").toString();
			List<Good> ls = DBHelper.Cart(sql);
			Good currentCommodity;
			if (ls == null) {
				out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
				return;
			}else {
				for (int i = 0; i < ls.size(); i++) {
					currentCommodity = ls.get(i);
					if (currentCommodity.getNumber() == 0) {
						continue;
					}
					sql = "INSERT INTO orderProduct VALUES ('"+oid+"','"+currentCommodity.getGoodid()+"','"+currentCommodity.getNumber()+"')";
					state = DBHelper.executeUpdate(sql);
					if(state == 0){ 
						out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
						return;
					}
				}
				sql = "DELETE FROM cart WHERE userid='"+uid+"'";
				state = DBHelper.executeUpdate(sql);
				if(state == 0){ 
					out.print("<script>alert('下单失败');window.location='cart.jsp'</script>");
					return;
				}
				out.print("<script>alert('下单成功');window.location='checkout.jsp?oid="+oid+"&p="+p+"'</script>");
				
			}
		}
	}
}