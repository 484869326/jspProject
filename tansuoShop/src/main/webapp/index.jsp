<%@page import="com.JavaBean.Good" %>
<%@page import="com.JavaBean.DBHelper" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>首页</title>
    <link rel="icon" href="img/core-img/favicon.ico">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="./css/swiper.css">
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
                <form action="search.jsp" method="POST">
                    <input class="form-control" name="name" type="text" placeholder="输入商品名称">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <!-- 导航栏 -->
            <div class="col-3 col-md-3 col-lg-2 d-flex justify-content-center rightMenu">

                <%
                    if (uid.equals("")) {
                %>
                <div class="noLogin">
                    <a href="login.jsp">登录</a>
                    <a href="register.jsp">注册</a>
                </div>
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
                    <%
                        //是管理员才能显示商品管理
                        if (nickname.equals("管理员")) {
                    %>
                    <ul class="AdminController">
                        <%
                            }else{
                        %>
                        <ul class="AdminController noAdminController">
                        <%
                            }
                        %>
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


<div class="swiper">
    <div class="swiperItem">
        <ul class="ulist">
            <li><img src="./img/swiper/swiper1.jpg" alt=""></li>
            <li><img src="./img/swiper/swiper2.jpg" alt=""></li>
            <li><img src="./img/swiper/swiper3.jpg" alt=""></li>
            <li><img src="./img/swiper/swiper4.jpg" alt=""></li>
        </ul>
    </div>
    <div class="swiperRadius">
        <ul class="rlist">
            <li class="active"></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <span class="prev"></span>
    <span class="next"></span>
</div>
<%
    //定义当前页显示数量
    int pageSize = 8;
//获取类型的id
    String type = request.getParameter("typeid");
    if (type == null) {
        type = "1";
    }
    int typeid = Integer.parseInt(type);
//查询出改类型id下的商品总数
    DBHelper.getCount(typeid);
//获取页码
    int totalpages = DBHelper.getTotalpages(pageSize);
    String currentPage = request.getParameter("pageIndex");
    if (currentPage == null) {
        currentPage = "1";
    }
    int pageIndex = Integer.parseInt(currentPage);
    if (pageIndex < 1) {
        pageIndex = 1;
    } else if (pageIndex > totalpages) {
        pageIndex = totalpages;
    }
//根据类型id查询商品
    String sql = "SELECT * FROM good t1 inner join category t2 on t1.typeid=t2.typeid WHERE t1.typeid=" + type + " AND state=TRUE Limit " + (pageIndex - 1) * pageSize + "," + pageSize;
    List<Good> ls = DBHelper.Goods(sql);
    Good currentCommodity;
%>

<div class="container-fluid" style="background: white; box-shadow: 0 6px 18px 0 rgb(60 70 79 / 10%);">
    <div class="container-fluid categoryList">
        <ul class="row categoryUlist">
            <li><a>航拍无人机</a></li>
            <li><a>手持拍摄设备</a></li>
            <li><a>增值服务</a></li>
        </ul>
    </div>
</div>
<!-- 商品展示 -->
<div class="top-products-area clearfix">
    <div class="container-fluid">
        <div class="row">
            <!-- 商品 -->
            <%
                for (int i = 0; i < ls.size(); i++) {
                    currentCommodity = ls.get(i);
                    if (currentCommodity.getState()) {


            %>
            <div class="col-6 col-sm-4 col-lg-3">
                <div class="card top-product-card mb-3">
                    <div class="card-body">
                        <a class="product-thumbnail d-block"
                           href="detailed.jsp?src=<%=currentCommodity.getPicture()%>&name=<%=currentCommodity.getName()%>&cid=<%=currentCommodity.getGoodid()%>&p=<%=currentCommodity.getPrice()%>">
                            <img class="mb-2" src="<%=currentCommodity.getPicture()%>" alt="">
                        </a>
                        <%
                        if(typeid==3){
                        %>
                        <a class="product-title  titleEllipsis">
                            <%
                                }else{
                            %>
                                <a class="product-title  oneElipsis">
                            <%
                                }
                            %>
                            <%=currentCommodity.getName()%>
                        </a>
                        <p class="sale-price">￥<%=currentCommodity.getPrice()%>
                        </p>
                        <a href="addcart?uid=<%=uid%>&cid=<%=currentCommodity.getGoodid()%>&typeid=<%=typeid%>&pageIndex=<%=pageIndex%>"
                           class="btn btn-success btn-sm add2cart-notify">
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
    <%
        //分页显示按钮
        if (pageIndex > 1) {
    %>
    <a href="index.jsp?typeid=<%=typeid%>&pageIndex=1">
        <button type="button" class="btn btn-info">首页</button>
    </a>
    <a href="index.jsp?typeid=<%=typeid%>&pageIndex=<%=pageIndex-1%>">
        <button type="button" class="btn btn-info">上一页</button>
    </a>
    <%
        }
        if (pageIndex < totalpages) {
    %>
    <a href="index.jsp?typeid=<%=typeid%>&pageIndex=<%=pageIndex+1%>">
        <button type="button" class="btn btn-info">下一页</button>
    </a>
    <a href="index.jsp?typeid=<%=typeid%>&pageIndex=<%=totalpages%>">
        <button type="button" class="btn btn-info">末页</button>
    </a>
    <%
        }
    %>
</div>
</div>
<!-- 底部-->
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
<div class="d-block d-sm-none"
     style="background: black;color: white;text-align: center;padding: 0.8rem 0; margin: 1rem 0 0;">探索小店
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
<script src="js/swiper.js"></script>
<script>
    let typeId;
    try {
        typeId = window.location.href.split("?")[1].split("=")[1][0];
        typeId -= 1;

    } catch (e) {
        typeId = 0;
    }
    let categoryUlist = document.querySelector(".categoryUlist").children;
    let categoryActive = categoryUlist[typeId];
    categoryActive.classList.add("categoryActive");
    for (let i = 0; i < categoryUlist.length; i++) {
        categoryUlist[i].onclick = function (e) {
            e.preventDefault();
            categoryActive.classList.remove("categoryActive");
            categoryActive = this;
            this.classList.add("categoryActive");
            window.location.href = "index.jsp?typeid=" + (i + 1) + "";
        }
    }
</script>
</body>
</html>