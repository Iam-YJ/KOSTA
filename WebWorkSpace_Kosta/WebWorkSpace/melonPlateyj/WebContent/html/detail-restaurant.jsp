<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Foogra - Discover & Book the best restaurants at the best price">
    <meta name="author" content="Ansonika">
    <title>Foogra - Discover & Book the best restaurants at the best price</title>

    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="${pageContext.request.contextPath}/html/image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="${pageContext.request.contextPath}/html/img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="${pageContext.request.contextPath}/html/img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="${pageContext.request.contextPath}/html/img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="${pageContext.request.contextPath}/html/img/apple-touch-icon-144x144-precomposed.png">

    <!-- GOOGLE WEB FONT -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&display=swap" rel="stylesheet">

    <!-- BASE CSS -->
    <link href="${pageContext.request.contextPath}/html/css/bootstrap_customized.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet">

    <!-- SPECIFIC CSS -->
    <link href="${pageContext.request.contextPath}/html/css/detail-page.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="${pageContext.request.contextPath}/html/css/custom.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/html/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
      function insertBookMark(){
         alert("찜하기 추가");
         location.href="${pageContext.request.contextPath}/dispatcher?key=user&methodName=insertBookMark&res_no="+${melon.resNo}+"&user_no="+sessionStorage.getItem("userNo");
      }
      
         
      $(function(){
         
         var count;
           $("#tab-B").click(function(){
              //alert(1);
              $.ajax({
                 type: "post", //전송방식(get, post, put, delete)
                 url: "${pageContext.request.contextPath}/review", //서버주소
                 dataType: "json", //서버가 보내온 응답데이터의 타입(text, html, xml, json)
                 data: {res_no:${melon.resNo}}, //서버에게 보낼 parameter정보 
                 success: function(result){ //요청 결과가 성공했을 때 호출될 함수 
//                    alert(result); 
                     console.log("json: " + result);
                      var text = "";
                      $.each(result, function(index, item){
                         console.log("item: " + item);
                         console.log("nickname: " + item.nickName);
                          text += "<div class='row'>";
                               text += "<div class='col-md-2 user_info'>";
                               text += "<h5>"+item.nickName+"</h5>";
                               text += "<figure><img src='${pageContext.request.contextPath}/html/img/images.png' alt=''></figure>";
                               text += "</div>";
                               text += "<div class='col-md-10 review_content'>";
                               text += "<div class='clearfix add_bottom_15'>";
                               text += "<span class='rating'>"+item.repGrade+"<small>/5</small></span>";
                               text += "<div id='agree'><em><i class='icon_like'></i> "+ item.repAgree+"</em></div>"
                               //text += "<em><input type='text' id='"+item.reviewNo+"' value='"+item.repAgree+"'></em>";
                               text += "</div>";
                               text += "<p>"+item.repContent+"</p>";
                                   
                               text += "</div>";
                                 text += "</div>";
                                 text += "<ul><a href='#' id='like_btn' name='"+item.reviewNo+"'><i class='icon_like'></i><span> like</span></a></ul>";
                                 //arr = item.reviewNo;
                                 //console.log(arr + "번");
                                 //count = item.repAgree;
                      })
                      $(".review_card").html(text);
                 
                      $(document).on("click","#like_btn",function(){
                         //alert($(this).attr("name"))
                        $.ajax({
                             type: "post", //전송방식(get, post, put, delete)
                             url: "${pageContext.request.contextPath}/like", //서버주소
                             dataType: "text", //서버가 보내온 응답데이터의 타입(text, html, xml, json)
                             data: {review_no:$(this).attr("name")}, //서버에게 보낼 parameter정보 
                             success: function(result){ //요청 결과가 성공했을 때 호출될 함수 
                                console.log(result);
                                 var text = "<em>"+result+"</em>";
                                $("#agree").html(text);
                                location.reload();
                             },
                             error: function(result){ //요청 결과가 실패했을 때 호출될 함수 
                                console.log(result);
                             }
                          })         
                        
                          });//작은 ajax끝    

              }, //바깥 ajax success 함수 끝 
              error: function(result){ //요청 결과가 실패했을 때 호출될 함수 
                 console.log(result);
              }

           }) //바깥 ajax
           
      })//tab-B끝
   })//function끝
      
      
      
           
   </script>
	<link href="${pageContext.request.contextPath}/html/css/custom.css"
	rel="stylesheet">
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
			<li><a id="book" class="wishlist_bt_top" title="Your wishlist">Your wishlist</a></li>
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
					<a href="${pageContext.request.contextPath}/html/index.jsp" class="show-submenu">Home</a>
					
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
								<li><a href="detail-restaurant.html">Detail page 1</a></li>
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
						<li><a href="admin_section/index.html" target="_blank">Admin Section</a></li>
					</ul>
				</li>
				
			</ul>
		</nav>
	</div>
	</header>
	<!-- /header -->
	<main>
		<div class="hero_in detail_page background-image" style="
background-image: URL(${melon.resPhoto});">
			<div class="wrapper opacity-mask" data-opacity-mask="rgba(0, 0, 0, 0.5)">
				
				<div class="container">
					<div class="main_info">
						<div class="row">
							<div class="col-xl-4 col-lg-5 col-md-6">
								<div class="head"><div class="score"><span>조회수<em>${melon.resHits}</em></span><strong>${melon.resGrade}</strong></div></div>
								
								<h2></h2>
								<h1>${melon.resName}</h1>
								${melon.resType} - ${melon.resPlace} - <a id = "loadfind" href="https://map.kakao.com/link/search/${melon.resName}" target="blank">오시는 길</a>
							</div>
							<div class="col-xl-8 col-lg-7 col-md-6">
								<div class="buttons clearfix">
									<span class="magnific-gallery">
										<a href="${pageContext.request.contextPath}/html/img/detail_1.jpg" class="btn_hero" title="Photo title" data-effect="mfp-zoom-in"><i class="icon_image"></i>사진 보기</a>
										<a href="${pageContext.request.contextPath}/html/img/detail_2.jpg" title="Photo title" data-effect="mfp-zoom-in"></a>
										<a href="${pageContext.request.contextPath}/html/img/detail_3.jpg" title="Photo title" data-effect="mfp-zoom-in"></a>
									</span>
									<a href="#0" class="btn_hero wishlist" onclick="insertBookMark();"><i class="icon_heart"></i>찜하기</a>
								</div>
							</div>
						</div>
						<!-- /row -->
					</div>
					<!-- /main_info -->
				</div>
			</div>
		</div>
		<!--/hero_in-->
		
		<div class="container margin_detail">
		    <div class="row">
		        <div class="col-lg-8">

		            <div class="tabs_detail">
		                <ul class="nav nav-tabs" role="tablist">
		                    <li class="nav-item">
		                        <a id="tab-A" href="#pane-A" class="nav-link active" data-toggle="tab" role="tab">Information</a>
		                    </li>
		                    <li class="nav-item">
		                        <a id="tab-B" href="#pane-B" class="nav-link" data-toggle="tab" role="tab">Reviews</a>
		                    </li>
		                </ul>

		                <div class="tab-content" role="tablist">
		                    <div id="pane-A" class="card tab-pane fade show active" role="tabpanel" aria-labelledby="tab-A">
		                        <div class="card-header" role="tab" id="heading-A">
		                            <h5>
		                                <a class="collapsed" data-toggle="collapse" href="#collapse-A" aria-expanded="true" aria-controls="collapse-A">
		                                    Information
		                                </a>
		                            </h5>
		                        </div>
		                        <div id="collapse-A" class="collapse" role="tabpanel" aria-labelledby="heading-A">
		                            <div class="card-body info_content">
		                                <!-- /pictures -->
		                                <h2>${melon.resName} Menu</h2>
		                                <h3>Main Course</h3>
		                                <c:forEach items="${menu}" var="me">
		                                <div class="menu_item">
		                                    <h4>˚${me.menuName}</h4><p>
		                                    <strong>${me.menuPrice}원</strong>
		                                </div>
		                                </c:forEach>

		                                <div class="other_info">
		                                <h2>How to get to ${melon.resName}</h2>
		                                <div class="row">
		                                	<div class="col-md-4">
		                                		<h3>Address</h3>
		                                		<p>${melon.resPlace}<br><a href="https://map.kakao.com/link/search/${melon.resName}" target="blank"><strong>오시는 길</strong></a></p>
		                                		<strong>Follow Us</strong><br>
		                                		<p class="follow_us_detail"><a href="#0"><i class="social_facebook_square"></i></a><a href="#0"><i class="social_instagram_square"></i></a><a href="#0"><i class="social_twitter_square"></i></a></p>
		                                	</div>
		                                	<div class="col-md-4">
		                                		<h3>Opening Time</h3>
		                                		<p><strong>Lunch</strong><br> Mon. to Sat. 11.00am - 3.00pm<p>
		                                		<p><strong>Dinner</strong><br> Mon. to Sat. 6.00pm- 1.00am</p>
		                                		<p><span class="loc_closed">Sunday Closed</span></p>
		                                	</div>
		                                	<div class="col-md-4">
		                                		<h3>Services</h3>
		                                		<p><strong>Credit Cards</strong><br> Mastercard, Visa, Amex</p>
		                                		<p><strong>Other</strong><br> Wifi, Parking, Wheelchair Accessible</p>
		                                	</div>
		                                </div>
		                                <!-- /row -->
		                            	</div>
		                            </div>
		                        </div>
		                    </div>
		                    <!-- /tab -->

						<div id="pane-B" class="card tab-pane fade" role="tabpanel"
                        aria-labelledby="tab-B">
                        <div class="card-header" role="tab" id="heading-B">
                           <h5>
                              <a class="collapsed" data-toggle="collapse" href="#collapse-B"
                                 aria-expanded="false" aria-controls="collapse-B"> Reviews
                              </a>
                           </h5>
                        </div>
                        <div id="collapse-B" class="collapse" role="tabpanel"
                           aria-labelledby="heading-B">

                           <div class="card-body reviews">

                              <div id="reviews">
                                 <%-- <c:forEach items="${requestScope.list}" var="list"> --%>
                                 <div class="review_card">
                                    <%-- <div class="row">
                                                  <div class="col-md-2 user_info">
                                                      <h5>${list.nickName}</h5>
                                                      <figure><img src="${pageContext.request.contextPath}/html/img/avatar4.jpg" alt=""></figure>
                                                  </div>
                                                  <div class="col-md-10 review_content">
                                                      <div class="clearfix add_bottom_15">
                                                          <span class="rating">${list.repGrade}<small>/5</small> <strong>Rating average</strong></span>
                                                          <em>${list.repDate}</em>
                                                      </div>
                                                      <p>${list.repContent}</p>
                                                  </div>
                                              </div> --%>
                                    <!-- /row -->

                                 </div>
                                 <!-- /review_card -->
                                 <%-- </c:forEach> --%>
                              </div>
                              <!-- /reviews -->
                              <div class="text-right">
                                 <a
                                    href="${pageContext.request.contextPath}/html/leave-review.jsp?resName=${melon.resName}&resNo=${melon.resNo}";
                                    class="btn_1">Leave a review</a>
                              </div>

                           </div>
                        </div>
                     </div>
		                </div>
		                <!-- /tab-content -->
		            </div>
		            <!-- /tabs_detail -->
		        </div>
		        <!-- /col -->

		        <div class="col-lg-4" id="sidebar_fixed">
		            <div class="box_booking">
		                <div class="head">
		                    <h3>Book your table</h3>
		                    <div class="offer">Up to -40% off</div>
		                </div>
		                <!-- /head -->
		                <div class="main">
		                    <input type="text" id="datepicker_field">
		                    <div id="DatePicker"></div>
		                    <div class="dropdown time">
		                        <a href="#" data-toggle="dropdown">Hour <span id="selected_time"></span></a>
		                        <div class="dropdown-menu">
		                            <div class="dropdown-menu-content">
		                                <h4>Lunch</h4>
		                                <div class="radio_select add_bottom_15">
		                                    <ul>
		                                        <li>
		                                            <input type="radio" id="time_1" name="time" value="12.00am">
		                                            <label for="time_1">12.00<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_2" name="time" value="08.30pm">
		                                            <label for="time_2">12.30<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_3" name="time" value="09.00pm">
		                                            <label for="time_3">1.00<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_4" name="time" value="09.30pm">
		                                            <label for="time_4">1.30<em>-40%</em></label>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <!-- /time_select -->
		                                <h4>Dinner</h4>
		                                <div class="radio_select">
		                                    <ul>
		                                        <li>
		                                            <input type="radio" id="time_5" name="time" value="08.00pm">
		                                            <label for="time_1">20.00<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_6" name="time" value="08.30pm">
		                                            <label for="time_2">20.30<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_7" name="time" value="09.00pm">
		                                            <label for="time_3">21.00<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="time_8" name="time" value="09.30pm">
		                                            <label for="time_4">21.30<em>-40%</em></label>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <!-- /time_select -->
		                            </div>
		                        </div>
		                    </div>
		                    <!-- /dropdown -->
		                    <div class="dropdown people">
		                        <a href="#" data-toggle="dropdown">People <span id="selected_people"></span></a>
		                        <div class="dropdown-menu">
		                            <div class="dropdown-menu-content">
		                                <h4>How many people?</h4>
		                                <div class="radio_select">
		                                    <ul>
		                                        <li>
		                                            <input type="radio" id="people_1" name="people" value="1">
		                                            <label for="people_1">1<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="people_2" name="people" value="2">
		                                            <label for="people_2">2<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="people_3" name="people" value="3">
		                                            <label for="people_3">3<em>-40%</em></label>
		                                        </li>
		                                        <li>
		                                            <input type="radio" id="people_4" name="people" value="4">
		                                            <label for="people_4">4<em>-40%</em></label>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <!-- /people_select -->
		                            </div>
		                        </div>
		                    </div>
		                    <!-- /dropdown -->
		                    <a href="booking.html" class="btn_1 full-width mb_5">Reserve Now</a>
		                   <div class="text-center"><small>No money charged on this steps</small></div>
		                </div>
		            </div>
		            <!-- /box_booking -->
		            <ul class="share-buttons">
		                <li><a class="fb-share" href="#0"><i class="social_facebook"></i> Share</a></li>
		                <li><a class="twitter-share" href="#0"><i class="social_twitter"></i> Share</a></li>
		                <li><a class="gplus-share" href="#0"><i class="social_googleplus"></i> Share</a></li>
		            </ul>
		        </div>

		    </div>
		    <!-- /row -->
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
						<li><span>© Foogra</span></li>
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
					<div class="float-right"><a id="forgot" href="javascript:void(0);">Forgot Password?</a></div>
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
    <script src="${pageContext.request.contextPath}/html/js/specific_detail.js"></script>
	<script src="${pageContext.request.contextPath}/html/js/datepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/html/js/datepicker_func_1.js"></script>
	<script type="text/javascript" src ="${pageContext.request.contextPath}/html/js/jquery-3.5.1.min.js" ></script>
   <script type='text/javascript'>
            
   $(function() {
      $("#book").attr("href", "${pageContext.request.contextPath}/dispatcher?key=user&methodName=seleteBookMark&user_no="+sessionStorage.getItem("userNo"));
   });
   
</script>
</body>
</html>