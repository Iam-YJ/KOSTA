<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
input{width:80px }
</style>
<script src="../js/jquery-3.5.1.js"></script>
<script type="text/javascript">

</script>
</head>
<body>

<!--  target속성 = "_blank | _top | _parent  | 창이름 | self" -->
<form name="f" method="post" action="loginPro.jsp">
 ID &nbsp;<input type = "text" name="id" id="id"><br>
 PWD &nbsp; <input type = "text" name="pwd" id="pwd"><br>


<button type="submit" >로그인</button>
<a href="MemberForm.html" target="center">회원가입</a> <p>

 </form>


</body>
</html>