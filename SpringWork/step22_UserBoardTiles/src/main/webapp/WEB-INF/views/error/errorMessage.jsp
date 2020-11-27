<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<%
response.setStatus(200); //위에 isErrorPage를 true로 했기 때문에 상태를 200으로 바꿔줘야한다
%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <script src="/controller/resources/js/jquery.form.min.js"></script> -->

<div class="container">
	<div class="col-lg-8 col-lg-offset-2 text-center">
		<div class="logo">
			<h1>Error !</h1>
		</div>
		<p class="lead text-muted">${errorMsg} / ${exception.message}</p>
		<div class="clearfix"></div>
		<div class="col-lg-6 col-lg-offset-3">
			<form action="index.html">

				<div class="input-group">
					<input type="text" placeholder="search ..." class="form-control" />
					<span class="input-group-btn">
						<button class="btn btn-primary" type="button">
							<i class="icon-align-left"></i>
						</button>
					</span>
				</div>

			</form>
		</div>
		<div class="clearfix"></div>
		<br />
		<div class="col-lg-6  col-lg-offset-3">
			<div class="btn-group btn-group-justified">
				<a href="${path}/user/login" class="btn btn-primary">Login</a>
				<a href="${path}" class="btn btn-success">Return Website</a>
			</div>

		</div>
	</div>


</div>
</body>
</html>