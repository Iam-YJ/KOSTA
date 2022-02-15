<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");

	String dbid = "jang";
	String dbpwd = "1234";
	
	
	String getId = request.getParameter("userId");
	String getPwd = request.getParameter("userPwd");
	String getName = request.getParameter("userName");
	
	if(dbid.equals(getId) && dbpwd.equals(getPwd)){
		
			//새로운 request, response를 생성해서 이동하는 방식임 
			response.sendRedirect("LoginOK.jsp?getName="+URLEncoder.encode(getName,"utf-8"));
			
			//forwad 방식으로 이동 
			/* RequestDispatcher rd = request.getRequestDispatcher("LoginOK.jsp");
			rd.forward(request, response);
			//원래 내가 가진 request, response를 가지고 이동해라
			// forward 방식 특징  */
			 

	}else{
	%>
	<script>
	alert("<%=getName%>님 정보를 확인해주세요");
	location.href="LoginForm.html";
	history.back(); //뒤로가기
	</script>
	
	<%
	
	out.println("<script>");
	out.println("alert('"+getName+"님 정보를 확인해주세요')");
	
	out.println("</script>");
	
	
	
	
	//<script>는 정적코드여서 이것을 만나도 was가 무시하고 동적코드만 보냄.
	//그래서 		response.sendRedirect("LoginForm.jsp"); 방식으로는 알람창 띄우고 이동 불가
	//스크립트단(클라이언트쪽)에서 알림 띄우고 이동시켜야 함 

	
	
		

	
	}

%>


		
		
</body>
</html>