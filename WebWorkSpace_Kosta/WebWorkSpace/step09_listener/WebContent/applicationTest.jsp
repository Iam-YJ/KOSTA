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
	<h1>ServletContextListener TEST</h1>



	<fieldset> <legend> 나라 선택</legend> 
	<c:forEach items="${applicationScope.nationMap}" var="map" varStatus="state">
		<input type="radio" name="radio" value="${map.key}">${map.value}
	</c:forEach>
	<p>
	</fieldset>


</body>
</html>