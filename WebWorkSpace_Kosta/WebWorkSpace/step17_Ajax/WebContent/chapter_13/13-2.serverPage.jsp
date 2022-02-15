<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>13-2 serverPage.jsp 입니다앙</h2>

메세지 : ${param.name }님의 메세지는 ${param.message } 입니다 <br>

접속시간 : <%=new Date().toLocaleString() %>

</body>
</html>