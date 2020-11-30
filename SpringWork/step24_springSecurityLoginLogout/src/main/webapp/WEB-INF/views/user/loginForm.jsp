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
<h1>user의 loginForm.jsp 입니당</h1><p>
<h3>
<c:if test="${param.error != null}">
	Login Fail..<br>
	<c:if test= "${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
	MESSAGE : ${SPRING_SECURITY_LAST_EXCEPTION.message}
	</c:if>
</c:if>
</h3>

<h1>로그인 하기</h1>
<form action="${pageContext.request.contextPath}/loginCheck" method="post">
아이디 : <input type="text" name="id"/><br>
비밀번호 : <input type="password" name="pwd"/><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> <!-- hidden으로 토큰을 넘겨야 한다 -->
<input type="submit" value="로그인"/><br>
<input type="reset" value="취소"/><br>


</form>

</body>
</html>