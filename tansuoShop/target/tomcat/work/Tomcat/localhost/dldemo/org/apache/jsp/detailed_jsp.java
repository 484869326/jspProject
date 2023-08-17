/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-11-23 07:23:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detailed_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags-->\n");
      out.write("    <!-- Title-->\n");
      out.write("    <title>商品详情</title>\n");
      out.write("\n");
      out.write("    <link rel=\"icon\" href=\"img/core-img/favicon.ico\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"preloader\" id=\"preloader\">\n");
      out.write("      <div class=\"spinner-grow text-secondary\" role=\"status\">\n");
      out.write("        <div class=\"sr-only\">加载中...</div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Header Area-->\n");
      out.write("    <div class=\"header-area\" id=\"headerArea\">\n");
      out.write("      <div class=\"container h-100 d-flex align-items-center justify-content-between\">\n");
      out.write("\n");
      out.write("        <div class=\"back-button\"><a href=\"index.jsp\"><i class=\"lni lni-home\"></i></a></div>\n");
      out.write("\n");
      out.write("        <div class=\"page-heading\">\n");
      out.write("          <h6 class=\"mb-0\">商品详情</h6>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"suha-navbar-toggler d-flex justify-content-between flex-wrap\" id=\"suhaNavbarToggler\"><span></span><span></span><span></span></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"sidenav-black-overlay\"></div>\n");
      out.write("\n");
      out.write("    <!-- 左侧导航栏start -->\n");
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

	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	double p = Double.parseDouble(request.getParameter("p"));
	int cid = Integer.parseInt(request.getParameter("cid"));
	String name = request.getParameter("name");
	String src = request.getParameter("src");


      out.write("\n");
      out.write("    <div class=\"page-content-wrapper\">\n");
      out.write("      <!-- Product Slides-->\n");
      out.write("      <div class=\"product-slides owl-carousel\">\n");
      out.write("      \n");
      out.write("        <div class=\"single-product-slide\" style=\"background-image: url('");
      out.print(src );
      out.write("')\"></div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <div class=\"product-description pb-3\">\n");
      out.write("\n");
      out.write("        <div class=\"product-title-meta-data bg-white mb-3 py-3\">\n");
      out.write("          <div class=\"container d-flex justify-content-between\">\n");
      out.write("            <div class=\"p-title-price\">\n");
      out.write("              <h6 class=\"mb-1\">");
      out.print(name );
      out.write("</h6>\n");
      out.write("              <p class=\"sale-price mb-0\">￥");
      out.print(p );
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"product-ratings\">\n");
      out.write("            <div class=\"container d-flex align-items-center justify-content-between\">\n");
      out.write("              <div class=\"ratings\"><i class=\"lni lni-star-filled\"></i><i class=\"lni lni-star-filled\"></i><i class=\"lni lni-star-filled\"></i><i class=\"lni lni-star-filled\"></i><i class=\"lni lni-star-filled\"></i></div>\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"cart-form-wrapper bg-white mb-3 py-3\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("            <form class=\"cart-form\" action=\"buy?p=");
      out.print(p );
      out.write("&uid=");
      out.print(uid );
      out.write("&cid=");
      out.print(cid );
      out.write("\" method=\"post\">\n");
      out.write("              <input class=\"form-control\" name=\"number\" type=\"text\" value=\"1\">\n");
      out.write("              <button class=\"btn btn-danger mr-2\"  type=\"submit\">立即购买</button>\n");
      out.write("              <a class=\"btn btn-warning\" href=\"addcart?uid=");
      out.print(uid );
      out.write("&cid=");
      out.print(cid );
      out.write("\">加入购物车</a>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
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
      out.write("    \n");
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
