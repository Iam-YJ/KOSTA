<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>session 저장된 정보 확인하기</h3>
아이디 : <%=session.getAttribute("id") %>
취미 : <%=session.getAttribute("hobbys") %>
메세지 : <%=session.getAttribute("message") %>

<hr color="red">

<h3>application에 저장된 정보 조회하기</h3>
주소 : <%=application.getAttribute("addr") %><br>
메세지 : <%=application.getAttribute("message") %><br>

</body>
</html>