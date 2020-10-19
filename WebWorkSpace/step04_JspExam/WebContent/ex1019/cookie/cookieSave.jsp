<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Cookie - 필요한 정보를 client pc 쪽에 저장하는 것 </h3>

<%
 //쿠키를 생성해서 저장한다
 Cookie co1 = new Cookie("id","jang");
 Cookie co2 = new Cookie("age","20");
 
 //옵션설정
 co1.setMaxAge(60*60*24); //1일 
 //0이면 삭제, -1 이면 저장 안됨
 co2.setMaxAge(60*60*24*365); //1년 
 
 co1.setPath("/");
 //co2.setPath("/");
 
 //쿠키를 저장한다
 response.addCookie(co1);
 response.addCookie(co2);
 
 
%>

<a href="cookieGet.jsp">쿠키 확인하러 가자 </a>

</body>
</html>