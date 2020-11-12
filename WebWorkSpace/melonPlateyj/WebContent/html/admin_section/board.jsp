<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Ansonika">
<title>FOOGRA - Admin dashboard</title>

<!-- Favicons-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/html/admin_section/html/img/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" type="image/x-icon"
	href="img/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon" type="image/x-icon" sizes="144x144"
	href="img/apple-touch-icon-144x144-precomposed.png">

<!-- Bootstrap core CSS-->
<link
	href="${pageContext.request.contextPath}/html/admin_section/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Main styles -->
<link
	href="${pageContext.request.contextPath}/html/admin_section/css/admin.css"
	rel="stylesheet">
<!-- Icon fonts-->
<link
	href="${pageContext.request.contextPath}/html/admin_section/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Plugin styles -->
<link
	href="${pageContext.request.contextPath}/html/admin_section/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Your custom styles -->
<link
	href="${pageContext.request.contextPath}/html/admin_section/css/custom.css"
	rel="stylesheet">

</head>

<body class="fixed-nav sticky-footer" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-default fixed-top" id="mainNav">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
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
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Board">
                  <a class="nav-link" href="${pageContext.request.contextPath}/dispatcher?key=admin&methodName=selectNoti">
                      <i class="fa fa-fw fa-envelope-open"></i>
                      <span class="nav-link-text">NOTICE</span>
                  </a>
              </li>
                           
            
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Add Restaurant">
                    <a class="nav-link" href="${pageContext.request.contextPath}/html/admin_section/add-listing-with-menu-list.jsp">
                        <i class="fa fa-fw fa-plus-circle"></i>
                        <span class="nav-link-text">Add Restaurant</span>
                    </a>
                </li>
                 <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Delete Restaurant">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dispatcher?key=melon&methodName=selectAll2">
                        <i class="fa fa-fw fa-minus-circle"></i>
                        <span class="nav-link-text">Delete Restaurant</span>
                    </a>
                </li>
              
           
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="My profile">
                  <a class="nav-link" href="${pageContext.request.contextPath}/html/admin_section/user-profile.jsp">
                      <i class="fa fa-fw fa-user"></i>
                      <span class="nav-link-text">My Profile</span>
                  </a>
              </li>
             
          </ul>
          <ul class="navbar-nav sidenav-toggler">
              <li class="nav-item">
                  <a class="nav-link text-center" id="sidenavToggler">
                      <i class="fa fa-fw fa-angle-left"></i>
                  </a>
              </li>
          </ul>
          <ul class="navbar-nav ml-auto">
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fa fa-fw fa-envelope"></i>
                      <span class="d-lg-none">Messages
                          <span class="badge badge-pill badge-primary">12 New</span>
                      </span>
                      <span class="indicator text-primary d-none d-lg-block">
                          <i class="fa fa-fw fa-circle"></i>
                      </span>
                  </a>
                  <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                      <h6 class="dropdown-header">New Messages:</h6>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <strong>David Miller</strong>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <strong>Jane Smith</strong>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <strong>John Doe</strong>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item small" href="#">View all messages</a>
                  </div>
              </li>
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fa fa-fw fa-bell"></i>
                      <span class="d-lg-none">Alerts
                          <span class="badge badge-pill badge-warning">6 New</span>
                      </span>
                      <span class="indicator text-warning d-none d-lg-block">
                          <i class="fa fa-fw fa-circle"></i>
                      </span>
                  </a>
                  <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                      <h6 class="dropdown-header">New Alerts:</h6>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <span class="text-success">
                              <strong>
                                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                          </span>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <span class="text-danger">
                              <strong>
                                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
                          </span>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">
                          <span class="text-success">
                              <strong>
                                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                          </span>
                          <span class="small float-right text-muted">11:21 AM</span>
                          <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                      </a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item small" href="#">View all alerts</a>
                  </div>
              </li>
              <li class="nav-item">
                  <form class="form-inline my-2 my-lg-0 mr-lg-2">
                      <div class="input-group">
                          <input class="form-control search-top" type="text" placeholder="Search for...">
                          <span class="input-group-btn">
                              <button class="btn btn-primary" type="button">
                                  <i class="fa fa-search"></i>
                              </button>
                          </span>
                      </div>
                  </form>
              </li>
              <li class="nav-item">
                  <a class="nav-link" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-fw fa-sign-out"></i>Logout</a>
              </li>
          </ul>
      </div>
  </nav>
	<!-- /Navigation-->

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">관리자 FROM</a></li>
				<li class="breadcrumb-item active">공지사항<></li>
			</ol>

			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i>공지사항
				</div>
				<div class="card-body">
					<div class="table-responsive">

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>NO</th>
									<th>USERNO</th>
									<th>TITLE</th>
									<th>CONTENT</th>
									<th>DATE</th>
									<th>HITS</th>
									<th>Edit</th>

								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>NO</th>
									<th>USERNO</th>
									<th>TITLE</th>
									<th>CONTENT</th>
									<th>DATE</th>
									<th>HITS</th>
									<th>Edit</th>
								</tr>
							</tfoot>

							<tbody>
								<c:forEach items="${list}" var="list" varStatus="state">
									<tr>
										<td>${state.count}</td>
										<td>${list.userNo}</td>
										<td>${list.notiTitle}</td>
										<td>${list.notiContent}</td>
										<!--<a href="elec?command=read&modelNum=${elecDto.modelNum}">  -->
										<td>${list.notiDate}</td>
										<td>${list.notiHits}</td>
										<td><a href="edit-order.html"><a href="${pageContext.request.contextPath}/dispatcher?key=admin&methodName=deleteNotice&notiNo=${list.notiNo}"><strong>Delete</strong></a></td>
									</tr>
								</c:forEach>

								<!-- 	private int notiNo;// 공지사항 No
	private int userNo;// 유저 No
	private String notiTitle;// 공지사항 제목
	private String notiDate;// 공지사항 작성날짜
	private String notiContent;// 공지사항 내용
	private int notiHits;// 공지사항 조회수 -->

							</tbody>

						</table>

					</div>
					<hr>
					<a href="#0" class="btn_1 gray delete" data-toggle="modal"
						data-target="#edit_booking"><i class="fa fa-fw fa-pencil"></i>글쓰기</a>
					</li>
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

	<!-- Insert Modal -->
	<div class="modal fade" id="edit_booking" tabindex="-1" role="dialog"
		aria-labelledby="edit_bookingLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="edit_bookingLabel">공지사항 글쓰기</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>

				</div>
				
				<div class="modal-body">
				<form name="myForm"
				action="${pageContext.request.contextPath}/dispatcher?key=admin&methodName=insertNotice"
				method="post">
					<div class="form-group">
						<label>Title</label> <input type="text" class="form-control"
							name="notiTitle">
					</div>

					<div class="form-group">
						<label>Content</label> <input type="text" class="form-control"
							name="notiContent">
					</div>
				
				</form>
					<div class="modal-footer">
						<a class="btn btn-primary" href="#0" onclick="javascript:document.myForm.submit();">Save</a>
					</div>
				
				</div>

			</div>

		</div>
	</div>
	</div>

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
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Page level plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/chart.js/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/datatables/dataTables.bootstrap4.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/jquery.selectbox-0.2.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/retina-replace.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/html/admin_section/vendor/jquery.magnific-popup.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath}/html/admin_section/js/admin.js"></script>
	<!-- Custom scripts for this page-->
	<script
		src="${pageContext.request.contextPath}/html/admin_section/js/admin-datatables.js"></script>


</body>
</html>
