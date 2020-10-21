<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h3>set 정보 확인하기</h3>
메세지 : ${message } /  <c:out value="${message }"/><br> 
아이디 : ${id } /  <c:out value="${id }"/><br> 
나이 : ${age } /  <c:out value="${age }"/><br> 

</body>
</html>