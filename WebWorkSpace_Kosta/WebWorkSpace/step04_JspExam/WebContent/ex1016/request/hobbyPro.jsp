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
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");

	
%>




<h3>
이름 : <%=name %><br>
나이 : <%= age %><br>
취미 : <%= request.getParameterValues("hobby")%><br>

취미 : 
<%
request.setCharacterEncoding("utf-8");

String hobbys [] = request.getParameterValues("hobby");

for(String s : hobbys){
	out.print(s+", ");
}
%>

</h3>
</body>
</html>