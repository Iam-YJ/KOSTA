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


	<h1>Member 객체 사용하기</h1>

	<h3>
		아이디 : ${member.id} <br> 
		이름 : ${member.name} <br> 
		나이 : ${member.age} <br> 
		주소 : ${member.addr} <br>

	</h3>
	
	
		<h1>@ModelAttribute("m")을 이용한 별칭</h1>

	<h3>
		아이디 : ${m.id} <br> 
		이름 : ${m.name} <br> 
		나이 : ${m.age} <br> 
		주소 : ${m.addr} <br>

	</h3>
	
	<h1>@ModelAttribute을 이용해 저장</h1>
	
	<c:forEach items="${hobbys}" var="h">
		<input type="checkbox" value="${h}"> ${h}
	</c:forEach>
	
	
	<hr>
	주소 : ${addr}
	
</body>
</html>