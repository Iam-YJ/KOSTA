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
	$("button").click(function(){
		if(confirm("정말 로그아웃 할래?")){
			//이동하기
			location.href = "logout.jsp";
			top.center.location.reload();
		}	
	}); 
	
	/* $("#join").click(function(){
		top.center.location.href="MemberForm.html";
	}); //버튼으로 할 경우에는 함수 이용해서  */
	
});
</script>
</head>
<body>
<%
   request.setCharacterEncoding("UTF-8");
   
   String dbId = "1111";
   String dbPwd = "1111";
   
   String id = request.getParameter("id");
   String pwd = request.getParameter("pwd");

   if(session.getAttribute("id") == null){
%>
   <form method="post" action="loginPro.jsp">
      아이디 : <input type="text" name="id"/><br>
      비밀번호 : <input type="text" name="pwd"/><br><br>
      <input type="submit" value="로그인"/><br>
      <a href="register.jsp" target="center">[ 회원가입 ]</a>
   </form>
<%
   }//if
   else{//로그인 상태
      %>
         <h3><%=session.getAttribute("id") %>님 로그인중</h3>
         <button type="button">로그아웃</button>
      <% 
   }//else
%>

</body>
</html>