<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册</title>
    <link rel="icon" href="img/core-img/favicon.ico">
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <div class="preloader" id="preloader">
      <div class="spinner-grow text-secondary" role="status">
        <div class="sr-only">加载中...</div>
      </div>
    </div>
    <div class="login-wrapper d-flex align-items-center justify-content-center text-center">
      <!-- Background Shape-->
      <div class="background-shape"></div>
      <div class="container-fluid">

        <div class="row justify-content-center align-items-center">
          <div class="col-md-4 col-lg-6 col-xl-8 loginBg  d-none d-lg-block ">
            <a href="index.jsp">
            <img src="img/core-img/loginBg.png">
            </a>
          </div>
          <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-4 loginBox">
            <a href="index.jsp">
            <img class="big-logo" src="img/core-img/logo.png" alt="">
            <p>探索小店</p>
            </a>
            <div class="register-form mt-5 px-4">
              <form action="doregister" method="post">
                <div class="form-group text-left mb-4"><span>用户名</span>
                  <input name="username" class="form-control" id="username" type="text" placeholder="请输入用户名">
                </div>
                <div class="form-group text-left mb-4"><span>手机号</span>
                  <input name="tel" class="form-control" id="tel" type="text" placeholder="请输入手机号">
                </div>
                <div class="form-group text-left mb-4"><span>邮箱</span>
                  <input name="email" class="form-control" id="email" type="email" placeholder="请输入邮箱">
                </div>
                <div class="form-group text-left mb-4"><span>密码</span>
                  <input name="pwd" class="input-psswd form-control" id="registerPassword" type="password" placeholder="请输入密码">
                </div>
                <div class="form-group text-left mb-4"><span>验证码</span>
                  <div class="row veriCode">
                    <input name="checkCode" class="form-control" id="verification" type="text" placeholder="请输入验证码">
                    <a href="javascript:reloadCode();" class="imagecodeFather">
                      <img alt="验证码" id="imagecode" src="<%= request.getContextPath()%>/verification"/>
                    </a>
                  </div>
                </div>
                <button class="btn btn-success btn-lg w-100">注册</button>
              </form>
            </div>

            <div class="login-meta-data">
              <p class="mt-3 mb-0">已经有了账户？<a class="ml-1" href="login.jsp">立即登录</a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- All JavaScript Files-->
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
	<script type="text/javascript">
	function reloadCode() {
		var time=new Date().getTime();
		document.getElementById("imagecode").src="<%= request.getContextPath()%>/verification?d="+time;
	}
	</script>
  </body>
</html>