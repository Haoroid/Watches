<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
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
					<li class="active">结账</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeck-top heading">
				<h2>结账</h2>
			</div>
			<div class="ckeckout-top">
			<div class="cart-items">
			 <h3>我的购物车</h3>
				<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
			<script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
						$('.cart-header1').fadeOut('slow', function(c){
							$('.cart-header1').remove();
						});
						});	  
					});
			   </script>
			   <script>$(document).ready(function(c) {
					$('.close3').on('click', function(c){
						$('.cart-header2').fadeOut('slow', function(c){
							$('.cart-header2').remove();
						});
						});	  
					});
			   </script>
				
			<div class="in-check" >
				<ul class="unit">
					<li><span>商品</span></li>
					<li><span>商品名称</span></li>		
					<li><span>单价</span></li>
					<li><span>Delivery Details</span></li>
					<li> </li>
					<div class="clearfix"> </div>
				</ul>
				<ul class="cart-header">
					<div class="close1"> </div>
						<li class="ring-in"><a href="single.html" ><img src="images/c-1.jpg" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 290.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
					<div class="clearfix"> </div>
				</ul>
				<ul class=" cart-header1">
					<div class="close2"> </div>
						<li class="ring-in"><a href="single.html" ><img src="images/c-2.jpg" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 300.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
						<div class="clearfix"> </div>
				</ul>
				<ul class="cart-header2">
					<div class="close3"> </div>
						<li class="ring-in"><a href="single.html" ><img src="images/c-3.jpg" class="img-responsive" alt=""></a>
						</li>
						<li><span class="name">Analog Watches</span></li>
						<li><span class="cost">$ 360.00</span></li>
						<li><span>Free</span>
						<p>Delivered in 2-3 business days</p></li>
						<div class="clearfix"> </div>
				</ul>
			</div>
			</div>  
		 </div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>