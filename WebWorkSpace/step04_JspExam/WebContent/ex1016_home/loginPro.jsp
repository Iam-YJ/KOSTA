<%@page import="java.util.Date"%>
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

	String dbid = "1111";
	String dbpwd = "1111";

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if (dbid.equals(id) && dbpwd.equals(pwd)) {
		//세션에 현재 인증된 사용자 정보 저장하기 
		session.setAttribute("sessionId",id);	
		out.println("로그인 중");
		
		
		%>
		<br>
		<button type="submit">로그아웃</button> 
 		<!-- <script>
		top.location.href="index.jsp";
		</script> -->
		
		<% 
		
	} else {
	%>
	<script>
		alert("정보가 일치하지 않습니다.");
		history.back(); //뒤로가기
	</script>

	<%
		}
	%>


</body>
</html>