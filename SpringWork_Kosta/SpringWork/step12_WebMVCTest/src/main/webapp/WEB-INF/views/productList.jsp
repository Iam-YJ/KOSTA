<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 500px;
	border: 5px green solid;
}

td, th {
	text-align: center;
	border: 1px gray solid;
}

a {
	text-decoration: none;
}
</style>
hello
${pageContext.request.contextPath}
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>


<script>
	$(function() {
		$("a[href='#']")
				.click(
						function() {
							if (confirm("삭제할꺼에요?")) {
								var code = $(this).attr("name");
								location.href = "${pageContext.request.contextPath}/del/"
										+ code;
							}
						});

	})
</script>


</head>
<body>
	<table>
		<caption>
			<h1>[ Product List Page ]</h1>

		</caption>
		<tr>
			<th>번호</th>
			<th>상품코드</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>상품설명</th>
			<th>삭제하기</th>
		</tr>


		<c:forEach items="${list}" var="product" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td><a href="${pageContext.request.contextPath}/detail.kosta?code=${product.code}">${product.code}</a></td>
				<td>${product.name}</td>
				<td><fmt:formatNumber value="${product.price}" /> 원</td>
				<td>${product.detail}</td>
				<td><a href="#" name="${product.code}"> 삭제하기</a></td>
			</tr>

		</c:forEach>

		<tr>
			<th colspan="6"><a href="insertForm.kosta">상품등록하기</a></th>
		</tr>

	</table>


</body>




</html>