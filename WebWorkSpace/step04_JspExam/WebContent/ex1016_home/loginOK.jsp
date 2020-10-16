<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//클라이언트쪽의 cache 기능 만료시켜야 한다
    	response.setHeader("Cache-Control", "no-store");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.5.1.js"></script>
<script>
//alert(1);
$(function(){
	$("button").click(function(){
		if(confirm("정말 로그아웃 할래?")){
			//이동하기
			location.href = "logout.jsp";
		}	
	});
});
</script>

</head>

<body>
<h3>

<% 
if (session.getAttribute("sessionId") == null) {
    %>
    <script>
    alert("인증하고 오세요");
   location.href = "left.jsp";
    </script>
    
    <% 
    
}else{
	%>
	<h3><%=session.getAttribute("sessionId")%>님 로그인중 <br>
	
	
	<button type="button">로그아웃</button>
	</h3>
	<%
}

%>


	</h3>
</body>
</html>