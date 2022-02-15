<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//클라이언트쪽의 cache 기능 만료시켜야 한다
response.setHeader("Cache-Control", "no-store");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.5.1.js"></script>

<script>
	$(function() {
		$("[type=button]").click(function() {
			if (confirm("정말 로그아웃 할래?")) {
				//이동하기
				location.href = "Logout.jsp";
			}
		});
	})
</script>

</head>

<body>
	<h3></h3>

<%-- 		<%
			if (session.getAttribute("sessionName") == null) {
			//response.sendRedirect("LoginForm.jsp");
		%>
		<script>
			alert("인증하고 오세요");
			location.href = "LoginForm.html";
		</script>

		<%
			} else {
		%>
		<h3><%=session.getAttribute("sessionName")%>님 로그인중 <br>
			[접속시간 :
			<%=session.getAttribute("sessionTime")%>]<br> <img
				src="img/common.jpg">
			<p>

				<button type="button">로그아웃</button>
		</h3>
		<%
			}
		%> --%>


			<c:choose>
				<c:when test= "${sessionScope.sessionName != null }">
				<img src="img/c.jpg">
					<h3>${sessionName}님 로그인중 <br>
					[접속시간 : ${creationTime}] <br>
						<button type="button">로그아웃</button>
					</h3>
				</c:when>
				
				<c:otherwise>
					alert("인증하고 오세요");
  				 	location.href = "LoginForm.html"; 
				</c:otherwise>
				
			</c:choose>
		
		
		
				
		
</body>
</html>