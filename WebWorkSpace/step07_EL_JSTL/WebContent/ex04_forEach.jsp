<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {width:800px; border:solid gray 1px; border-collapse:collapse;}
th,td{border:1px gray solid; padding:3px}
td{text-align:center}
tr:eq(0){background-color:skyblue}
</style>

<script src="../js/jquery-3.5.1.js"></script>

<script>
  $(function(){
	  $("tr:odd").css("background-color","orange")
	  $("tr:even").css("background-color","gray")
	  
	  $("tr:eq(0)").css("background-color","skyblue")
  })
</script>

</head>
<body>

	<h1>&lt;c:forEach> Test</h1>

	<c:forEach var="i" begin="0" end="10">
	${i},
</c:forEach>
	<hr>
	<%
		String hobbys[] = { "등산", "수영", "낚시", "축구" };
	%>

	<c:forEach items="<%=hobbys%>" var="h" varStatus="state">
${h}, ${state.index} / ${state.count}<br>
	</c:forEach>

	<hr>
	<jsp:useBean id="bean" class="ex1021.jstl.ForEachBean" />
	${bean.name}
	<br> ${bean.menus}
	<br> ${bean.memberList}
	<br> ${bean.map}
	<hr>



	<!-- 1. names는 select 박스에 출력하기 -->
	<select>
		<option value="0">-- 이름 선택 --</option>
		<c:forEach items="${bean.name}" var="name" varStatus="state">
			<option value="${state.count }">-- ${name } --</option>
		</c:forEach>
	</select>
	<br>

	<!-- 2. menus는 checkbox 출력하기 -->
	<c:forEach items="${bean.menus }" var="menu" varStatus="state">
		<label><input type="checkbox" name="menu" value="${menu }" checked>${menu }</label>
	</c:forEach>
	<br>

	<!-- 3. memberList는 테이블 출력하기 -->
	<th>
	<tr>
	<th>번호</th><th>이름</th><th>나이</th><th>나이</th><th>주소</th>
	</tr>
	<br>
	
	
	<c:forEach items="${bean.memberList }" var="mem" varStatus="state">

		<tr>
		<td>${state.count}</td>
		<td>${mem.getId()}</td> <!-- member의 getId() 호출 -->
		<td>${mem.getName()}</td>
		<td>${mem.getAge()}</td>
		<td>${mem.getAddr()}</td>
		</tr>
		<p>
	</c:forEach>
	</th>
	<br>

	<!-- 4. map은 radio 출력 -->
	<fieldset>
	<legend>나라선택</legend>
	<c:forEach items="${bean.map }" var="map" varStatus="state">
		<input type="radio" name="maoRadio" value="${map.getKey() }">${map.getValue() }
		<input type="radio" name="maoRadio" value="${map.getKey() }">${map.getKey() }
		<p>
	</c:forEach>
	</fieldset>
	
	<p>
	가격 : 2534000000 원 /
	<fmt:formatNumber value="2534000000"/>원
	


</body>
</html>