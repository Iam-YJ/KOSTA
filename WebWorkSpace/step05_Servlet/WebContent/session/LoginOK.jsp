<%@page import="java.util.List"%>
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
<script src="<%=application.getContextPath() %>/js/jquery-3.5.1.js"></script>

<script>
$(function(){
	$("[type=button]").click(function(){
		if(confirm("정말 로그아웃 할래?")){
			//이동하기
			location.href = "../logout";
			<%-- location.href = "<%=request.getContextPath()%>/logout"; --%>
			
		}
	});
})

</script>

</head>

<body>
<h3>

<% 
if (session.getAttribute("id") == null) {
    //response.sendRedirect("LoginForm.jsp");
    %>
    <script>
    alert("인증하고 오세요");
   location.href = "LoginForm.html";
    </script>
    
    <% 
    
}else{
	%>
	<h3><%=session.getAttribute("id")%>님 로그인중 <br>
	<img src="<%=request.getContextPath()%>img/common.jpg"><p>
	
	<fieldset>
	<legend>취미선택</legend>
	<%
	List<String> hobbys = (List<String>)request.getAttribute("hobbys");
	for(String h : hobbys){
		%>
		<input type="checkbox" name="hobby" value="<%=h%>"><%=h%> 
		<%
		
	}
	%>
	
	</fieldset>
	
	
	<button type="button">로그아웃</button>
	</h3>
	<%
}

%>


	</h3>
</body>
</html>