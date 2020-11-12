<%@page import="model.dto.Melon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Foogra - Discover & Book the best restaurants at the best price">
    <meta name="author" content="Ansonika">
    <title> - Discover & Book the best restaurants at the best price</title>

    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="img/apple-touch-icon-144x144-precomposed.png">

    <!-- GOOGLE WEB FONT -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&display=swap" rel="stylesheet">

    <!-- BASE CSS -->
    <link href="${pageContext.request.contextPath}/html/css/bootstrap_customized.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet">

    <!-- SPECIFIC CSS -->
    <link href="${pageContext.request.contextPath}/html/css/listing.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="${pageContext.request.contextPath}/html/css/custom.css" rel="stylesheet">

</head>

<body>
				
	<header class="header_in clearfix">
		<div class="container">
		<div id="logo">
			<a href="html/index.jsp">
				<img src="${pageContext.request.contextPath}/html/admin_section/img/mlogo.png" width="140" height="35" alt="">
			</a>
		</div>
		<ul id="top_menu">
			<li><a href="#sign-in-dialog" id="sign-in" class="login">Sign In</a></li>
		
		</ul>
		<!-- /top_menu -->
		<a href="#0" class="open_close">
			<i class="icon_menu"></i><span>Menu</span>
		</a>
		<nav class="main-menu">
			<div id="header_menu">
				<a href="#0" class="open_close">
					<i class="icon_close"></i><span>Menu</span>
				</a>
				<a href="${pageContext.request.contextPath}/html/index.jsp"><img src="${pageContext.request.contextPath}/html/admin_section/img/logo.svg" width="140" height="35" alt=""></a>
			</div>
			<ul>
				<li class="submenu">
					<a href="#0" class="show-submenu">Home</a>
					<ul>
						<li><a href="index.html">Default</a></li>
						<li><a href="index-2.html">Video Background</a></li>
						<li><a href="index-3.html">Slider</a></li>
						<li><a href="index-5.html">Address Autocomplete</a></li>
						<li><a href="index-6.html">Search Version 2</a></li>
						<li><a href="index-7.html">Delivery/Takeaway version</a></li>
						<li><a href="modal-advertise.html">Modal Advertise</a></li>
						<li><a href="modal-newsletter.html">Modal Newsletter</a></li>
						<li><a href="index-4.html">GDPR Cookie Bar EU Law</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#0" class="show-submenu">Listing</a>
					<ul>
						<li class="third-level"><a href="#0">List pages</a>
							<ul>
								<li><a href="grid-listing-filterscol.html">List default</a></li>
								<li><a href="grid-listing-filterscol-map.html">List with map</a></li>
								<li><a href="listing-map.html">List side map</a></li>
								<li><a href="grid-listing-filterscol-full-width.html">List full width</a></li>
								<li><a href="grid-listing-filterscol-full-masonry.html">List Masonry Filter</a></li>
								<li><a href="grid-listing-filterscol-delivery.html">List Delivery/Takeaway</a></li>
							</ul>
						</li>
						<li class="third-level"><a href="#0">Detail pages</a>
							<ul>
								<li><a href="html/detail-restaurant.jsp">Detail page 1</a></li>
								<li><a href="detail-restaurant-2.html">Detail page 2</a></li>
								<li><a href="detail-restaurant-3.html">Mobile Fixed Booking</a></li>
								<li><a href="detail-restaurant-delivery.html">Delivery/Takeaway</a></li>
								<li><a href="detail-restaurant-4.html">Detail Menu Thumbs</a></li>
								<li><a href="detail-restaurant-5.html">Detail Contact Form</a></li>
								<li><a href="detail-restaurant-6.html">Detail Instagram Feed</a></li>
							</ul>
						</li>
						<li class="third-level"><a href="#0">OpenStreetMap</a>
							<ul>
								<li><a href="grid-listing-filterscol-map-openstreetmap.html">List with map</a></li>
								<li><a href="listing-map-openstreetmap.html">List side map</a></li>
								<li><a href="grid-listing-filterscol-full-width-openstreetmap.html">List full width</a></li>
								<li><a href="grid-listing-filterscol-full-masonry-openstreetmap.html">List Masonry Filter</a></li>
							</ul>
						</li>
						<li><a href="submit-restaurant.html">Submit Restaurant</a></li>
						<li><a href="submit-rider.html">Submit Rider</a></li>
						<li><a href="wishlist.html">Wishlist</a></li>
						<li><a href="booking.html">Booking</a></li>
						<li><a href="confirm.html">Confirm Booking</a></li>
						<li><a href="confirm-delivery.html">Confirm Order</a></li>
						<li><a href="booking-delivery-2.html">Order Delivery/Takeaway</a></li>
						<li><a href="booking-delivery.html">Order Delivery/Takeaway 2</a></li>
					</ul>
				</li>
				<li><a href = "https://www.youtube.com/channel/UCyn-K7rZLXjGl7VXGweIlcA"><i class="far fa-thumbs-up fa-lg fa-spin"></i></a></li>
				
			</ul>
		</nav>
	</div>
	</header>
	<!-- /header -->
	
	<main>
		<div class="page_header element_to_stick">
		    <div class="container">
		    	<div class="row">
		    		<div class="col-xl-8 col-lg-7 col-md-7 d-none d-md-block">
		    			<div class="breadcrumbs">
				            <ul>
				                <li><a href="#">Home</a></li>
				                <li><a href="#">Category</a></li>
				                <li>Region</li>
				                <li>City</li>
				            </ul>
		       	 		</div>
		        		<h1>서울시 맛집 정보</h1>
		    		</div>
		    		<div class="col-xl-4 col-lg-5 col-md-5">
		    			<div class="search_bar_list">
							<input type="text" class="form-control" placeholder="Search again...">
							<input type="submit" value="Search">
						</div>
		    		</div>
		    	</div>
		    	<!-- /row -->		       
		    </div>
		</div>
		<!-- /page_header -->
		<div class="collapse" id="collapseMap">
			<div id="map" class="map"></div>
		</div>
		<!-- /Map -->

		<div class="container margin_30_40">			
			<div class="row">
				<aside class="col-lg-3" id="sidebar_fixed">
					<div class="clearfix">
					<a class="btn_map d-flex align-items-center justify-content-center" data-toggle="collapse" href="#collapseMap" aria-expanded="false" aria-controls="collapseMap" ><span class="btn_map_txt" data-text-swap="Hide Map" data-text-original="View on Map">View on Map</span></a>
					<div class="sort_select">
							 <select name="sort" id="sort">
							 	<option>정렬</option>
                                <option value="selectByHits">조회순</option>
                                <option value="selectByGrade">평점순</option>
							</select>
						</div>
						<a class="btn_map mobile btn_filters" data-toggle="collapse" href="#collapseMap"><i class="icon_pin_alt"></i></a>
						<a href="#0" class="open_filters btn_filters"><i class="icon_adjust-vert"></i><span>필터</span></a>
					</div>
					<div class="filter_col">
						<div class="inner_bt"><a href="#" class="open_filters"><i class="icon_close"></i></a></div>
						<div class="filter_type">
							<h4><a href="#filter_1" data-toggle="collapse" class="opened">음식종류</a></h4>
							<div class="collapse show" id="filter_1">
								<ul>
								    <li>
								        <label name = "type" class="container_check" >이탈리안 <small>12</small>
								            <input type="checkbox" value="이탈리안" >
								            <span class="checkmark"></span>
								        </label>
								    </li>
								    <li>
								        <label name = "type" class="container_check">중식 <small>24</small>
								            <input type="checkbox" value="중식">
								            <span class="checkmark"></span>
								        </label>
								    </li>
								    <li>
								        <label name = "type" class="container_check">양식 <small>23</small>
								            <input type="checkbox" value="양식">
								            <span class="checkmark"></span>
								        </label>
								    </li>
								    <li>
								        <label name = "type" class="container_check">카페 <small>11</small>
								            <input type="checkbox" value="카페">
								            <span class="checkmark"></span>
								        </label>
								    </li>
								    <li>
								        <label name = "type" class="container_check">일식 <small>13</small>
								            <input type="checkbox" value="일식">
								            <span class="checkmark"></span>
								        </label>
								    </li>
								</ul>
							</div>
							<!-- /filter_type -->
						</div>
						<!-- /filter_type -->
						<!-- /filter_type -->
						<!-- /filter_type -->
						<!-- /filter_type -->
						<div class="buttons">
							<a href="#" class="btn_1 full-width" id ="search2">필터</a>
						</div>
					</div>
				</aside>
				
				<div class="col-lg-9">
					<div class="row">
					
					<c:forEach items="${requestScope.list}" var="res">
						<div class="col-xl-4 col-lg-6 col-md-6 col-sm-6">
							<div class="strip">
							    <figure>
							        <img src="${res.resPhoto}" data-src="${pageContext.request.contextPath}/html/img/location_1.jpg" class="${res.resPhoto}" alt="">
							        <a href="dispatcher?key=melon&methodName=selectDetailRes&resNo=${res.resNo}" class="strip_info">
							            <small>${res.resType}</small>
							            <div class="item_title">
							                <h3>${res.resName}</h3>
							                <small>${res.resPlace}</small>
							            </div>
							        </a>
							    </figure>
							    <ul>
							        <li><span>평균 ${res.resPrice}</span></li>
							        <li>
							        	<div class="score"><span><b>조회수</b><em>${res.resHits}</em></span><strong>${res.resGrade}</strong></div>
							        </li>
							    </ul>
							</div>
						</div>
						</c:forEach>
						
					</div>
					<!-- /row -->
					<div class="pagination_fg">
					  <a href="#">&laquo;</a>
					  <a href="#" class="active">1</a>
					  <a href="#">2</a>
					  <a href="#">3</a>
					  <a href="#">4</a>
					  <a href="#">5</a>
					  <a href="#">&raquo;</a>
					</div>
				</div>
				<!-- /col -->
			</div>		
		</div>
		<!-- /container -->
		
	</main>
	<!-- /main -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<h3 data-target="#collapse_1">Quick Links</h3>
					<div class="collapse dont-collapse-sm links" id="collapse_1">
						<ul>
							<li><a href="about.html">About us</a></li>
							<li><a href="submit-restaurant.html">Add your restaurant</a></li>
							<li><a href="help.html">Help</a></li>
							<li><a href="account.html">My account</a></li>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="contacts.html">Contacts</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3 data-target="#collapse_2">Categories</h3>
					<div class="collapse dont-collapse-sm links" id="collapse_2">
						<ul>
							<li><a href="grid-listing-filterscol.html">Top Categories</a></li>
							<li><a href="grid-listing-filterscol-full-masonry.html">Best Rated</a></li>
							<li><a href="grid-listing-filterscol-full-width.html">Best Price</a></li>
							<li><a href="grid-listing-filterscol-full-masonry.html">Latest Submissions</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
						<h3 data-target="#collapse_3">Contacts</h3>
					<div class="collapse dont-collapse-sm contacts" id="collapse_3">
						<ul>
							<li><i class="icon_house_alt"></i>97845 Baker st. 567<br>Los Angeles - US</li>
							<li><i class="icon_mobile"></i>+94 423-23-221</li>
							<li><i class="icon_mail_alt"></i><a href="#0">info@domain.com</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
						<h3 data-target="#collapse_4">Keep in touch</h3>
					<div class="collapse dont-collapse-sm" id="collapse_4">
						<div id="newsletter">
							<div id="message-newsletter"></div>
							<form method="post" action="assets/newsletter.php" name="newsletter_form" id="newsletter_form">
								<div class="form-group">
									<input type="email" name="email_newsletter" id="email_newsletter" class="form-control" placeholder="Your email">
									<button type="submit" id="submit-newsletter"><i class="arrow_carrot-right"></i></button>
								</div>
							</form>
						</div>
						<div class="follow_us">
							<h5>Follow Us</h5>
							<ul>
								<li><a href="#0"><img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="${pageContext.request.contextPath}/html/img/twitter_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="${pageContext.request.contextPath}/html/img/facebook_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="${pageContext.request.contextPath}/html/img/instagram_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="${pageContext.request.contextPath}/html/img/youtube_icon.svg" alt="" class="lazy"></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- /row-->
			<hr>
			<div class="row add_bottom_25">
				<div class="col-lg-6">
					<ul class="footer-selector clearfix">
						<li>
							<div class="styled-select lang-selector">
								<select>
									<option value="English" selected>English</option>
									<option value="French">French</option>
									<option value="Spanish">Spanish</option>
									<option value="Russian">Russian</option>
								</select>
							</div>
						</li>
						<li>
							<div class="styled-select currency-selector">
								<select>
									<option value="US Dollars" selected>US Dollars</option>
									<option value="Euro">Euro</option>
								</select>
							</div>
						</li>
						<li><img src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==" data-src="${pageContext.request.contextPath}/html/img/cards_all.svg" alt="" width="198" height="30" class="lazy"></li>
					</ul>
				</div>
				<div class="col-lg-6">
					<ul class="additional_links">
						<li><a href="#0">Terms and conditions</a></li>
						<li><a href="#0">Privacy</a></li>
						<li><span>© MelonPlate</span></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!--/footer-->

	<div id="toTop"></div><!-- Back to top button -->
	
	<div class="layer"></div><!-- Opacity Mask Menu Mobile -->
	
	<!-- Sign In Modal -->
	<div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">
		<div class="modal_header">
			<h3>Sign In</h3>
		</div>
		<form>
			<div class="sign-in-wrapper">
				<a href="#0" class="social_bt facebook">Login with Facebook</a>
				<a href="#0" class="social_bt google">Login with Google</a>
				<div class="divider"><span>Or</span></div>
				<div class="form-group">
					<label>Email</label>
					<input type="email" class="form-control" name="email" id="email">
					<i class="icon_mail_alt"></i>
				</div>
				<div class="form-group">
					<label>Password</label>
					<input type="password" class="form-control" name="password" id="password" value="">
					<i class="icon_lock_alt"></i>
				</div>
				<div class="clearfix add_bottom_15">
					<div class="checkboxes float-left">
						<label class="container_check">Remember me
						  <input type="checkbox">
						  <span class="checkmark"></span>
						</label>
					</div>
					<div class="float-right mt-1"><a id="forgot" href="javascript:void(0);">Forgot Password?</a></div>
				</div>
				<div class="text-center">
					<input type="submit" value="Log In" class="btn_1 full-width mb_5">
					Don’t have an account? <a href="account.html">Sign up</a>
				</div>
				<div id="forgot_pw">
					<div class="form-group">
						<label>Please confirm login email below</label>
						<input type="email" class="form-control" name="email_forgot" id="email_forgot">
						<i class="icon_mail_alt"></i>
					</div>
					<p>You will receive an email containing a link allowing you to reset your password to a new preferred one.</p>
					<div class="text-center"><input type="submit" value="Reset Password" class="btn_1"></div>
				</div>
			</div>
		</form>
		<!--form -->
	</div>
	<!-- /Sign In Modal -->
	
	<!-- COMMON SCRIPTS -->
    <script src="${pageContext.request.contextPath}/html/js/common_scripts.min.js"></script>
    <script src="${pageContext.request.contextPath}/html/js/common_func.js"></script>
    <script src="${pageContext.request.contextPath}/html/assets/validate.js"></script>

    <!-- SPECIFIC SCRIPTS -->
    <script src="${pageContext.request.contextPath}/html/js/sticky_sidebar.min.js"></script>
    <script src="${pageContext.request.contextPath}/html/js/specific_listing.js"></script>

    <!-- Map -->
    <script src="${pageContext.request.contextPath}/html/js/main_map_scripts.js"></script>
	<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=57435e874fa64740b31e8b064eae4495&libraries=services"></script>
	<script>
							
	$(function() {
		
		$("#sort").on("change", function(){
			//alert($("#sort option:selected").val())
			location.href="dispatcher?key=melon&methodName="+$("#sort option:selected").val();
		});
		
		$("#search2").click(function(){
	          var params="type=";
	          $("[name=type]").find(":checked").each(function(index, item){
	               //alert($(this).val())
	               params+=$(this).val()+",";
	           })
	           
	           params = params.substr(0, params.length-1);//마지막 콤마 제거
	          
	          alert(params);
	          location.href="dispatcher?key=melon&methodName=selectByType&"+params;
	       })

	});
	<%
		List<Melon> res = new ArrayList<Melon>();
		res = (List<Melon>)request.getAttribute("list2");
	%>
	var res = `${requestScope.list2}`;

	//alert(res)
	///////////////////////////////////////////////////////////////////////////////////////
	function getLocation() {
	  if (navigator.geolocation) { 
	    navigator.geolocation.getCurrentPosition(function(position) {
	      sessionStorage.setItem("latitude", position.coords.latitude);
	      sessionStorage.setItem("longitude", position.coords.longitude);
	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
	    alert('GPS를 지원하지 않습니다');
	  }
	}

	getLocation();
	/////////////////////////////////////////////////////////////////////////////////////////
	var coordXY = document.getElementById("coordXY"); 
	var container = document.getElementById('map'); 
	var options = { center: new kakao.maps.LatLng(sessionStorage.getItem("latitude"), sessionStorage.getItem("longitude")), 
			level: 4
	}; 
	var map = new kakao.maps.Map(container, options); 

	var mapTypeControl = new kakao.maps.MapTypeControl(); 
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT); 
	var zoomControl = new kakao.maps.ZoomControl(); 
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT); 

	var geocoder = new kakao.maps.services.Geocoder(); 

	geocoder.addressSearch('경기도', function(result, status) { 
	var 데이터 = [
			[37.402019, 127.108935, '<div style="padding:5px;">테</div>'],
			[37.401062, 127.107348, '<div style="padding:5px;">스</div>'],
			[37.401984, 127.110258, '<div style="padding:5px;">트</div>'],
			[37.401212, 127.110755, '<div style="padding:5px;">!</div>']
		];
		if (status === kakao.maps.services.Status.OK) { 
			var coords = new kakao.maps.LatLng(sessionStorage.getItem("latitude"), sessionStorage.getItem("longitude")); 
			yy = result[0].x; xx = result[0].y; 

			var markers = []; 
			for (var i = 0; i < 데이터.length; i++ ) {
				
				var marker = new kakao.maps.Marker({
					position: new kakao.maps.LatLng(데이터[i][0], 데이터[i][1]), 
					map: map 
				});

				iwPosition = new kakao.maps.LatLng(데이터[i][0], 데이터[i][1]),
			    iwRemoveable = true;

				var infowindow = new kakao.maps.InfoWindow({
				    map: map, 
				    position : iwPosition, 
				    content : 데이터[i][2],
				    removable : iwRemoveable
				});

				infowindow.open(map, marker);
				markers.push(marker);
			}
			
			map.setCenter(coords); 
			var markerPosition = marker.getPosition(); $(window).on('resize', function(){ map.relayout(); map.setCenter(markerPosition); }); 
			} 
		else { console.log('에러'); } }); 

</script>

</body>
</html>