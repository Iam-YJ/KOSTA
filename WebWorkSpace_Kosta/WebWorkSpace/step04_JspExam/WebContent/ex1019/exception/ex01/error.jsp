<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%
    	//isErrorPage를 설정하면 응답상태코드가 500이 전송된다
    	//현재 page의 상태코드를 200으로 변경할 필요가 있다
    	
    	response.setStatus(200);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 에러 입니당 !~!!</h3>

exception() : <%=exception%><br>
exception.getMessage() : <%=exception.getMessage()%><br>
exception.getClass() : <%=exception.getClass()%><br>
<br>
<br>

<hr color="blue">

<A href="exceptionForm.jsp">홈으로 </A>

</body>
</html>