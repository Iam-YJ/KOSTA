<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  table {border: 5px groove pink; width:500px}
  td,th{border:1px black solid ;  padding:10px}

  input{border:solid 1px gray}
  
</style>
<body>
<h1>${member.id }님의 상세페이지 </h1>

<table>
 <tr>
	<td>ID</td>
	<td>${member.id }</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${member.pwd }</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td>${member.name }</td>
  </tr>
  <tr>
	<td>age</td>
	<td>${member.age }</td>
  </tr>
  <tr>
	<td>Phone</td>
	<td>${member.phone }</td>
  </tr>
  <tr>
	<td>Addr</td>
	<td>${member.addr }</td>
  </tr>
    <tr>
	<td>joinDate</td>
	<td>${member.joinDate }</td>
  </tr>
   <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<a href="selectAll">메인으로</a>
	</td>
	
  </tr>
  

</table>
</body>
</html>