<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>account</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
<script src="js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="js/simpleCart.min.js"> </script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="js/jquery.easydropdown.js"></script>	
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
					<li class="active">账户</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--account-starts-->
	<div class="account">
		<div class="container">
		<div class="account-top heading">
				<h2>账户</h2>
			</div>
			<div class="account-main">
				<div class="col-md-6 account-left">
					<h3>现有的账户</h3>
					<div class="account-bottom">
						<input placeholder="邮箱" type="text" tabindex="3" required>
						<input placeholder="密码" type="password" tabindex="4" required>
						<div class="address">
							<a class="forgot" href="#">忘记您的密码？</a>
							<input type="submit" value="登录">
						</div>
					</div>
				</div>
				<div class="col-md-6 account-right account-left">
					<h3>新用户？ 创建一个账户</h3>
					<p>通过创建一个帐户与我们的商店，您将能够通过结帐过程更快，存储多个送货地址，查看和跟踪您的订单在您的帐户和更多。</p>
					<a href="register.jsp">创建一个账户</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>