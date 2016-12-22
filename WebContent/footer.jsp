<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>页脚</title>
</head>
<body>
<div class="information">
		<div class="container">
			<div class="infor-top">
				<div class="col-md-3 infor-left">
					<h3>关注我们</h3>
					<ul>
						<li><a href="#"><span class="fb"></span><h6>Facebook</h6></a></li>
						<li><a href="#"><span class="twit"></span><h6>Twitter</h6></a></li>
						<li><a href="#"><span class="google"></span><h6>Google+</h6></a></li>
					</ul>
				</div>
				<div class="col-md-3 infor-left">
					<h3>信息</h3>
					<ul>
						<li><a href="#"><p>特价</p></a></li>
						<li><a href="#"><p>新产品</p></a></li>
						<li><a href="#"><p>我们的商店</p></a></li>
						<li><a href="contact.jsp"><p>联系我们</p></a></li>
						<li><a href="#"><p>畅销产品</p></a></li>
					</ul>
				</div>
				<div class="col-md-3 infor-left">
					<h3>我的账户</h3>
					<ul>
						<li><a href="account.jsp"><p>我的账户</p></a></li>
						<li><a href="#"><p>我的信用额</p></a></li>
						<li><a href="#"><p>我的退款</p></a></li>
						<li><a href="#"><p>我的个人信息</p></a></li>
						<li><a href="#"><p>我的地址</p></a></li>
					</ul>
				</div>
				<div class="col-md-3 infor-left">
					<h3>商店信息</h3>
					<h4>公司名称,
						<span>东软睿道,</span>
						成都基地.</h4>
					<h5>+955 123 4567</h5>	
					<p><a href="mailto:example@email.com">123456@qq.com</a></p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-6 footer-left">
					<form>
						<input type="text" value="Enter Your Email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Enter Your Email';}">
						<input type="submit" value="Subscribe">
					</form>
				</div>
				<div class="col-md-6 footer-right">					
					<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="manager_login.jsp">后台管理</a></p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
</html>