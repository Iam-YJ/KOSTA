<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>에러입니다</h3><p>
<h3>메시지 : ${errMsg}</h3><p>

<h2>
<a href="javascript:history.back()"> 뒤로가기</a>
<a href="${pageContext.request.contextPath}/board/list"> 홈으로 가기</a>
</h2>
</body>
</html>