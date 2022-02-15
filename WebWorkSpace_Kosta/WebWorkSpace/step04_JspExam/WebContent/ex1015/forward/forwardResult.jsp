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

//param으로 전송되는 데이터 받기 
 String num = request.getParameter("no");
 String addr = request.getParameter("addr");
%>

<h1>forwardResult.jsp 문서입니다 </h1>
<h3>i의 값은? <%=num %></h3>
<h3>주소는? <%=addr %></h3>

</body>
</html>