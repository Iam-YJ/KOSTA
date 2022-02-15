<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   		//클라이언트쪽의 Cache기능 만료
   		response.setHeader("Cache-Control", "no-store");
  	 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.invalidate();
	
	%>	
	<script type="text/javascript">
		top.location.href = "index.jsp";
	</script>
</body>
</html>