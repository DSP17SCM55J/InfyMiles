<!DOCTYPE html>
<%@page import = "java.util.*"%>
<html lang="en">
	<head>
		<title>InfyMiles</title>
		<meta charset="utf-8">
		<meta name = "format-detection" content = "telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="booking/css/booking.css">
		<link rel="stylesheet" href="css/camera.css">
		<link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/mystyle.css">
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
	

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
		<script src="booking/js/booking.js"></script>
		<script>
			$(document).ready(function(){
				jQuery('#camera_wrap').camera({
					loader: false,
					pagination: false ,
					minHeight: '444',
					thumbnails: false,
					height: '28.28125%',
					caption: true,
					navigation: true,
					fx: 'mosaic'
				});
				$().UItoTop({ easingType: 'easeOutQuart' });
			});
			
		</script>
	</head>
	<body class="page1" id="top">
		<div class="main">
<!--==============================header=================================-->
<%
if (request.getParameter("logout")!=null)
		session.invalidate();
if (request.getParameter("check")==null)
response.sendRedirect("LoadData");
else if (request.getAttribute("carlist")==null)
response.sendRedirect("ShowHomeCars");
else{
	
	%>
			<header>
			<div>
			<div class="jumbotron" style="background-color:black;padding:30px">
			<div class="row">
			<div class="col-md-3">
			<a href="home.jsp">
							<img src="images/logo.jpg" style="height:60px;width:200px;float:left;margin-left:80px;">
							</a></div>
							<div class="col-md-9">
				
						<nav class="navbar" style="float:left">
								<ul class="sf-menu" >
									
									<li><form action="AutoCompleteSearchServlet">
        <input type="text" name="search" id="search" class="input_search" style="font-size:20px;width:500px;height:38px" placeholder="Search Cars...."></li>
		
		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
		<script>
		jQuery(function(){
		$("#search").autocomplete("AutoCompleteServlet");
		});
		</script>
   <li> <button type="submit" style="height:38px" class="btn btn-default">
        <span class="glyphicon glyphicon-search"></span>
    </button>
</form></li><
<%String username = (String) session.getAttribute("username");
if (username==null){%>
									<li><a href="login.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Log in</a></li>
									<li><a href="UserRegistration.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Sign up</a></li>
<%}else{%><li>
<div class="dropdown">
    <button class="btn dropdown-toggle" type="button" style="background-color:black;color:gold;" data-toggle="dropdown"><%out.println(username.toUpperCase());%>
    <span class="caret"></span></button>
    <ul class="dropdown-menu" style="top:35px;background-color:black;">
      <li><a href="ProfileServlet" style="color:gold">Profile</a></li>
      <li><a href="bookinghistory.jsp" style="color:gold">History</a></li>
	  <li><a href="home.jsp?logout=done"style="color:gold">Log Out</a></li>
    </ul>
  </div>
<%}%>
							<li><a href="trending.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Trending</a></li>	
								</ul>
							</nav>
						</div>
					</div>
				</div>
				
			</header>
			
<!--===================+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
<div align="center" style=" padding: 25px" id="get-start">
<form action="CarListservlet" method="Post">
 <input id="mapinput" type="text"required placeholder="Enter Location Zip" name="location" class="lot" style="font-size:20px;width:500px;height:50px">
          <script type="text/javascript">
  function initAutocomplete() {
    autocomplete = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */(document.getElementById('mapinput')),options);
  }

  var options = {
  types: ['(regions)'],
  componentRestrictions: {country:'us'}
};
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDg0JApm5ORuNN_4ypS8fx9gFGGMqJqpgI&libraries=places&callback=initAutocomplete"
         async defer></script>
		 
		 
 <input type="text" name="date" style="font-size:20px;width:500px;height:50px"/>
<script type="text/javascript">
$(function() {
	var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1;

var yyyy = today.getFullYear();
if(dd<10){
    dd='0'+dd;
} 
if(mm<10){
    mm='0'+mm;
} 
var today = mm+'/'+dd+'/'+yyyy;
    $('input[name="date"]').daterangepicker({
        "timePicker": true,
    "timePickerIncrement": 30,
    "dateLimit": {
        "days": 30
    },
    "startDate": today,
    "endDate": today,
    "minDate": today,
    "maxDate": "12/31/2017",
	 locale: {
            format: 'MM/DD/YYYY h:mm A'
}
}, function(start, end, label) {
  console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
});
});
</script>
 <input type="submit" value="Continue"/>
 </form>
</div>


<!--++++++++++++++++++++++++++++++++Carousel+++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
			
			
			<div class="slider_wrapper ">
				<div id="camera_wrap" class="">
					<div data-src="images/cor7.jpg" ></div>
					<div data-src="images/cor2.jpg" ></div>
					<div data-src="images/cor1.jpg"></div>
					<div data-src="images/cor4.jpg"></div>
					<div data-src="images/cor6.jpg"></div>
				</div>
			</div>

			
<div class="col-md-8 col-md-offset-2" style="padding-top:50px" ><div class="line" style="font-size:25px;padding"><span>Great Deals</span></div></div>
<div class="col-md-6 col-md-offset-3" style="padding-top:50px">

<div id="myCarousel" class="carousel slide">

<div class="carousel-inner">
    <div class="item active">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_1.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $22</b></span></h3>
		</div>
		</div>
    </div>
    <div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_2.jpeg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $32</b></span></h3>
		</div>
		</div>
    </div>
    <div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_3.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $79</b></span></h3>
		</div>
		</div>
    </div>
    <div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_4.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $65</b></span></h3>
		</div>
		</div>
    </div>
    <div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_5.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $100</b></span></h3>
		</div>
		</div>
    </div>
    <div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_6.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $119</b></span></h3>
		</div>
		</div>
    </div>
	<div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_7.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $45</b></span></h3>
		</div>
		</div>
    </div>
	<div class="item">
        <div class="col-xs-4"><a href="#"><img src="images/cor_2_8.jpg" class="img-responsive"></a>
		<div class="carousel-caption" style="top:-115px; left:-119px">
         <h3><span style="background-color:white;color:black;padding:10px" ><b> $42</b></span></h3>
		</div>
		</div>
    </div>
</div>

<!-- Controls -->
<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
	
</a>
<script>

    $('#myCarousel').carousel({
        interval: 10000
    });

    $('.carousel .item').each(function(){
        var next = $(this).next();
        if (!next.length) {
            next = $(this).siblings(':first');
        }
        next.children(':first-child').clone().appendTo($(this));

        if (next.next().length>0) {
            next.next().children(':first-child').clone().appendTo($(this));
        }
        else {
            $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
        }
    });

</script>

</div>
</div>
</div>

<!--==============================Content=================================-->

		<div class="container-fliud" style="clear:both;padding-left:100px;padding-bottom:70px;padding-top:70px">
			<div class="row">
				<div class="col-sm-2" >
					<div class="left-sidebar">
					<div><form action="LeftNavSearch" method="POST">
						<div class="line" style="font-size:25px"><span><b>Brand</b></span></div>
						<div class="brands-name" style="outline: 1px solid orange;">
								<ul class="nav nav-pills nav-stacked">
									<li><a>Audi  <span class="pull-right"><input type="checkbox" value="Audi" name="brand"/></span></a> </li> 
									<li><a>BMW  <span class="pull-right"><input type="checkbox" value="BMW" name="brand"/></span></a> </li>
									<li><a>Mercedes  <span class="pull-right"><input type="checkbox" value="Mercedes" name="brand"/></span></a> </li>
									<li><a>VolksWagen <span class="pull-right"><input type="checkbox" value="VolksWagen" name="brand"/></span></a> </li>
									<li><a>Ferrari<span class="pull-right"><input type="checkbox" value="Ferrari" name="brand"/></span></a> </li>
									<li><a>Toyota<span class="pull-right"><input type="checkbox" value="Toyota" name="brand"/></span></a> </li>
									<li><a>Honda<span class="pull-right"><input type="checkbox" value="Honda" name="brand"/></span></a> </li>
									<li><a>Chevrolet<span class="pull-right"><input type="checkbox" value="Chevrolet" name="brand"/></span></a> </li>
									<li><a>Mazda<span class="pull-right"><input type="checkbox" value="Mazda" name="brand"/></span></a> </li>
									<li><a>KIA<span class="pull-right"><input type="checkbox" value="KIA" name="brand"/></span></a> </li>
									<li><a>Range Rover<span class="pull-right"><input type="checkbox" value="Range Rover" name="brand"/></span></a> </li>
									<li><a>Rolls Royce<span class="pull-right"><input type="checkbox" value="Rolls Royce" name="brand"/></span></a> </li>
									<li><a>Bugatti<span class="pull-right"><input type="checkbox" value="Bugatti" name="brand"/></span></a> </li> 
									<li><a>Lamborghini<span class="pull-right"><input type="checkbox" value="Lamborghini" name="brand"/></span></a> </li>
									<li><a>Ford<span class="pull-right"><input type="checkbox" value="Ford" name="brand"/></span></a> </li>									
									<li><a>Jaguar<span class="pull-right"><input type="checkbox" value="Jaguar" name="brand"/></span></a> </li>									
									</ul>
							</div>
					
						<div class="brands_products" style="padding-bottom:20px;padding-top:20px"><!--brands_products-->
						<div class="line" style="font-size:20px"><span><b>Categories</b></span></div>
							<div class="brands-name" style="outline: 1px solid orange;" >
								<ul class="nav nav-pills nav-stacked">
									<li><a>Hatchback  <span class="pull-right"><input type="checkbox"  value="Hatchback" name="category"/></span></a> </li> 
									<li><a>Sedan  <span class="pull-right"><input type="checkbox" value="Sedan" name="category"/></span></a> </li>
									<li><a>Van  <span class="pull-right"><input type="checkbox" value="Van" name="category"/></span></a> </li>
									<li><a>SUV  <span class="pull-right"><input type="checkbox" value="SUV" name="category"/></span></a> </li>
									<li><a>Crossover  <span class="pull-right"><input type="checkbox" value="Crossover" name="category"/></span></a> </li>
									<li><a>Coupe  <span class="pull-right"><input type="checkbox" value="Coupe" name="category"/></span></a> </li>
									<li><a>Convertible  <span class="pull-right"><input type="checkbox" value="Convertible" name="category"/></span></a> </li></ul>
							</div>
						</div><!--/brands_products-->
						
						
						<div class="brands_products" style="padding-bottom:50px;padding-top:20px"><!--brands_products-->
						<div class="line" style="font-size:20px"><span><b>Select Price</b></span></div>
						<div class="brands-name" style="outline: 1px solid orange;" >
							<ul class="nav nav-pills nav-stacked">
									<li><a>$0 - $50  <span class="pull-right"><input type="checkbox" value="0,50" name="pricerange"/></span></a> </li> 
									<li><a>$51 - $150  <span class="pull-right"><input type="checkbox" value="51,150" name="pricerange"/></span></a> </li>
									<li><a>$151 - $300 <span class="pull-right"><input type="checkbox" value="151,300" name="pricerange"/></span></a> </li>
									<li><a>$300 - $1000 <span class="pull-right"><input type="checkbox" value="300,1000" name="pricerange"/></span></a> </li>
						</div><!--/brands_products-->
						</div>
						

						<%ArrayList<String> carlist = (ArrayList<String>) request.getAttribute("carlist");%>
						
						
						
						
						<input type="submit" value="Search" class="btn btn-gold" style="color:black" /><br/><br/>
						</form>
						</div>
					</div>
				</div>
				<div class="col-sm-9" >
				<div class="line" style="font-size:25px"><span><b>Featured Cars</b></span></div>
				
				<% 
				int i =0;
				%>
				<%while (i<carlist.size()){%>
				<div class="col-sm-4" style="outline: 1px solid orange;">
				<a href="CarDetailServlet?carid=<%out.println(carlist.get(i));%>" style="text-decoration:none"><img src="data/images/<%out.println(carlist.get(i+8));%>" style="padding:10px" >
				<div  style="float:left;margin-left:15px;padding-bottom:10px"><p style="font-weight:bold;font-family:Goudy Old Style;text-transform: uppercase;font-size:15px;color:black" ><font style="float:right"><%out.println(carlist.get(i+1));%></font></p>
				<span class="stars-container stars-<%out.println(carlist.get(i+12));%>" style="font-size:15px;">&#9733;&#9733;&#9733;&#9733;&#9733;</span></div>
				<div style="float:right;margin-right:15px"><p style="font-size:20px;color:black">
							<b>$<%out.println(carlist.get(i+9));%></b><font style="font-family:Goudy Old Style;font-size:15px">/day</font></p></div>
				</a>
				</div>	
				<%i=i+14;}%>	
							
			</div>
			</div>
			</div>
<!--==============================footer=================================-->
		<footer>
		<div class="jumbotron" style="background-color:black">
			<div class="container_12">
				<div class="grid_12">
					<div class="f_phone"><span>Call Us :</span> + 1 201 626 0675</div>
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
</body><%}%>
</html>