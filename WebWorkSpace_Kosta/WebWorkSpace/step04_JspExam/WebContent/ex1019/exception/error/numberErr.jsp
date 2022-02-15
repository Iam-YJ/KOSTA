<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>숫자만 입력해주세요 </h3>
<a href="exception_web_Form.jsp">메인으로</a><p>

<a href="../ex02/exception_web_Form.jsp">상대경로 메인으로</a><p>
<!-- 내가 기준점이 어디 있던지 간에 루트에서부터 경로를 찾아가야 어려움이 없다 
	상대경로 x // 루트에서부터 따라가라  -->

<a href="<%=request.getContextPath() %>/ex1019/exception/ex02/exception_web_Form.jsp">루트 기준 메인으로</a>
<!-- 루트에서부터 따라가려면 request.getContextPath() <<contextPath>> 꼭 필요 !! -->

</body>
</html>