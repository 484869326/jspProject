package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaBean.DBHelper;

@WebServlet("/addcart")
public class AddCart extends HttpServlet{


	/**
	 * 
	 */
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
		int tid = 0;int pag = 0;
		String returnStringYes = "";
		String returnStringNo = "";
		try {
			tid = Integer.parseInt(request.getParameter("typeid"));
			pag = Integer.parseInt(request.getParameter("pageIndex"));
			returnStringYes = "<script>alert('添加成功');window.location='index.jsp?typeid="+tid+"&pageIndex="+pag+"'</script>";
			returnStringNo = "<script>alert('添加失败');window.location='index.jsp?typeid="+tid+"&pageIndex="+pag+"'</script>";
		} catch (Exception e) {
			returnStringYes = "<script>alert('添加成功');window.location='index.jsp'</script>";
			returnStringNo = "<script>alert('添加失败');window.location='index.jsp'</script>";
		}
		
		
		
		int num = DBHelper.Cart(uid,cid);//查找购物车，有这件商品就返回这件商品的数量，没有返回0
		
		//out.print("<script>alert('"+num+"');window.location='index.jsp?typeid="+tid+"&pageIndex="+pag+"'</script>");
		String sql= "";
		if (num == 0) {
			sql = "INSERT INTO cart VALUES ('"+uid+"','"+cid+"','1');";
			int state = DBHelper.executeUpdate(sql);
			if(state == 0){ 
				out.print(returnStringNo);
			}else {
				out.print(returnStringYes);
			}
		}else {
			sql = "UPDATE cart SET number='"+(num+1)+"' WHERE userid='"+uid+"' and goodid='"+cid+"'";
			int state = DBHelper.executeUpdate(sql);
			if(state == 0){ 
				out.print(returnStringNo);
			}else {
				out.print(returnStringYes);
			}
		}
		

	}
}