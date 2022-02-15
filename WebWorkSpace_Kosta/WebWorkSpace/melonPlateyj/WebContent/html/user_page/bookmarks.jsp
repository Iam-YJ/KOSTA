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
    <title>FOOGRA - User Page</title>
    <!-- Favicons-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/html/admin_section/img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="${pageContext.request.contextPath}/html/admin_section/img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="${pageContext.request.contextPath}/html/admin_section/img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="${pageContext.request.contextPath}/html/admin_section/img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="${pageContext.request.contextPath}/html/admin_section/img/apple-touch-icon-144x144-precomposed.png">
    <!-- Bootstrap core CSS-->
    <link href="${pageContext.request.contextPath}/html/admin_section/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Main styles -->
    <link href="${pageContext.request.contextPath}/html/admin_section/css/admin.css" rel="stylesheet">
    <!-- Icon fonts-->
    <link href="${pageContext.request.contextPath}/html/admin_section/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Plugin styles -->
    <link href="${pageContext.request.contextPath}/html/admin_section/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Your custom styles -->
    <link href="${pageContext.request.contextPath}/html/admin_section/css/custom.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer" id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-default fixed-top" id="mainNav">
        <a class="navbar-brand" href="index.html"><img src="${pageContext.request.contextPath}/html/user_page/img/mlogo.png" data-retina="true" alt="" width="142" height="36"></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                
               
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Reviews">
                    <a class="nav-link"  id = "re">
                        <i class="fa fa-fw fa-star"></i>
                        <span class="nav-link-text">나의 리뷰</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Bookmarks">
                    <a class="nav-link"  id="wish">
                        <i class="fa fa-fw fa-heart"></i>
                        <span class="nav-link-text">나의 찜목록</span>
                    </a>
                </li>
                 <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Listings">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dispatcher?key=writing&methodName=selectWriting">
                        <i class="fa fa-fw fa-pencil"></i>
                        <span class="nav-link-text">글 보기</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Add listing">
                    <a class="nav-link" href="${pageContext.request.contextPath}/html/user_page/add-listing.jsp">
                        <i class="fa fa-fw fa-plus-circle"></i>
                        <span class="nav-link-text">글 쓰기</span>
                    </a>
                </li>
                
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Orders Page">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dispatcher?key=user&methodName=selectNotice">
                        <i class="fa fa-fw fa-list"></i>
                        <span class="nav-link-text">공지사항</span>
                    </a>
                </li>
                 <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Orders Page">
                    <a class="nav-link" href="${pageContext.request.contextPath}/html/user_page/ftest.jsp">
                        <i class="fa fa-fw fa-star"></i>
                        <span class="nav-link-text">미니테스트</span>
                    </a>
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
                    <a href="${pageContext.request.contextPath}/dispatcher?key=user&methodName=selectUserInfo&user_no=1">My Page</a>
                </li>
                <li class="breadcrumb-item active">BookMarks</li>
            </ol>
            <div class="box_general">
                <div class="header_box">
                    <h2 class="d-inline-block">Bookmarks</h2>
                    
                </div>
                <div class="list_general">
                <c:forEach items="${requestScope.list}" var="list">
                    <ul>
                        <li>
                            <figure><img src="${list.resPhoto}" alt=""></figure>
                            <small>${list.resType}</small>
                            <small>${list.resGrade}/5</small>
                            <h4>${list.resName}</h4>
                            <p>${list.resPlace}</p>
                            <p><a href="${pageContext.request.contextPath}/dispatcher?key=melon&methodName=selectDetailRes&resNo=${list.resNo}" class="btn_1 gray"><i class="fa fa-fw fa-eye"></i> View item</a></p>
                            <ul class="buttons">
                                <li><a href="#" id="cancel" name="${list.resNo}" value = "${list.resNo}" class="btn_1 gray delete wishlist_close"><i class="fa fa-fw fa-times-circle-o"></i> Cancel</a></li>
                            </ul>
                        </li>
                    </ul>
                    </c:forEach>
                </div>
            </div>
            <!-- /box_general-->
            
        </div>
        <!-- /container-fluid-->
    </div>
    <!-- /container-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © FOOGRA 2020</small>
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
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
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
    <script type="text/javascript" src ="${pageContext.request.contextPath}/html/js/jquery-3.5.1.min.js" ></script>
    <script type="text/javascript">
    $(function() {
       var resNo = $("#cancel").attr("value");
       $("#re").attr("href", "${pageContext.request.contextPath}/dispatcher?key=reply&methodName=selectReplyByUserNo&user_no="+sessionStorage.getItem("userNo"));
       $("#wish").attr("href", "${pageContext.request.contextPath}/dispatcher?key=user&methodName=seleteBookMark&user_no="+sessionStorage.getItem("userNo"));
       $("#cancel").attr("href", "${pageContext.request.contextPath}/dispatcher?key=user&methodName=deleteBookMark&res_no="+ resNo +"&user_no="+sessionStorage.getItem("userNo"));
    });
    </script>
</body>

</html>