<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name = "format-detection" content = "telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="booking/css/booking.css">
		<link rel="stylesheet" href="css/camera.css">
		<link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/mystyle.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
	
	<!--	<script src="js/jquery.js"></script> -->
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/superfish.js"></script>
		
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/owl.carousel.js"></script>
		<script src="js/camera.js"></script>
		<script src="js/jquery.mobile.customized.min.js"></script>
		<!--<![endif]-->
		<script src="booking/js/booking.js"></script>
	</head>
	<body class="page1" id="top">
		<div class="main">
		
		
		
<!--==============================header=================================-->
			<header>
			<div>
			<div style="width:100;background-color:black">
			<div class="jumbotron" style="background-color:black;height:120px">
			<div class="row">
			<div class="col-md-3">
			<a href="index.html" >
								<img src="images/logo.jpg" style="height:60px;width:200px;float:left;margin-left:80px;">
							</a></div>
							<div class="col-md-9">
				
						<nav class="navbar" style="float:left">
								<ul class="sf-menu" >
									<li class="current" ><a href="index.html">Home</a></li>
									<li><a href="index-1.html" style="background-color:black;color:white;text-decoration:none">About</a></li>
									<li><a href="index-2.html" style="background-color:black;color:white;text-decoration:none">Cars</a></li>
									<li><a href="index-3.html" style="background-color:black;color:white;text-decoration:none">Services</a></li>
									<li><a href="index-4.html" style="background-color:black;color:gold;text-decoration:none">Be a Renter</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
				</div>
				
			</header>
<!--=====================================================================-->

<div class="container" align="center" style="padding:50px">
 <table><b>
<br/><br/><tr><td><input class="login" type="text"required name="username" onkeypress="return AlphaNumeric()" placeholder="Username" maxlength="10"></td></tr>
 <tr><td><input class="login" type="password"required name="password" placeholder="Password" maxlength="32"> </td></tr>
 <tr><td><input type="submit" style="padding:10px" value="LogIn" class="btn btn-gold">
 <button type="button" onclick="window.location.href='signup.jsp'" style="padding:10px"  class="btn btn-gold"> SignUp </button> </td></tr>
 </form> 
</table> 
<div style="padding:20px;text-decoration:none" ><a> Forgot Password? </a></div>
</div>
<!--==============================footer=================================-->
		<footer>
		<div class="jumbotron" style="background-color:black">
			<div class="container_12">
				<div class="grid_12">
					<div class="f_phone" style="font-size:25px">Call Us :+ 1 201 626 0675</div>
					<div class="socials">
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>
					<div class="copy">
						<div class="st1">
						<div class="brand"><span class="color1">InfyMiles</span></div>
						&copy; 2017	| <a href="#">Privacy Policy</a> </div> 
					</div>
				</div>
				<div class="clear"></div>
			</div>
			</div>
		</footer>
		<script>
			$(function (){
				$('#bookingForm').bookingForm({
					ownerEmail: '#'
				});
			})
			$(function() {
				$('#bookingForm input, #bookingForm textarea').placeholder();
			});
		</script>
	</body>
</html>