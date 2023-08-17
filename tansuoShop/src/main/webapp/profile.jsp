<%@page import="com.JavaBean.DBHelper" %>
<%@page import="com.JavaBean.Users" %>
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
    <title>个人信息</title>
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
                    个人信息
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
    
          <%
          	String sql = "SELECT * FROM users WHERE userid='"+uid+"'";
			List<Users> ls = DBHelper.Profile(sql);
			Users currentProfile = new Users();
			
			try{
				currentProfile = ls.get(0);
			}catch (Exception e) {
				out.print("<script>alert('您还未登录');window.location='login.jsp'</script>");
			}finally {
				
			}
          %>
    <div class="page-content-wrapper">
      <div class="container-fluid cartList">
        <!-- Profile Wrapper-->
        <div class="profile-wrapper-area py-3">
          <!-- User Information-->
          <div class="card user-info-card">
            <div class="card-body p-4 d-flex align-items-center">
              <div class="user-profile mr-3"><img src="./img/User/admin.jpg" alt="">
                <div class="change-user-thumb">	
                </div>
              </div>
              <div class="user-info">
                <p class="mb-0 text-white">用户ID</p>
                <h5 class="mb-0" style="color: white;"><%=uid%></h5>
              </div>
            </div>
          </div>
          <!-- 用户信息 -->
          <div class="card user-data-card">
            <div class="card-body">
              <form action="doprofile" method="POST">
                <div class="form-group">
                  <div class="title mb-2"><i class="lni lni-user"></i><span>昵称</span></div>
                  <input class="form-control" name="nickname" type="text" disabled="disabled" value="<%=currentProfile.getNickname()%>">
                </div>
                <div class="form-group">
                  <div class="title mb-2"><i class="lni lni-user"></i><span>真实姓名</span></div>
                  <input class="form-control" name="name" type="text" disabled="disabled" value="<%=currentProfile.getName()%>">
                </div>
                <div class="form-group">
                  <div class="title mb-2"><i class="lni lni-phone"></i><span>电话</span></div>
                  <input class="form-control" name="telephone" type="text" disabled="disabled" value="<%=currentProfile.getTelephone()%>">
                </div>
                <div class="form-group">
                  <div class="title mb-2"><i class="lni lni-envelope"></i><span>邮箱</span></div>
                  <input class="form-control" name="mail" type="email" disabled="disabled" value="<%=currentProfile.getMail()%>">
                </div>
                <div class="form-group">
                  <div class="title mb-2"><i class="lni lni-map-marker"></i><span>地址</span></div>
                  <input class="form-control" name="address" type="text" disabled="disabled" value="<%=currentProfile.getAddress()%>">
                </div>
                <button id="save" style="display:none;" class="btn btn-success w-100" type="submit">保存修改</button>
              </form>
              <button id="edito" style="display:block;" class="btn btn-info w-100">修改</button>
            </div>
          </div>
        </div>
      </div>
    </div>
	<script>
		var a = document.getElementsByTagName("input");
		document.getElementById("edito").onclick = function() {
			//document.getElementById("save").style.display = "block";
			document.getElementById("save").removeAttribute("style");
			document.getElementById("edito").style.display = "none";
			for (var i=0;i<5;i++){ 
				a[i].removeAttribute("disabled");
			}
		}
	</script>
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
    <script src="js/default/active.js"></script>
  </body>
</html>