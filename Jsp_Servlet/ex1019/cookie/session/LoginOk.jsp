<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
     //클라이언트쪽의 Cache기능 만료.
     response.setHeader("Cache-Control", "no-store");
  %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
 $(function(){
	$("[type=button]").click(function(){
		if(confirm("정말 로그아웃할래??")){
			//이동하기
			location.href="logout.jsp";
		}
		
	});
 })
</script>
</head>
<body>
<%
  if(session.getAttribute("sessionName")==null){//인증여부 판단...
	  %>
	    <script type="text/javascript">
	      alert("인증하고 오세요.");
	      location.href="LoginForm.html";
	    </script>
	  <% 
  }else{
	  %>
	  <h3><%=session.getAttribute("sessionName") %>님 로그인 중...<br>
	   [접속시간 : <%=session.getAttribute("creationTime") %>] <br>
	   <img src="images/common.jpg"> <p>
	   
	   <button type="button">로그아웃</button>
	   
	  </h3>
	  <% 
  }

%>




</body>
</html>