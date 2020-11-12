<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- 스케쥴표 -->
<style type="text/css">
body, div, p, h1, h2, h3, h4, h5, h6, ul, ol, li, dl, dt, dd, table, th,
	td, form, fieldset, legend, input, textare, a, button, select {
	margin: 0;
	padding: 0
}

body, input, textarea, select, button, table {
	font-family: '돋움', dotum, AppleGothic, sans-serif;
	font-size: 12px
}

body {
	word-break: break-all
}

a {
	text-decoration: none
}

a:hover, a:active, a:focus {
	text-decoration: underline
}

caption, legend, .blind {
	visibility: hidden;
	overflow: hidden;
	width: 0;
	height: 0;
	font-size: 0;
	line-height: 0;
	text-align: left
}

hr {
	display: none
}

table {
	border-collapse: collapse
}

th {
	font-weight: normal
}

.bbs_table {
	width: 100%;
	border: 1px solid #d0d4d9;
	line-height: 16px; /* IE7 수정 */
	*border-right: 0 /* IE7 수정 */
}

.bbs_table th:first-child, .bbs_tbl_type2 td:first-child {
	border-left: 0
}

.bbs_table th {
	padding: 10px 9px 7px;
	border-width: 0 0 0 1px;
	border-color: #dcdee2;
	border-style: solid;
	text-align: center;
	background-color: #eff0f2;
	color: #333
}

.bbs_table td {
	padding: 10px 9px 7px;
	border-width: 1px 0 0 1px;
	border-color: #edeef0 #dcdee2;
	border-style: solid;
	text-align: center;
	line-height: 33px;
	color: #666; /* IE7 수정 */
	*border-left: 0;
	*border-top: 0;
	*border-bottom: 1px solid #edeef0;
	*border-right: 1px solid #dcdee2; /* IE7 수정 */
}

.bbs_table td input[type=text], .bbs_tbl_type2 td select, .bbs_tbl_type2 td a.fron
	{
	margin: -6px 0 -2px
}

.bbs_table td:hover {
	border: 1px solid #666 !important
}

.bbs_table tr:first-child td {
	border-top: 1px solid #dcdee2
}

.bbs_table tr:first-child td:hover {
	border-top: 1px solid #666 !important
}

.schu_line_bg {
	border: 1px solid #999 !important;
	background-color: #f9fafa
}

.schedule_area_v1 {
	position: relative; /* IE7 수정 */
	*top: 3px; /* IE7 수정 */
	padding: 18px 5px 16px;
	line-height: 18px;
	font-size: 12px
}

.schedule_area_v1 a {
	display: block;
	position: relative;
	color: #333
}

.schedule_area_v1 a:hover {
	font-weight: bold
}

.schedule_close {
	display: block;
	position: absolute;
	top: 2px;
	right: 2px;
	width: 15px;
	height: 15px;
	cursor: pointer
}
</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Ansonika">
<title>FOOGRA - Admin dashboard</title>

<!-- Favicons-->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" type="image/x-icon"
	href="img/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="144x144"
	href="img/apple-touch-icon-144x144-precomposed.png">

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Main styles -->
<link href="css/admin.css" rel="stylesheet">
<!-- Icon fonts-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Plugin styles -->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Your custom styles -->
<link href="css/custom.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-default fixed-top"
		id="mainNav">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/dispatcher?key=admin&methodName=selectNoti"><img
			src="img/melonlogo.png" data-retina="true" alt="" width="142" height="36"></a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                  <a class="nav-link" href="${pageContext.request.contextPath}/html/admin_section/adminIndex.jsp">
                      <i class="fa fa-fw fa-dashboard"></i>
                      <span class="nav-link-text">Dashboard</span>
                  </a>
              </li>
				
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Board"><a class="nav-link"
					href="${pageContext.request.contextPath}/dispatcher?key=admin&methodName=selectNoti">
						<i class="fa fa-fw fa-envelope-open"></i> <span
						class="nav-link-text">NOTICE</span>
				</a></li>


				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Add Restaurant"><a class="nav-link"
					href="${pageContext.request.contextPath}/html/admin_section/add-listing-with-menu-list.jsp">
						<i class="fa fa-fw fa-plus-circle"></i> <span
						class="nav-link-text">Add Restaurant</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Delete Restaurant"><a class="nav-link"
					href="${pageContext.request.contextPath}/dispatcher?key=melon&methodName=selectAll2">
						<i class="fa fa-fw fa-minus-circle"></i> <span
						class="nav-link-text">Delete Restaurant</span>
				</a></li>


				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="My profile"><a class="nav-link"
					href="${pageContext.request.contextPath}/html/admin_section/user-profile.jsp">
						<i class="fa fa-fw fa-user"></i> <span class="nav-link-text">My
							Profile</span>
				</a></li>

			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-fw fa-envelope"></i> <span
						class="d-lg-none">Messages <span
							class="badge badge-pill badge-primary">12 New</span>
					</span> <span class="indicator text-primary d-none d-lg-block"> <i
							class="fa fa-fw fa-circle"></i>
					</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="messagesDropdown">
						<h6 class="dropdown-header">New Messages:</h6>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>David
								Miller</strong> <span class="small float-right text-muted">11:21
								AM</span>
							<div class="dropdown-message small">Hey there! This new
								version of SB Admin is pretty awesome! These messages clip off
								when they reach the end of the box so they don't overflow over
								to the sides!</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>Jane Smith</strong>
							<span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">I was wondering if you
								could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>John Doe</strong> <span
							class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">I've sent the final
								files over to you for review. When you're able to sign off of
								them let me know and we can discuss distribution.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item small" href="#">View all messages</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-fw fa-bell"></i> <span
						class="d-lg-none">Alerts <span
							class="badge badge-pill badge-warning">6 New</span>
					</span> <span class="indicator text-warning d-none d-lg-block"> <i
							class="fa fa-fw fa-circle"></i>
					</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="alertsDropdown">
						<h6 class="dropdown-header">New Alerts:</h6>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-success">
								<strong> <i class="fa fa-long-arrow-up fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-danger">
								<strong> <i class="fa fa-long-arrow-down fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-success">
								<strong> <i class="fa fa-long-arrow-up fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item small" href="#">View all alerts</a>
					</div></li>

				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"><i class="fa fa-fw fa-sign-out"></i>Logout</a>
				</li>
			</ul>
		</div>
	</nav>
	<!-- /Navigation-->

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">관리자 FORM</a></li>
				<li class="breadcrumb-item active">공지사항</li>
			</ol>

			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i>&nbsp스케쥴표
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="bbs_table">
							<caption>스케쥴표</caption>
							<colgroup>
								<col />
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 15%">
							</colgroup>
							<thead>
								<tr class="schedule_lst">
									<th scope="col"></th>
									<th scope="col">월</th>
									<th scope="col">화</th>
									<th scope="col">수</th>
									<th scope="col">목</th>
									<th scope="col">금</th>
									<th scope="col">토</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>08:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">미팅</a>카카오 - 이길동<span
												class="schedule_close">X</span>
										</div>
									</td>
									<td>
										
									</td>
									<td></td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">미팅</a>청솔- 이부장<span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>09:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">미팅</a>카카오 - 이길동<span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">미팅</a>청솔- 이부장<span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>10:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td class="
">
										<div class="schedule_area_v1">
											<a href="#">미팅</a>청솔- 이부장<span
												class="schedule_close">X</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>11:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>12:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>13:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>14:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>15:00</td>
									<td class="schu_line_bg">
										<div class="schedule_area_v1">
											<a href="#">출장</a><span
												class="schedule_close">X</span>
										</div>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>16:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>17:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>18:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>19:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>20:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>21:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>22:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>23:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
			<!-- /tables-->
		</div>
		<!-- /container-fluid-->
	</div>
	<!-- /container-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © MelonPlate 2020</small>
			</div>
		</div>
	</footer>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.jsp">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Page level plugin JavaScript-->
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
	<script src="vendor/jquery.selectbox-0.2.js"></script>
	<script src="vendor/retina-replace.min.js"></script>
	<script src="vendor/jquery.magnific-popup.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="js/admin.js"></script>
	<!-- Custom scripts for this page-->
	<script src="js/admin-datatables.js"></script>

</body>
</html>