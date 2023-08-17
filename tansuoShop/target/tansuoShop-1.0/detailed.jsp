<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags-->
    <!-- Title-->
    <title>商品详情</title>
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
//			out.print("<script>alert('您还未登陆');window.location='login.jsp'</script>");
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
                   商品详情页
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
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	double p = Double.parseDouble(request.getParameter("p"));
	int cid = Integer.parseInt(request.getParameter("cid"));
	String name = request.getParameter("name");
	String src = request.getParameter("src");

%>
    <div class="goodsContent container-fluid d-flex flex-wrap">
        <div class="goodsImg">
            <img src="<%=src %>"/>
        </div>
        <div class="goodsDetail">
            <h6 class="mb-1"><%=name %></h6>
            <p class="salePrice mb-0">￥<%=p %></p>
            <ul>
                <li>4/3 CMOS 哈苏相机</li>
                <li>5.1K/50fps 专业影像</li>
                <li>哈苏自然色彩解决方案</li>
                <li>46 分钟飞行时间</li>
                <li>全向避障</li>
                <li>15 公里高清图传</li>
                <li>高级智能返航</li>
                <li>夜景视频</li>
            </ul>
            <form class="cart-form" action="buy?p=<%=p %>&uid=<%=uid %>&cid=<%=cid %>" method="post">
               <div class="d-flex numberController">
                  <button class="reduce" type="button" disabled>-</button>
                   <input class="form-control" name="number" type="text" value="1" readonly id="numberVal">
                   <button class="add" type="button">+</button>
               </div>
              <div>
                  <button class="btn btn-danger mr-2"  type="submit">立即购买</button>
                  <a class="btn btn-warning" href="addcart?uid=<%=uid %>&cid=<%=cid %>">加入购物车</a>
              </div>
               <div class="tips">温馨提示 ·支持7天无理由退货</div>

            </form>
        </div>
    </div>
    <div class="container-fluid d-none d-sm-block" style="background: white;  box-shadow: 0 6px 18px 0 rgb(60 70 79 / 10%)">
        <div class="row foot">
            <div>
                <div>
                    <img height="48px"
                         src="//stormsend1.djicdn.com/stormsend/uploads/794e0300-98af-0136-ac4e-1237445f15bc/truck-moving.svg"
                         alt="全场满 ¥99 包邮<br>">
                </div>
                <p>全场满 ¥99 包邮<br></p></div>
            <div>
                <div>
                    <img height="48px"
                         src="//stormsend1.djicdn.com/stormsend/uploads/7bab98b0-98af-0136-ac4f-1237445f15bc/credit-card.svg"
                         alt="支持支付宝、微信、银联、银行转账<br>支持花呗、京东白条和招行分期"></div>
                <p>支持支付宝、微信、银联、银行转账<br>支持花呗、京东白条和招行分期</p>
            </div>
            <div>
                <div>
                    <img height="48px"
                         src="//stormsend1.djicdn.com/stormsend/uploads/7d9fa690-98af-0136-ac50-1237445f15bc/comment-alt-smile.svg"
                         alt="联系我们：<a> 在线支持</a>">
                </div>
                <p>联系我们：<a
                        href="#"
                        target="_blank" style="color:#0070d5; text-decoration:none;"> 在线支持</a></p></div>
            <div>
                <div><a href="#" target="_blank">
                    <img src="https://szcert.ebs.org.cn/Images/newGovIcon.gif" title="深圳市市场监督管理局企业主体身份公示"
                         alt="深圳市市场监督管理局企业主体身份公示" width="112" height="40" border="0"
                         style="border-width:0px;border:hidden; border:none;"></a>
                </div>
            </div>
        </div>
        <div class="description">Copyright © 2022 yixiaochuan 网站问题反馈？点击这里</div>
    </div>
    <div class="d-block d-sm-none" style="background: black;color: white;text-align: center;padding: 0.8rem 0; margin: 1rem 0 0;">探索小店</div>
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
    <script>
        let reduce=document.querySelector(".reduce");
        let add=document.querySelector(".add");
        let numberVal=document.querySelector("#numberVal");
        reduce.onclick=function () {
            let value=parseInt(numberVal.value)-1;
            numberVal.value=value;
            if(value==1){
                reduce.setAttribute("disabled","true");
            }
        }
        add.onclick=function () {
            let value=parseInt(numberVal.value)+1;
            numberVal.value=value;
            if(value>1){
                reduce.removeAttribute("disabled");
            }
        }

    </script>
  </body>
</html>