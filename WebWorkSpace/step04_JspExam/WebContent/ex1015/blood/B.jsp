<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이렇게 쓸 수 있는 이유는 
bloodPro.jsp에서 forward 되어서 request가 유지되어서 그렇다 
forward는 request, response가 유지되기 때문이다  -->
<%
String name = request.getParameter("name");
%>

<h3>이름은 <%=name %></h3>
<h3>B형의 성격은 b합니다</h3>

</body>
</html>