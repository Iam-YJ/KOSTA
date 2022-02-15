<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward 액션 태그</h1>
	<%
	 request.setCharacterEncoding("utf-8");
		int i = 0;
	for (i = 0; i <= 10; i++) {
		out.println(i+"<br>");
		// jsp 안에서 html 태그를 쓰고 싶으면 out.print("") 안에 하면 된다 
	}
	%>

<!-- forward 태그를 만나면 page에서 설정한 문서가 포워딩된다 
	(현재 page가 설정한 문서로 변환된다)
	 -->
<jsp:forward page="forwardResult.jsp">
	<jsp:param value="<%=i %>" name="no"/>
	<jsp:param value="판교" name="addr"/>
	
</jsp:forward>


</body>
</html>