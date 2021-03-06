<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Ansonika">
  <title>FOOGRA - Admin dashboard</title>
   
  <!-- Favicons-->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/html/admin_section/css/img/favicon.ico" type="image/x-icon">
  <link rel="apple-touch-icon" type="image/x-icon" href="${pageContext.request.contextPath}/html/admin_section/css/img/apple-touch-icon-57x57-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="${pageContext.request.contextPath}/html/admin_section/css/img/apple-touch-icon-72x72-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="${pageContext.request.contextPath}/html/admin_section/css/img/apple-touch-icon-114x114-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="${pageContext.request.contextPath}/html/admin_section/css/img/apple-touch-icon-144x144-precomposed.png">
   
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/html/admin_section/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Main styles -->
  <link href="${pageContext.request.contextPath}/html/admin_section/css/admin.css" rel="stylesheet">
  <!-- Icon fonts-->
  <link href="${pageContext.request.contextPath}/html/admin_section/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Plugin styles -->
  <link href="${pageContext.request.contextPath}/html/admin_section/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/html/admin_section/vendor/dropzone.css" rel="stylesheet">
  <!-- Your custom styles -->
  <link href="${pageContext.request.contextPath}/html/admin_section/css/custom.css" rel="stylesheet">

   <script type="text/javascript">
    function updateUserInfo(){
       alert(1);
    }
   </script>


    <!-- /.container -->

    <script src="vendor2/js/jquery.min.js"></script>
    <script src="vendor2/js/bootstrap.min.js"></script>
    <script src="vendor2/js/moment.min.js"></script>
    <script src="vendor2/js/fullcalendar.min.js"></script>
    <script src="vendor2/js/ko.js"></script>
    <script src="vendor2/js/select2.min.js"></script>
    <script src="vendor2/js/bootstrap-datetimepicker.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/addEvent.js"></script>
    <script src="js/editEvent.js"></script>
    <script src="js/etcSetting.js"></script>


</head>

<body class="fixed-nav sticky-footer" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-default fixed-top" id="mainNav">
      <a class="navbar-brand" href="index.html"><img src="html/admin_section/img/logo.svg" data-retina="true" alt="" width="142" height="36"></a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                  <a class="nav-link" href="index.jsp">
                      <i class="fa fa-fw fa-dashboard"></i>
                      <span class="nav-link-text">Dashboard</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Messages">
                  <a class="nav-link" href="messages.jsp">
                      <i class="fa fa-fw fa-envelope-open"></i>
                      <span class="nav-link-text">Messages</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="Bookings">
                  <a class="nav-link" href="bookings.jsp">
                      <i class="fa fa-fw fa-calendar-check-o"></i>
                      <span class="nav-link-text">Bookings <span class="badge badge-pill badge-primary">6 New</span></span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="My listings">
                  <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMylistings" data-parent="#mylistings">
                      <i class="fa fa-fw fa-list"></i>
                      <span class="nav-link-text">My listings</span>
                  </a>
                  <ul class="sidenav-second-level collapse" id="collapseMylistings">
                      <li>
                          <a href="listings.jsp">Pending <span class="badge badge-pill badge-primary">6</span></a>
                      </li>
                      <li>
                          <a href="listings.jsp">Active <span class="badge badge-pill badge-success">6</span></a>
                      </li>
                      <li>
                          <a href="listings.jsp">Expired <span class="badge badge-pill badge-danger">6</span></a>
                      </li>
                  </ul>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Reviews">
                  <a class="nav-link" href="reviews.jsp">
                      <i class="fa fa-fw fa-star"></i>
                      <span class="nav-link-text">Reviews</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Bookmarks">
                  <a class="nav-link" href="bookmarks.jsp">
                      <i class="fa fa-fw fa-heart"></i>
                      <span class="nav-link-text">Bookmarks</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Add listing">
                  <a class="nav-link" href="add-listing.jsp">
                      <i class="fa fa-fw fa-plus-circle"></i>
                      <span class="nav-link-text">Add listing</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Add listing + Menu List">
                  <a class="nav-link" href="add-listing-with-menu-list.jsp">
                      <i class="fa fa-fw fa-plus-circle"></i>
                      <span class="nav-link-text">Add listing + Menu List</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Orders Page">
                  <a class="nav-link" href="orders.jsp">
                      <i class="fa fa-fw fa-shopping-basket"></i>
                      <span class="nav-link-text">Orders Page</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Edit Order">
                  <a class="nav-link" href="orders.jsp">
                      <i class="fa fa-fw fa-pencil"></i>
                      <span class="nav-link-text">Edit Order</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="My profile">
                  <a class="nav-link" href="user-profile.jsp">
                      <i class="fa fa-fw fa-user"></i>
                      <span class="nav-link-text">My Profile</span>
                  </a>
              </li>
              <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
                  <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#Components">
                      <i class="fa fa-fw fa-gear"></i>
                      <span class="nav-link-text">Components</span>
                  </a>
                  <ul class="sidenav-second-level collapse" id="collapseComponents">
                      <li>
                          <a href="charts.html">Charts</a>
                      </li>
                      <li>
                          <a href="tables.html">Tables</a>
                      </li>
                  </ul>
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
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Add listing</li>
      </ol>
      <div class="box_general padding_bottom">
         <div class="header_box version_2">
            <h2><i class="fa fa-user"></i>Profile details</h2>
         </div>
         
         <div class="row">
         
            <div class="col-md-4">
               <div class="form-group">
               <label>Your photo</label>
                  <form action="/file-upload" class="dropzone"></form>
                </div>
            </div>
            <div class="col-md-8 add_top_30">
               <div class="row">
               
                  <div class="col-md-6">
                     <div class="form-group">
                        <label>Nickname</label>
                        <input type="text" class="form-control" value="${user.nickname}">
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group">
                        <label>??????</label>
                        <input type="text" class="form-control" value="${user.grade}">
                     </div>
                  </div>
                  
               </div>
               <!-- /row-->
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group">
                        <label>Point</label>
                        <input type="text" class="form-control" value="${user.point}">
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" value="${user.email}">
                     </div>
                  </div>
               </div>
               <!-- /row-->
               <div class="row">
                  <div class="col-md-12">
                     <div class="form-group">
                        <label>????????????</label>
                        <textarea style="height:43px;" class="form-control" >${user.prefer}</textarea>
                     </div>
                  </div>
                  
               </div>
               <!-- /row-->
               
            </div>
         </div>
      </div>
      <!-- /box_general-->
      <form name="writeForm" method="post" action="${pageContext.request.contextPath}/dispatcher?key=user&methodName=updateUserInfo&user_no=${user.userNo}"
      onSubmit='return checkValid()'>
      <div class="row">
         <div class="col-md-12">
            <div class="box_general padding_bottom">
               <div class="header_box version_2">
                  <h2><i class="fa fa-lock"></i>???????????? ??????</h2>
               </div>
               <div class="form-group">
                  <label>????????? ?????????</label>
                  <input class="form-control" name="new_nickname"  type="text" value="${user.nickname}">
               </div>
               <div class="form-group">
                  <label>????????? ?????????</label>
                  <input class="form-control" name="new_email" id="new_email" type="email" value="${user.email}">
               </div>
               <div class="form-group">
                  <label>????????? ????????????</label>
                  <input class="form-control" name="new_prefer"  type="text" value="${user.prefer}">
               </div>
               <input type="submit" class="btn_1 medium"  value="??????">
            </div>
         </div>
      </div>
      </form>
      <!-- /row-->
      <!-- ????????? ?????? -->
               <div class="row">
            <div class="col-md-6">
               <div class="box_general padding_bottom">
                  <div class="header_box version_2">
                     <h2>Attendance Check</h2>
                  </div>

                  <style>
table {
   width: 400px;
   height: 200px;
   border: 5px solid gray;
   margin: auto;
}

tr, td {
   width: 1px;
   border: 1px solid black;
   text-align: center;
}

td:nth-child(1) {
   width: 1px;
   border: 1px solid black;
   color: orange;
   text-align: center;
}

td:nth-child(7) {
   width: 1px;
   border: 1px solid black;
   color: skyblue;
   text-align: center;
}
</style>
                  <script type="text/javascript">
                     var today = new Date();
                     var mfd = new Date(today.getFullYear(), today
                           .getMonth(), 1);
                     var endDays = new Array(31, 29, 31, 30, 31, 30, 31,
                           31, 30, 31, 30, 31);
                     var lastDay = endDays[today.getMonth()];
                     var week = Math.ceil((mfd.getDay() + lastDay) / 7);
                     var date = 1;
                     var start = 0;

                     document.write("<table>");
                     document.write("<tr>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("<td>");
                     document.write("???");
                     document.write("</td>");
                     document.write("</tr>");
                     for (var i = 0; i < week; i++) {
                        document.write("<tr>");
                        for (var j = 0; j < 7; j++) {
                           document.write("<td>");
                           if (start < mfd.getDay()) {
                              document.write("");
                              start++;
                           } else if (date > lastDay) {
                              document.write("");
                           } else if (date == today.getDate()) {
                              document
                                    .write("<a href='#' onclick='imgInsert()' id='cal'>"
                                          + date)

                              date++;
                           } else {
                              document.write(date);
                              date++;
                           }
                           document.write("</td>");
                        }
                        document.write("</tr>");
                     }

                     document.write("</table>");

                     function imgInsert() {
                        $('#cal').html('???');
                        alert("?????? ?????? ! ")
                     }
                  </script>
                  <!-- calendar -->



               </div>



            </div>



            <div class="col-md-6">
               <div class="box_general padding_bottom">
                  <div class="agree">
                     <h4>Interests</h4>
                     <hr>
                     <form
                        action="${pageContext.request.contextPath}/dispatcher?key=user&methodName=interestInsert"
                        method="post">
                        <!-- .agree -->
                        <ul>
                           <li><label for="a2"><span>??????&nbsp&nbsp</span></label><input
                              type="checkbox" value="??????" name="interests" /></li>

                           <li><label for="a3"><span>??????&nbsp&nbsp</span><input
                                 type="checkbox" value="??????" name="interests" /></label></li>

                           <li><label for="a4"><span>??????&nbsp&nbsp</span><input
                                 type="checkbox" value="??????" name="interests" /></label></li>

                           <li><label for="a4"><span>??????&nbsp&nbsp</span><input
                                 type="checkbox" value="??????" name="interests" /></label></li>

                           <li><label for="a4"><span>??????&nbsp&nbsp</span><input
                                 type="checkbox" value="??????" name="interests" /></label></li>

                  
                              <input type="submit" value="Submit"> &nbsp <input
                                 type="reset" value="Reset">

                        </ul>
                     </form>
                  </div>


               </div>
            </div>



         </div>
     </div>
     <!-- /.container-fluid-->
      </div>
    <!-- /.container-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright ?? FOOGRA 2020</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">??</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
                                    
                  
<!-- calendar -->            

<!-- calendar -->


      
    
         <!-- /row-->
         <p>
            <a href="#0" class="btn_1 medium">Save</a>
         </p>
      </div>
      <!-- /.container-fluid-->
   <!-- /.container-wrapper-->
   <footer class="sticky-footer">
      <div class="container">
         <div class="text-center">
            <small>Copyright ?? FOOGRA 2020</small>
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
                  <span aria-hidden="true">??</span>
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
   <script src="vendor/dropzone.min.js"></script>

</body>
</html>