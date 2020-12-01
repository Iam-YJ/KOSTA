<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<h4>${exception.message}</h4> <!-- Jsp 내장객체 getMessgae로 표현 -->
<h4>${requestScope.errMsg}</h4> <!-- ModelAndView로 저장한것 표현 -->

<a href="${pageContext.request.contextPath}/">메인</a>


</body>
</html>

