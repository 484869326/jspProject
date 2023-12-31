/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-11-23 07:25:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.JavaBean.OrderProduct;
import com.JavaBean.Orders;
import com.JavaBean.DBHelper;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class orders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <title>订单</title>\n");
      out.write("    <link rel=\"icon\" href=\"img/core-img/favicon.ico\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"preloader\" id=\"preloader\">\n");
      out.write("      <div class=\"spinner-grow text-secondary\" role=\"status\">\n");
      out.write("        <div class=\"sr-only\">加载中...</div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"header-area\" id=\"headerArea\">\n");
      out.write("      <div class=\"container h-100 d-flex align-items-center justify-content-between\">\n");
      out.write("        <div class=\"back-button\"><a href=\"index.jsp\"><i class=\"lni lni-home\"></i></a></div>\n");
      out.write("        <div class=\"top-search-form\">\n");
      out.write("\n");
      out.write("          <form action=\"\" method=\"POST\">\n");
      out.write("            <input class=\"form-control\" name=\"orderid\"  type=\"search\" placeholder=\"请输入订单号\">\n");
      out.write("            <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"suha-navbar-toggler d-flex justify-content-between flex-wrap\" id=\"suhaNavbarToggler\"><span></span><span></span><span></span></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"sidenav-black-overlay\"></div>\n");
      out.write("\n");
      out.write("<!-- 左侧导航栏start -->\n");
      out.write("    <div class=\"suha-sidenav-wrapper\" id=\"sidenavWrapper\">\n");
      out.write("      <!-- 头像昵称 -->\n");
      out.write("\t");

		String nickname = "";
		String uid = "";
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
		}else{
			for(int i = 0 ;i < cookies.length ;i++){
				if(cookies[i].getName().equals("nickname")){
					nickname = cookies[i].getValue();
				}else if(cookies[i].getName().equals("uid")){
					uid = cookies[i].getValue();
				}
			}	
		}
	
      out.write(" \n");
      out.write("      <div class=\"sidenav-profile\">\n");
      out.write("        <div class=\"user-profile\"><img src=\"img/bg-img/9.jpg\" alt=\"\"></div>\n");
      out.write("        <div class=\"user-info\">\n");
      out.write("          <h6 class=\"user-name mb-0\">");
      out.print(nickname );
      out.write("</h6>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- 右边导航栏 -->\n");
      out.write("      ");

      	if(uid.equals("")){
      		out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
      
      out.write("\n");
      out.write("      <ul class=\"sidenav-nav\">\n");
      out.write("        <li><a href=\"login.jsp\"><i class=\"lni lni-pointer-up\"></i>登录</a></li>\n");
      out.write("      </ul>\n");
      out.write("      ");

      	}else if (nickname.equals("")){
      		
      
      out.write("\n");
      out.write("      \t\t<ul class=\"sidenav-nav\">\n");
      out.write("            <li><a href=\"profile.jsp\"><i class=\"lni lni-pointer-up\"></i>修改个人资料</a></li>\n");
      out.write("          </ul>\n");
      out.write("       ");

      	}else if(uid != null && nickname != null){
      
      out.write("\n");
      out.write("      <ul class=\"sidenav-nav\">\n");
      out.write("      <li><a href=\"profile.jsp\"><i class=\"lni lni-pointer-up\"></i>修改个人资料</a></li>\n");
      out.write("        <li><a href=\"orders.jsp\"><i class=\"lni lni-empty-file\"></i>我的订单</a></li>\n");
      out.write("        ");

        	//是管理员才能显示商品管理
        	if(nickname.equals("管理员")){
        
      out.write("\n");
      out.write("        <li><a href=\"management.jsp\"><i class=\"lni lni-grid-alt\"></i>商品管理</a></li>\n");
      out.write("        ");

        	}
        
      out.write("\n");
      out.write("        <li><a href=\"cart.jsp\"><i class=\"lni lni-cart-full\"></i>购物车</a></li>\n");
      out.write("        <li><a href=\"signout\"><i class=\"lni lni-power-switch\"></i>退出登录</a></li>\n");
      out.write("      </ul>\n");
      out.write("      ");

      	}else{
      		out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
      	}
      
      out.write("\n");
      out.write("      <!-- 返回按钮 -->\n");
      out.write("      <div class=\"go-home-btn\" id=\"goHomeBtn\"><i class=\"lni lni-arrow-left\"></i></div>\n");
      out.write("    </div>\n");
      out.write("    <!-- 左侧导航栏end -->\n");
      out.write("\n");
      out.write("    <div class=\"page-content-wrapper\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"my-order-wrapper py-3\">\n");
      out.write("          ");

          String sql = "";
          try{
        	  String orderid = request.getParameter("orderid");
        	  Pattern pattern = Pattern.compile("[0-9]{18}"); 
        	  Matcher isNum = pattern.matcher(orderid);
              if(!isNum.matches()){
            	  sql = "SELECT * FROM orders WHERE userid="+uid+"";
            	  //out.print("<script>alert('订单号输入错误')</script>");
              }else{
            	  sql = "SELECT * FROM orders WHERE orderid='"+orderid+"'";
              }
          }catch (Exception e) {
        	  sql = "SELECT * FROM orders WHERE userid="+uid+"";
          }
          request.removeAttribute("orderid");
          List<Orders> ls = DBHelper.Orders(sql);
          Orders currentOrder;
          for (int i = 0; i < ls.size(); i++) {
          	currentOrder = ls.get(i) ;
          	
      out.write("\n");
      out.write("          \t<div class=\"single-order-status\">\n");
      out.write("            <div class=\"card bg-warning mb-3\">\n");
      out.write("            <form action=\"\" method=\"post\">\n");
      out.write("              <div class=\"card-body d-flex align-items-center\">\n");
      out.write("                <div class=\"order-status\">时间：<span class=\"order-date\">");
      out.print(currentOrder.getTime() );
      out.write("</span></div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"card-body d-flex align-items-center\">\n");
      out.write("                <div class=\"order-status\">订单号：<span class=\"order-date\">");
      out.print(currentOrder.getOrderid() );
      out.write("</span></div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"card-body d-flex align-items-center\">\n");
      out.write("                <div class=\"order-status\">总金额：<span class=\"order-date\">￥");
      out.print(currentOrder.getPrice());
      out.write("</span></div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"card-body d-flex align-items-center\">\n");
      out.write("              ");

              	if(currentOrder.getState()){
              
      out.write("\n");
      out.write("              \t<a class=\"btn btn-info btn-sm\">已完成</a>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("              ");

          		}else{
              
      out.write("\n");
      out.write("              \t\n");
      out.write("              \t<a class=\"btn btn-danger btn-sm\" href=\"checkout.jsp?oid=");
      out.print(currentOrder.getOrderid());
      out.write('&');
      out.write('p');
      out.write('=');
      out.print(currentOrder.getPrice());
      out.write("\">未支付</a>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("              ");

          		}
              
      out.write("\n");
      out.write("                <a class=\"btn btn-danger btn-sm\" href=\"deleteorder?oid=");
      out.print(currentOrder.getOrderid());
      out.write("&uid=");
      out.print(uid);
      out.write("\">删除订单</a>\n");
      out.write("              </div>\n");
      out.write("              </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("               ");

               sql = "SELECT * FROM orderProduct t1 inner join commodities t2 on t1.commodityid=t2.commodityid WHERE orderid="+currentOrder.getOrderid()+"";
               List<OrderProduct> OCls = DBHelper.OrderCommodities(sql);
               OrderProduct currentOrderCommodities;
               for (int j = 0; j < OCls.size(); j++) {
            	   currentOrderCommodities = OCls.get(j);
          
            	   
      out.write("\n");
      out.write("            \t   <div class=\"col-6 col-sm-4 col-lg-3\">\n");
      out.write("                   <div class=\"card top-product-card mb-3\">\n");
      out.write("                     <div class=\"card-body\"><a class=\"product-thumbnail d-block\" href=\"single-product.html\"><img class=\"mb-2\" src=\"");
      out.print(currentOrderCommodities.getPicture());
      out.write("\" alt=\"\"></a><a class=\"product-title d-block\" href=\"single-product.html\">");
      out.print(currentOrderCommodities.getName());
      out.write("</a>\n");
      out.write("                       <p class=\"sale-price\">￥");
      out.print(currentOrderCommodities.getPrice());
      out.write("</p>\n");
      out.write("                       <div class=\"product-rating\"></div><a class=\"btn btn-success btn-sm add2cart-notify\" href=\"#\"><i>X");
      out.print(currentOrderCommodities.getNumber());
      out.write("</i></a>\n");
      out.write("                     </div>\n");
      out.write("                   </div>\n");
      out.write("                 </div>\n");
      out.write("            \t   ");

               }
               
      out.write("\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          \t\n");
      out.write("          \t");

          }
          
      out.write("\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- 引入JS -->\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/waypoints.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.easing.min.js\"></script>\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.animatedheadline.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.counterup.min.js\"></script>\n");
      out.write("    <script src=\"js/wow.min.js\"></script>\n");
      out.write("    <script src=\"js/jarallax.min.js\"></script>\n");
      out.write("    <script src=\"js/jarallax-video.min.js\"></script>\n");
      out.write("    <script src=\"js/default/jquery.passwordstrength.js\"></script>\n");
      out.write("    <script src=\"js/default/dark-mode-switch.js\"></script>\n");
      out.write("    <script src=\"js/default/active.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
