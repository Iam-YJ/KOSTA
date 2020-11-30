<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
  a{text-decoration: none;}
</style>
</head>
<body>
<h1>Spring Security 요청</h1>
<h4>
   USER :  사용자 /  
   MEMBER : 가입된 사용자 /
   ADMIN : 관리자 <p>
</h4>

<h5>
<c:if test="${not empty pageContext.request.userPrincipal}">
	<hr>
	${pageContext.request.userPrincipal.name}님 / 
	<form method="post" action="${pageContext.request.contextPath}/logout">
	<input type="submit" value="로그아웃"/>
	<input type="hidden" name="${_csrf.parameterName}" VALUE="${_csrf.token}"/>
	</form>	
	<p>
	
</c:if>
<a href="${pageContext.request.contextPath}"> index</a></h5 >

<h2> USER </h2>
<a href="${pageContext.request.contextPath}/user/main">user/main - 인증없이 접근 가능</a><p>
<a href="${pageContext.request.contextPath}/user/login">user/login - 인증해야만 접근 가능(ROLE_USER)</a><p>
<a href="${pageContext.request.contextPath}/user/loginForm">user/loginForm - 인증없이 접근 가능</a><p>
<a href="${pageContext.request.contextPath}/user/board">user/board - 인증없이 접근 가능</a><p>

<h2> MEMBER </h2>
<a href="${pageContext.request.contextPath}/member/main">member/main - 인증해야만 접근 가능</a><p>
<a href="${pageContext.request.contextPath}/member/mypage">member/mypage - 인증해야만 접근 가능</a><p>



<h2> Admin </h2>
<a href="${pageContext.request.contextPath}/admin/main">admin/main - 인증해야만 접근 가능(ROLE_ADMIN,ROLE_USER)</a><p>
<a href="${pageContext.request.contextPath}/admin/board">admin/board - 인증해야만 접근 가능(ROLE_ADMIN,ROLE_USER)</a><p>
</body>
</html>







