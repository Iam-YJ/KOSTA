<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	session.invalidate();
	//response.sendRedirect("index.jsp");
%>
<script>
top.location.href="index.jsp"; /* 전체가 새로고침 되기 위해 top. 으로 쓴다  */
</script>
</body>
</html>