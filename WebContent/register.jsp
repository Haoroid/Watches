<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="js/jquery-1.11.0.min.js"></script>
<!--Custom Theme files-->
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

	<div class="register">
		<div class="container">
			<div class="register-top heading">
				<h2>用户注册</h2>
			</div>
			<div class="register-main">
				<div class="col-md-6 account-left">
					<input placeholder="用户名" type="text" tabindex="1" required>
						<input placeholder="真实姓名" type="text" tabindex="2" required>
						<input placeholder="邮箱" type="text" tabindex="3" required>
						<input placeholder="手机" type="text" tabindex="3" required>
						<ul>
							<li><label class="radio left"><input type="radio" name="radio" checked=""><i></i>男</label></li>
							<li><label class="radio"><input type="radio" name="radio"><i></i>女</label></li>
							<div class="clearfix"></div>
						</ul>
				</div>
				<div class="col-md-6 account-left">
					<input placeholder="密码" type="password" tabindex="4" required>
						<input placeholder="确认密码" type="password" tabindex="4" required>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="address submit">
							<input type="submit" value="注册">
						</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>