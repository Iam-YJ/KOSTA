<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
	%>
	<p>
		현재 날짜는 :
		<%=date%>
	</p>

	<%
		//요청(request) 데이터를 인코딩 
	request.setCharacterEncoding("utf-8");
	//username 필드의 값을 추출하기 
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String gender = request.getParameter("gender");
	String[] techArr = request.getParameterValues("tech");
	String tel = request.getParameter("tel");
	String birthdate = request.getParameter("date");
	String addr = request.getParameter("addr");
	%>


	<ul>
		<li>이름 : <%=username%></li>
		<li>이메일 : <%=email%></li>
		<li>아이디 : <%=userid%></li>
		<li>비밀번호 : <%=password%></li>
		<li>성별 : <%=gender%></li>

		<%
			for (String tech : techArr) {
		%>
		<li>관심분야 : <%=tech%> </li>
		<%
			}
		%>
		<li>전화번호 : <%=tel %></li>
		<li>생년월일 : <%out.println(birthdate); %></li>
		<li>주소 : <%=addr %></li>


	</ul>

</body>
</html>