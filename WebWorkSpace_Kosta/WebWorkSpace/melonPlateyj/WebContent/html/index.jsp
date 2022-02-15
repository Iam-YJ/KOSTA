<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Foogra - Discover & Book the best restaurants at the best price">
<meta name="author" content="Ansonika">
<title>Melon Plate - Discover the best restaurants at the best
	price</title>

<!-- Favicons-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/html/img/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/html/img/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="72x72"
	href="${pageContext.request.contextPath}/html/img/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="114x114"
	href="${pageContext.request.contextPath}/html/img/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="144x144"
	href="${pageContext.request.contextPath}/html/img/apple-touch-icon-144x144-precomposed.png">

<!-- GOOGLE WEB FONT -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&display=swap"
	rel="stylesheet">

<!-- BASE CSS -->
<link
	href="${pageContext.request.contextPath}/html/css/bootstrap_customized.min.css"
	rel="stylesheet">
<!-- ${pageContext.request.contextPath} -->
<link href="${pageContext.request.contextPath}/html/css/style.css"
	rel="stylesheet">

<!-- SPECIFIC CSS -->
<link href="${pageContext.request.contextPath}/html/css/home.css"
	rel="stylesheet">

<!-- YOUR CUSTOM CSS -->
<link href="${pageContext.request.contextPath}/html/css/custom.css"
	rel="stylesheet">

</head>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>


<body>




	<header class="header clearfix element_to_stick">
		<div class="container">
			<div id="logo">
				<a href="index.jsp"> <img src="img/mlogo.png" width="140"
					height="35" alt="" class="logo_normal"> <img
					src="img/mlogo.png" width="140" height="35" alt=""
					class="logo_sticky">
				</a>
			</div>
			<ul id="top_menu">
				<li><a href="#sign-in-dialog" id="sign-in" class="login">Sign
						In</a></li>
				
			</ul>
			<!-- /top_menu -->
			<a href="#0" class="open_close"> <i class="icon_menu"></i><span>Menu</span>
			</a>
			<nav class="main-menu">
				<div id="header_menu">
					<a href="#0" class="open_close"> <i class="icon_close"></i><span>Menu</span>
					</a> <a href="index.jsp"><img src="img/logo.svg" width="140"
						height="35" alt=""></a>
				</div>
				<ul>
					<li class="submenu"><a href="#0" class="show-submenu">Home</a>
						</li>
					<li class="submenu"><a href="#0" class="show-submenu">Listing</a>
						<ul>
							<li class="third-level"><a href="#0">List pages</a>
								<ul>
									<li><a href="grid-listing-filterscol.jsp">List default</a></li>
									<li><a href="../dispatcher?key=melon&methodName=selectAll">List
											with map</a></li>
									<li><a href="listing-map.jsp">List side map</a></li>
									<li><a href="grid-listing-filterscol-full-width.jsp">List
											full width</a></li>
									<li><a href="grid-listing-filterscol-full-masonry.jsp">List
											Masonry Filter</a></li>
									<li><a href="grid-listing-filterscol-delivery.jsp">List
											Delivery/Takeaway</a></li>
								</ul></li>
							
							<li class="third-level"><a href="#0">OpenStreetMap</a>
								<ul>
									<li><a
										href="grid-listing-filterscol-map-openstreetmap.jsp">List
											with map</a></li>
									<li><a href="listing-map-openstreetmap.jsp">List side
											map</a></li>
									<li><a
										href="grid-listing-filterscol-full-width-openstreetmap.jsp">List
											full width</a></li>
									<li><a
										href="grid-listing-filterscol-full-masonry-openstreetmap.jsp">List
											Masonry Filter</a></li>
								</ul></li>
							<li><a href="submit-restaurant.jsp">Submit Restaurant</a></li>
							<li><a href="submit-rider.jsp">Submit Rider</a></li>
							<li><a href="wishlist.jsp">Wishlist</a></li>
							<li><a href="booking.jsp">Booking</a></li>
							<li><a href="confirm.jsp">Confirm Booking</a></li>
							<li><a href="confirm-delivery.jsp">Confirm Order</a></li>
							<li><a href="booking-delivery-2.jsp">Order
									Delivery/Takeaway</a></li>
							<li><a href="booking-delivery.jsp">Order
									Delivery/Takeaway 2</a></li>
							<li><a href="admin_section/index.jsp" target="_blank">Admin
									Section</a></li>
						</ul></li>
					
					<li><a id="userNobb" target="_blank">마이페이지</a></li>
					<li><a href = "https://www.youtube.com/channel/UCyn-K7rZLXjGl7VXGweIlcA"><i class="far fa-thumbs-up fa-lg fa-spin"></i></a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- /header -->

	<main>
		<div class="hero_single version_2">
			<div class="opacity-mask" data-opacity-mask="rgba(0,0,0,0)" >
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-xl-9 col-lg-10 col-md-8">
							<h3>Welcome to Melon Plate</h3>
							<p></p>

							<form method="post"
								action="../dispatcher?key=melon&methodName=selectByResName">
								<div class="row no-gutters custom-search-input">
									<div class="col-lg-8">
										<div class="form-group">
											<input name="resName" class="form-control" type="text"
												placeholder="식당명을 입력해주세요..."> <i class="icon_search"></i>
										</div>
									</div>
									<div class="col-lg-4">
										<input type="submit" value="Search">
									</div>
								</div>
								<!-- /row -->
							</form>
						</div>
					</div>
					<!-- /row -->
				</div>
			</div>
		</div>
		<!-- /hero_single -->


		<!-- /bg_gray -->

		<div class="container margin_60_40">
			<div class="main_title">
				<span><em></em></span>
				<h2>Popular Restaurants</h2>
				<p>We have collected only the best restaurants</p>
				<a href="${pageContext.request.contextPath}/dispatcher?key=melon&methodName=selectAll">View All</a>
			</div>

			<div class="owl-carousel owl-theme carousel_4">
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-30%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img1.jpg"
								class="owl-lazy" alt="">
							<a href="${pageContext.request.contextPath}/dispatcher?key=melon&methodName=selectDetailRes&resNo=441" class="strip_info"> <small>정통 중식/일반 중식</small>
								<div class="item_title">
									<h3>팔레드 신</h3>
									<small>서울특별시 중구 퇴계로 67 6F</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>51 Reviews</em></span><strong>4.8</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-40%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img2.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=442" class="strip_info"> <small>라멘 / 소바 / 우동</small>
								<div class="item_title">
									<h3>유즈라멘</h3>
									<small>서울특별시 중구 만리재로 217</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>87 Reviews</em></span><strong>4.7</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-30%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img3.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=443" class="strip_info"> <small>닭 / 오리 요리</small>
								<div class="item_title">
									<h3>은화계</h3>
									<small>서울특별시 중구 퇴계로 374</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>29 Reviews</em></span><strong>4.6</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-25%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img4.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=444" class="strip_info"> <small>베이커리</small>
								<div class="item_title">
									<h3>패스트리부티크</h3>
									<small>서울특별시 중구 동호로 249 서울신라호텔 1F</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>60 Reviews</em></span><strong>4.6</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-30%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img5.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=445" class="strip_info"> <small>정통 중식 / 일반 중식</small>
								<div class="item_title">
									<h3>도림</h3>
									<small>서울특별시 중구 남대문로 81 롯데호텔서울 본관 37F</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>26 Reviews</em></span><strong>4.6</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-15%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img6.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=446" class="strip_info"> <small>탕 / 찌개 / 전골</small>
								<div class="item_title">
									<h3>미성옥</h3>
									<small>서울특별시 중구 명동길 25-11 1F</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_open">Now Open</span></li>
							<li>
								<div class="score">
									<span><em>76 Reviews</em></span><strong>4.6</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="item">
					<div class="strip">
						<figure>
							<span class="ribbon off">-30%</span>
							<img src="img/lazy-placeholder.png" data-src="img/img7.jpg"
								class="owl-lazy" alt="">
							<a href="../dispatcher?key=melon&methodName=selectDetailRes&resNo=447" class="strip_info"> <small>기타 일식</small>
								<div class="item_title">
									<h3>무명스키야키</h3>
									<small>서울특별시 중구 퇴계로87길 30 1F</small>
								</div>
							</a>
						</figure>
						<ul>
							<li><span class="loc_closed">Now Closed</span></li>
							<li>
								<div class="score">
									<span><em>19 Reviews</em></span><strong>4.5</strong>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /carousel -->


<!-- 유진 -->





			<!-- /row -->
			<p class="text-center d-block d-md-block d-lg-none">
				<a href="grid-listing-filterscol.jsp" class="btn_1">View All</a>
			</p>
			<!-- /button visibile on tablet/mobile only -->
		</div>
		<!-- /container -->


		<!--/call_section-->

	</main>
	<!-- /main -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<h3 data-target="#collapse_1">Quick Links</h3>
					<div class="collapse dont-collapse-sm links" id="collapse_1">
						<ul>
							<li><a href="about.jsp">About us</a></li>
							<li><a href="submit-restaurant.jsp">Add your restaurant</a></li>
							<li><a href="help.jsp">Help</a></li>
							<li><a href="account.jsp">My account</a></li>
							<li><a href="blog.jsp">Blog</a></li>
							<li><a href="contacts.jsp">Contacts</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3 data-target="#collapse_2">Categories</h3>
					<div class="collapse dont-collapse-sm links" id="collapse_2">
						<ul>
							<li><a href="grid-listing-filterscol.jsp">Top Categories</a></li>
							<li><a href="grid-listing-filterscol-full-masonry.jsp">Best
									Rated</a></li>
							<li><a href="grid-listing-filterscol-full-width.jsp">Best
									Price</a></li>
							<li><a href="grid-listing-filterscol-full-masonry.jsp">Latest
									Submissions</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3 data-target="#collapse_3">Contacts</h3>
					<div class="collapse dont-collapse-sm contacts" id="collapse_3">
						<ul>
							<li><i class="icon_house_alt"></i>97845 Baker st. 567<br>Los
								Angeles - US</li>
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
							<form method="post" action="assets/newsletter.php"
								name="newsletter_form" id="newsletter_form">
								<div class="form-group">
									<input type="email" name="email_newsletter"
										id="email_newsletter" class="form-control"
										placeholder="Your email">
									<button type="submit" id="submit-newsletter">
										<i class="arrow_carrot-right"></i>
									</button>
								</div>
							</form>
						</div>
						<div class="follow_us">
							<h5>Follow Us</h5>
							<ul>
								<li><a href="#0"><img
										src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=="
										data-src="img/twitter_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img
										src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=="
										data-src="img/facebook_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img
										src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=="
										data-src="img/instagram_icon.svg" alt="" class="lazy"></a></li>
								<li><a href="#0"><img
										src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=="
										data-src="img/youtube_icon.svg" alt="" class="lazy"></a></li>
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
						<li><img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw=="
							data-src="img/cards_all.svg" alt="" width="198" height="30"
							class="lazy"></li>
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

	<div id="toTop"></div>
	<!-- Back to top button -->

	<div class="layer"></div>
	<!-- Opacity Mask Menu Mobile -->

	<!-- Sign In Modal -->
	<div id="sign-in-dialog" class="zoom-anim-dialog mfp-hide">
		<div class="modal_header">
			<h3>Sign In</h3>
		</div>
		<form>
			<div class="sign-in-wrapper">
				<a href="#" class="social_bt kakao" id="kakao-login-btn"
					onclick=createLoginButton>Login with Kakao</a>
				<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
				<a id="kakao-login-btn"></a> <a
					href="http://developers.kakao.com/logout"></a>
				<script type="text/javascript" src ="${pageContext.request.contextPath}/html/js/jquery-3.5.1.min.js" ></script>
				<script type='text/javascript'>
				
				$(function() {
					$("#userNobb").attr("href", "${pageContext.request.contextPath}/dispatcher?key=user&methodName=selectUserInfo&user_no="+sessionStorage.getItem("userNo"));
				});
					Kakao.init('3f23f0f66acf48aad61c4ec6681b0615'); //아까 카카오개발자홈페이지에서 발급받은 자바스크립트 키를 입력함

					//카카오 로그인 버튼을 생성합니다. 

					Kakao.Auth.createLoginButton({
						container : '#kakao-login-btn',
						success : function(authObj) {
							Kakao.API.request({

								url : '/v2/user/me', 

								success : function(res) {

									console.log(res);

									//console.log(authObj.access_token);//<---- 콘솔 로그에 토큰값 출력

									var userNo = res.id;
									sessionStorage.setItem("userNo",userNo);
									var userNick = res.properties.nickname;
									var userAge = res.kakao_account.age_range;
									var userEmail = res.kakao_account.email;
									var userGender = res.kakao_account.gender;
									
							/* 		console.log(userNo)
									console.log(userNick)
									console.log(userAge)
									console.log(userEmail)
									console.log(userGender) */
									
									window.location.replace("${pageContext.request.contextPath}/dispatcher?key=user&methodName=join&userNo="+userNo+"&userNick="+userNick+"&userAge="+userAge+"&userEmail="+userEmail+"&userGender="+userGender);
									
									//../dispatcher?key=user&methodName=join
									
									//window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/hansub_project/home?kakaonickname="+kakaonickname+"kakaotalk"+"&kakaoe_mail="+kakaoe_mail);

								}
							})
						},
						fail : function(error) {
							alert(JSON.stringify(error));
						}
					});
				</script>



				<div class="clearfix add_bottom_0">

					<!-- 	<div class="float-right mt-1"><a id="forgot" href="javascript:void(0);">Are you a Non-user?</a></div> -->
				</div>
				<div class="text-center">
					<input type="button" value="Are you a Non-user?"
						class="btn_1 full-width mb_1" onclick="gogopage()"> <br>
					<script type="text/javascript">
						function gogopage() {
						
							location.href = "../html/index.jsp"

						}
					</script>

				</div>
				<div class="text-center">
					<input type="button" value="Are you a Manager?"
						class="btn_1 full-width mb_1" onclick="gopage()">
					<script type="text/javascript">
						function gopage() {
							var adminId = prompt("ID를 입력하세요");
							var adminPwd = prompt("Password를 입력하세요");

							if (adminId == "admin" && adminPwd == "admin") {
								location.href = "../html/admin_section/adminIndex.jsp"

							} else {
								alert("관리자 이용 가능 메뉴입니다")
							}
							// form에서는 페이지 이동 전에 데이터가 들어있는지 확인이 번거롭다.
							// 데이터를 확인하고 그 데이터를 가지고 링크를 이동하기 위해서는 
							// 자바스크립트에서 데이터 확인을 거치고 직접 보내주는 것이 좋다

						}
					</script>
					Don’t have an account? <a
						href="https://accounts.kakao.com/weblogin/create_account?continue=https://accounts.kakao.com">Sign
						up</a>
				</div>
				<div id="forgot_pw">
					<div class="form-group">
						<label>Please confirm login email below</label> <input
							type="email" class="form-control" name="email_forgot"
							id="email_forgot"> <i class="icon_mail_alt"></i>
					</div>
					<p>You will receive an email containing a link allowing you to
						reset your password to a new preferred one.</p>
					<div class="text-center">
						<input type="submit" value="Reset Password" class="btn_1">
					</div>
				</div>
			</div>
		</form>
		<!--form -->
	</div>
	<!-- /Sign In Modal -->

	<!-- COMMON SCRIPTS -->
	<script src="js/common_scripts.min.js"></script>
	<script src="js/common_func.js"></script>
	<script src="assets/validate.js"></script>

</body>
</html>