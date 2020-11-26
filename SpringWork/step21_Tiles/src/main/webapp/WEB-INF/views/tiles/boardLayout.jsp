<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
	width: 800px; height:1000; border:red solid 5px;
}
th{border-collapse:collapse; border:gray 1px solid; background-color:skyblue;}
.a{width:100px}

</style>

</head>


<body>

	<table>
		<tr>
			<th colspan="2">
			<tiles:insertAttribute name="header"/>
			</th>
		</tr>
		<tr>
			<th><tiles:insertAttribute name="content"/></th>
			<th class="a"><tiles:insertAttribute name="aside"/></th>
		</tr>
		<tr>
			<th colspan="2"><tiles:insertAttribute name="footer"/></th>
		</tr>
		
		
	</table>

</body>
</html>