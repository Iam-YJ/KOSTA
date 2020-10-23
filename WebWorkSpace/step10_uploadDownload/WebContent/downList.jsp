<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{text-decoration:none;}
</style>
</head>
<body>

	<c:forEach var="file" items="${fileNames}">
		<li><a href="downLoad?fName=${file}" >${file}</a></li>
		<br>
	</c:forEach>

</body>
</html>