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
	<h3>&lt;c:if> 와 &lt;c:choose></h3>

	<!-- 
 http://localhost:8000/step07_EL_JSTL/ex03_if_choose.jsp?age=20
만약, 나이가 있다면 "~살입니다" 출력 
 -->
	<c:if test="${not empty param.age }" var="result">
		<h3 style="color: pink">${param.age }살입니다.</h3>
	</c:if>

	결과 : ${result }
	<br>

	<hr>

	<%-- 	<c:if test="${not empty param.age }"> --%>
	<c:if test="${result}">
		<c:choose>
			<c:when test="${param.age >18 }">
				<h1 style="color: purple">성인입니다</h1>
			</c:when>
			<c:otherwise>
				<h4 style="color: purple">미성년자 입니다</h4>
			</c:otherwise>
		</c:choose>
	</c:if>

	<hr color="red">

	<form name="f" action="ex03_if_choose.jsp" method="get">
		이름 : <input type="text" name="name" value="${param.name }"/><br> 
		선택 : <select name="job">
			<option value="0">--- 선택 ---</option>
			<option value="학생">학생</option>
			<option value="개발자">개발자</option>
			<option value="백수">백수</option>
			<option value="백조">백조</option>
		</select> <input type="submit" value="전송" />
	</form>

	<!-- 
 1. 만약, name과 job이 전송된다면 "~님 직업은 ~입니다" 출력
 2. job의 종류에 따른 메세지를 출력
 	학생이라면 "공부하세요"
 	개발자라면 "최고의 개발자가 되세요"
 	백수 "놀자~"
 	백조 "놀아요~"
 	0이면 선택사항 없음 출력
 	
 3. 값이 전송되었을 때 각 폼에 선택된 내용이 그대로 보이게 
 	
 -->

<hr color="green">

	<c:if test="${not empty param.name  and param.job != null }" >
		<h1>${param.name }님 직업은 ${param.job }입니다.</h1>
		
				<c:choose>
			<c:when test="${param.job == '학생'}">
				<h1 style="color: purple">공부하세요</h1>
			</c:when>
			<c:when test="${param.job == '개발자'}">
				<h1 style="color: purple">최고의 개발자가 되세요</h1>
			</c:when>
			<c:when test="${param.job == '백수'}">
				<h1 style="color: purple">놀자~</h1>
			</c:when>
			<c:when test="${param.job == '백조'}">
				<h1 style="color: purple">놀아요~</h1>
			</c:when>
			<c:otherwise>
				<h1 style="color: purple">선택사항 없음</h1>
			</c:otherwise>
		</c:choose>
	</c:if>

<script>
document.f.job.value="${param.job}";
//$([name=job]).val('${param.job}'); //jQuery 문법

</script>


</body>
</html>
