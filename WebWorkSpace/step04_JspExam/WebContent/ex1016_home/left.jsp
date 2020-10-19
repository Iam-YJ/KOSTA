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
<script>
//alert(1);
$(function(){
	$("#logout").click(function(){
		if(confirm("정말 로그아웃 할래?")){
			//이동하기
			location.href = "logout.jsp";
		}	
	}); 
	
	$("#join").click(function(){
		top.center.location.href="MemberForm.html";
	}); //버튼으로 할 경우에는 함수 이용해서 
	
});
</script>
</head>
<body>
<%
if(session.getAttribute("id")==null){
%>


<!--  target속성 = "_blank | _top | _parent  | 창이름 | self" -->
<form name="f" method="post" action="loginPro.jsp">
 ID &nbsp;<input type = "text" name="id" id="id"><br>
 PWD &nbsp; <input type = "text" name="pwd" id="pwd"><br>


<button type="submit">로그인</button>
 </form>
 <a href="userinput.jsp" target="center" id="join">회원가입</a> <p><!-- a tag 이용할 경우에는 바로 이동  -->
 <%
}else{ //로그인 된 상태임 
	%>
	<h3><%=session.getAttribute("sessionId")%>님 로그인중</h3> <br>
	<button type="button" id="logout">로그아웃</button>

	<%
 }
 %>


</body>
</html>