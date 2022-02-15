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
//param으로 전송된 데이터 받기
String id = request.getParameter("id");
String addr = request.getParameter("addr");
%>

<h3>footer.jsp 입니다</h3>
아이디 : <%=id %> <br>
주소 : <%=addr %> <br>
</body>
</html>