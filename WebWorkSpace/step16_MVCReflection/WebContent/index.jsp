<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> WEB MVC 기반의 Refactoring</h1>
<h3>
<!-- 요청이 될 때 어떤 Controller의 어떤 메소드를 호출해야할지는 param 정보로 전달한다 
	회원 : key=user&methodName=값
	게시판 : key=board&mehodName=값
 -->
<a href="front?key=user&methodName=register">회원가입</a><br>
<a href="front?key=user&methodName=login">로그인</a><br>

<a href="front?key=board&methodName=list">게시판보기</a><br>
<a href="front?key=board&methodName=read">게시물 상세보기</a><br> 

</h3>
</body>
</html>