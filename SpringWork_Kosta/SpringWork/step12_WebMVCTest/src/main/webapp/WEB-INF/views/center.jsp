<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("id") != null){
			%>
				<h3><%=session.getAttribute("id") %>로그인중입니다.</h3>
			<%
		}//if
		else{
			%>
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

			<%
		}//else
	%>
</body>
</html>