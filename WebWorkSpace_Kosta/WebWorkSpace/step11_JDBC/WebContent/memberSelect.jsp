<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border: 5px dobule red
}

th, td {
	padding: 5px;
	border: 1px solid pink;
	text-align: center
}

a {
	text-decoration: none
}
</style>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>

<script>
	$(function() {
		//alert(1);

		//검색을 클릭했을 때 이벤트
		$("[value=검색]").click(function() {
			if ($("[name=keyField]").val() == "0") {
				alert("항목을 선택해주세요");

				return;
			}
			if ($("[name=keyWord]").val() == "") {
				alert("검색 단어를 입력해주세요");
				$("[name=keyWord]").focus();
				return;
			}

			//전송하기
			$("[name=serach]").submit();

		})

		//삭제하기
		$("[value=삭제]")
				.click(
						function() {
							//alert($(this).attr("name"));

							if (confirm("정말 삭제 할래?")) {
								location.href = "${pageContext.request.contextPath}/delete?id=" + $(this).attr("name");
								
							}

						})

	});
</script>

</head>

<body>


	<center>
		<h1>[ 회원 정보 LIST ]</h1>
		<table cellspacing="0">
			<tr>
				<th colspan="9" style="text-align: right"><a
					href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp; 
					<a href="#">[새로고침 ]</a>&nbsp;&nbsp;&nbsp;</th>
			</tr>
			<tr bgColor="pink">
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>연락처</th>
				<th>가입일</th>
				<th>삭제</th>
			</tr>

			<!-- DB에서 가져온 데이터(List<Member>)를 화면에 출력 - forEach -->


			<c:forEach items="${list}" var="list" varStatus="var">
				<tr>
					<td>${var.count}</td>
					<td><a
						href="${pageContext.request.contextPath}/read.jsp?id=${list.id}">${list.id}</a></td>
					<td>${list.pwd}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.addr}</td>
					<td>${list.phone}</td>
					<td>${list.joinDate}</td>
					<td><input type="button" name="${list.id}" value="삭제" /></td>
				</tr>
			</c:forEach>

		</table>
		<p>
		<form name="search" action="${pageContext.request.contextPath}/search"
			method="post">
			<select name="keyField">
				<option value="0">--선택--</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
				<option value="addr">주소</option>
			</select> <input type="text" name="keyWord" /> 
			<input type="button" value="검색" />

		</form>





	</center>



</body>
</html>




