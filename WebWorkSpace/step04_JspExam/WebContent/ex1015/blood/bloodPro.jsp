<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bloodPro.jsp 입니다</h1>



<% 
//폼으로 전송되는 전송방식이 
//post 방식인 경우에는 인코딩 설정 필요함
// get 방식은 상관없다 .

//post 방식인 경우에는 인코딩 설정 필요하당 (한글이 깨져서 나옴 )
 

//한글로 인코딩 하기 
	request.setCharacterEncoding("utf-8");

	// 전송된 데이터 받기 
	String blood = request.getParameter("blood");
	String name = request.getParameter("name");
%>
		
<jsp:forward page='<%=blood+".jsp" %>'>
	<jsp:param value="<%=name %>" name="name"/>
	<jsp:param value="<%=blood %>" name="blood"/>
	
</jsp:forward>



</body>
</html>