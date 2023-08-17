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
    <title>购物车</title>
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
                   我的购物车
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
      		out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
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
      <div class="container-fluid cartList">

        <div class="cart-wrapper-area py-3">
          <div class="cart-table card mb-3">
            <div class="table-responsive card-body">
            <form action="" method="POST">
              <table class="table mb-0">
                <tbody>
                <%
				String sql = "SELECT * FROM cart t1 inner join good t2 on t1.goodid=t2.goodid WHERE userid="+uid;
				List<Good> ls = DBHelper.Cart(sql);
				//out.print("<script>alert('"+ls+"');</script>");
				session.setAttribute("sql",sql);
				Good currentCommodity;
				double p = 0;
				%>
                <%
				for (int i = 0; i < ls.size(); i++) {
					currentCommodity = ls.get(i) ;
					p+=currentCommodity.getPrice()*currentCommodity.getNumber();
				%>

	            	<tr  style="text-align: center;">
	            		
	                    <th scope="row">
	                    <a class="remove-product" href="cartdelete?cid=<%=currentCommodity.getGoodid()%>&uid=<%=uid%>"><i class="lni lni-close"></i></a>
	                    </th>
	                    
	                    <td><img src="<%=currentCommodity.getPicture()%>" alt=""></td>
	                    <td><a><%=currentCommodity.getName()%><span>￥<%=currentCommodity.getPrice()%></span></a></td>
	                    <td>
	                      <div class="quantity ">
	                      <%
	                      	if(currentCommodity.getNumber() == 0){
	                      		%>
	                      			<a href="cartdelete?cid=<%=currentCommodity.getGoodid()%>&uid=<%=uid%>"><i class="lni lni-cross-circle"></i></a>
	                      		<%
	                      	}else{
	                      		%>
                      				<a href="cartminus?cid=<%=currentCommodity.getGoodid()%>&uid=<%=uid%>&num=<%=currentCommodity.getNumber()%>"><i class="lni lni-circle-minus"></i></a>
                      			<%
	                      	}
	                      %>
	                        <input class="qty-text" type="text" disabled="disabled" value="<%=currentCommodity.getNumber()%>">
	                        <a href="cartplus?cid=<%=currentCommodity.getGoodid()%>&uid=<%=uid%>&num=<%=currentCommodity.getNumber()%>"><i class="lni lni-circle-plus"></i></a>
	                      </div>
	                    </td>
	                  </tr>
	                  
	            <%
				}
				%>
                  
                  
                </tbody>
              </table>
              </form>
            </div>
          </div>
          <div class="card cart-amount-area">
            <div class="card-body d-flex align-items-center justify-content-between">
              <h5 class="total-price mb-0">¥<span class="counter"><%=p %></span></h5><a class="btn btn-warning" href="placeorder?p=<%=p %>&uid=<%=uid%>">下单</a>
            </div>
          </div>
        </div>
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