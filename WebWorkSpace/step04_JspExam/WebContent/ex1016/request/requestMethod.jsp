<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> request Header 정보 가져오기 - 박유진 </h1>

<%
	
	Enumeration<String> e = request.getHeaderNames();

	while(e.hasMoreElements()){
		String name = e.nextElement();
		String value = request.getParameter(name);
		%>
		<h4><%=name %> : <%=value %></h4>
		
		<% 
		
	}
                                                                             
%>

<hr>
접속자 IP = <%=request.getRemoteAddr() %><br> <!-- 서버에 들어온 client의 ip -->
getContextPath = <%=request.getContextPath() %><br> <!-- 자동으로 root 밑의 contextPath 가져와서 나중에 설정할 때 쓴다  -->
getRealPath = <%=request.getRealPath("/") %><br> <!-- 서버 실행되는 경로 가져오기  -->
getRequestURL = <%=request.getRequestURL() %><br><!-- 실행된 url 가져오기 -->

</body>
</html>