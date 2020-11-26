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

<h1> Spring Tiles Test</h1>

<!--  tiles는 @requestMapping과는 관계없고 ModelAndView로 어떻게 리턴해주는지가 중요하다  -->

<a href="test1">user/login.jsp 이동</a><p>
<a href="test2">user/join.jsp 이동</a><p>

<a href="test3">board/list.jsp 이동</a><p>
<a href="test4">board/read.jsp 이동</a><p>

<a href="test5">타일즈 적용 안됨</a><p>

<a href="test6">board/free/write.jsp 이동</a><p>
<a href="test7">board/qna/list.jsp 이동</a><p>

</body>
</html>