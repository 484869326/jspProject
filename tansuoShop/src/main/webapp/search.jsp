<%@page import="com.JavaBean.Good" %>
<%@page import="com.JavaBean.DBHelper" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>搜索结果</title>
    <link rel="icon" href="img/core-img/favicon.ico">
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <div class="preloader" id="preloader">
      <div class="spinner-grow text-secondary" role="status">
        <div class="sr-only">加载中...</div>
      </div>
    </div>
    <%
        String nickname = "";
        String uid = "";
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
			out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("nickname")) {
                    nickname = cookies[i].getValue();
                } else if (cookies[i].getName().equals("uid")) {
                    uid = cookies[i].getValue();
                }

            }
        }
    %>
    <!-- 顶部搜索start -->
    <div class="header-area" id="headerArea">
        <div class="container-fluid h-100 d-flex  justify-content-between">
            <div class="row align-items-center" style="width: 100%">
                <!-- Logo -->
                <div class="logo-wrapper col-2  col-md-2 col-lg-2"><a href="index.jsp"><img src="./img/core-img/logo.png"
                                                                                            class="logoImg" alt=""></a></div>
                <!-- 搜索框 -->
                <div class="top-search-form col-7  col-md-7 col-lg-8 d-flex justify-content-center">
                    搜索结果
                </div>
                <!-- 导航栏 -->
                <div class="col-3 col-md-3 col-lg-2 d-flex justify-content-center rightMenu">

                    <%
                        if (uid.equals("")) {
                    %>
                    out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
                    <% } else if (uid != null && nickname != null) {
                    %>
                    <div class="navbar-toggler  flex-wrap d-sm-block" id="NavbarToggler"><span></span><span></span><span></span></div>

                    <div class="isAdmin d-none  d-sm-block">
                        <ul class="adminContent align-items-center">
                            <li class="imgSrc">
                                <img src="./img/User/admin.jpg" />
                            </li>
                            <li class="arrow">
                                <span><%=nickname%></span>
                                <img src="./img/User/right-arrow.png">
                            </li>
                        </ul>
                        <ul class="AdminController">
                            <li><a href="profile.jsp"><i class="lni lni-pointer-up"></i>修改个人资料</a></li>
                            <li><a href="orders.jsp"><i class="lni lni-empty-file"></i>我的订单</a></li>
                            <%
                                //是管理员才能显示商品管理
                                if (nickname.equals("管理员")) {
                            %>
                            <li><a href="management.jsp"><i class="lni lni-grid-alt"></i>商品管理</a></li>
                            <%
                                }
                            %>
                            <li><a href="cart.jsp"><i class="lni lni-cart-full"></i>购物车</a></li>
                            <li><a href="signout"><i class="lni lni-power-switch"></i>退出登录</a></li>
                        </ul>
                    </div>

                    <%
                        } else {
//                            out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
                        }
                    %>
                </div>
            </div>
        </div>
        <ul class="AdminController">
            <li><a href="profile.jsp"><i class="lni lni-pointer-up"></i>修改个人资料</a></li>
            <li><a href="orders.jsp"><i class="lni lni-empty-file"></i>我的订单</a></li>
            <%
                //是管理员才能显示商品管理
                if (nickname.equals("管理员")) {
            %>
            <li><a href="management.jsp"><i class="lni lni-grid-alt"></i>商品管理</a></li>
            <%
                }
            %>
            <li><a href="cart.jsp"><i class="lni lni-cart-full"></i>购物车</a></li>
            <li><a href="signout"><i class="lni lni-power-switch"></i>退出登录</a></li>
        </ul>
    </div>
    <!-- 顶部搜索start -->
    <div class="sidenav-black-overlay"></div>


    <div class="page-content-wrapper">

      
<%
//定义当前页显示数量
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");

String name = new String(request.getParameter("name").getBytes("iso8859-1"),"UTF-8"); 
String sql = "SELECT * FROM good t1 inner join category t2 on t1.typeid=t2.typeid WHERE t1.name LIKE '%"+name+"%' AND state=TRUE";
List<Good> ls = DBHelper.Goods(sql);
Good currentCommodity;
%>

      <!-- 商品展示 -->
      
      <div class="product-catagories-wrapper pt-3">
        <div class="container">
          <div class="row">
            <!-- 商品 -->
            <%
				for (int i = 0; i < ls.size(); i++) {
					currentCommodity = ls.get(i);
					if(currentCommodity.getState()){
						
					
			%>
            <div class="col-6 col-sm-4 col-lg-3">
              <div class="card top-product-card mb-3">
                <div class="card-body"><a class="product-thumbnail d-block" href="detailed.jsp?src=<%=currentCommodity.getPicture()%>&name=<%=currentCommodity.getName()%>&cid=<%=currentCommodity.getGoodid()%>&p=<%=currentCommodity.getPrice()%>">
                <img class="mb-2" src="<%=currentCommodity.getPicture()%>" alt=""></a><a class="product-title d-block"><%=currentCommodity.getName()%></a>
                  <p class="sale-price">￥<%=currentCommodity.getPrice()%></p>
                  <div class="product-rating">
                  <i class="lni lni-star-filled"></i>
                  <i class="lni lni-star-filled"></i>
                  <i class="lni lni-star-filled"></i>
                  <i class="lni lni-star-filled"></i>
                  <i class="lni lni-star-filled"></i>
                  </div>
                  <a href="addcart?uid=<%=uid%>&cid=<%=currentCommodity.getGoodid()%>&name=<%=name %>" class="btn btn-success btn-sm add2cart-notify">
                  <i class="lni lni-plus">
                  </i>
                  </a>
                </div>
              </div>
            </div>
            <%
					}
				}
			%>
          </div>
        </div>
      </div>
      <div class="text-center">
      </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.animatedheadline.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jarallax.min.js"></script>
    <script src="js/jarallax-video.min.js"></script>
    <script src="js/default/jquery.passwordstrength.js"></script>
    <script src="js/default/dark-mode-switch.js"></script>
    <script src="js/default/active.js"></script>
  </body>
</html>