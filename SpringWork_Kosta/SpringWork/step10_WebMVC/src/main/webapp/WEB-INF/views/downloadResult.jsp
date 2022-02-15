<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
a{text-decoration:none}

</style>
<body>

<h1> save 폴더 안에 download 한 것들</h1>

<ul>
<c:forEach items="${fileNames}" var="file">
	<li><a href="${pageContext.request.contextPath}/down.do?fileName=${file}">name : ${file}</a></li>
</c:forEach>
</ul>
</body>
</html>