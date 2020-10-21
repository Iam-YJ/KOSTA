<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> JSTL - &lt;c:set> or &lt;c:out></h1>
<c:out value="안녕"/> , ${"안녕" }<br>
<c:out value="<h1>배고프다</h1>"/><br> , ${"<h1>배고프다</h1>" }<br>
<c:out value="<h1>배고프다</h1>" escapeXml="true"/><br> <!-- true 이면 문자취급 된다(생략해도 문자취급) -> 보안 굿   -->
<c:out value="<h1>배고프다</h1>" escapeXml="false"/><br>

<hr>
<%
String addr = "서울"; //표현언어에서(${}) 바로 사용안됨(xxxScope에 저장되어 있어야한다)
session.setAttribute("addr", "서울");

%>

<%=addr %> / ${addr } / 
<hr>
<c:set var="message" value="밥 먹어요!" scope="session"/>
<c:set var="id" value="나는유진" />
<c:set var="age" value="20" scope="application"/>

<h3>set 정보 확인하기</h3>
메세지 : ${message } /  <c:out value="${message }"/><br> 
아이디 : ${id } /  <c:out value="${id }"/><br> 
나이 : ${age } /  <c:out value="${age }"/><br> 

저장된 정보 제거하기 <br>
<c:remove var="message"/>

<h3>set 정보 다시 확인하기</h3>
메세지 : ${message } /  <c:out value="${message }"/><br> 
아이디 : ${id } /  <c:out value="${id }"/><br> 
나이 : ${age } /  <c:out value="${age }"/><br> 

<a href="ex02_result.jsp">확인하자</a>

</body>
</html>