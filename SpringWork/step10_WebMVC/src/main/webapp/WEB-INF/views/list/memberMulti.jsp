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

	<h1>등록 정보 확인</h1>

	<table>
		<tr>
			<th>순서</th>
			<th>state</th>
			<th>name</th>
			<th>age</th>
			<th>addr</th>
		</tr>

		<c:forEach items="${memberList.list}" var="member" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${member.state}</td>
				<td>${member.name}</td>
				<td>${member.age}</td>
				<td>${member.addr}</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>