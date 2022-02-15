<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>요청 결과 : ${message}</h2>

	<c:forEach items="${hobbys}" var="h">
		<input type="checkbox" value="${h}"> ${h}
	</c:forEach>
	
	
	<hr>
	주소 : ${addr}


</body>
</html>