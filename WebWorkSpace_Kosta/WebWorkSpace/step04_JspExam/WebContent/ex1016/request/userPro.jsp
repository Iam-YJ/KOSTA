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
<h1> 가입된 정보 출력 </h1>

<% 
request.setCharacterEncoding("utf-8");
 //전송된 모든 name의 정보를 가져오기 
 Enumeration<String> e = request.getParameterNames();
 while(e.hasMoreElements()){
	String name =  e.nextElement();
	String s = request.getParameter(name);
	out.println(name + " = " + s+"<br>");
 }
 

%>
</body>
</html>