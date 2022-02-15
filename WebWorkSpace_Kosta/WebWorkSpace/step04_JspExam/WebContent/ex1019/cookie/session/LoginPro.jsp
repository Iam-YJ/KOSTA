<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../../../js/jquery-3.5.1.js"></script>
<body>

<%

	request.setCharacterEncoding("utf-8");	

	String dbid = "jang";
	String dbpwd = "1111";
	
	String id = request.getParameter("userId");
	String pwd = request.getParameter("userPwd");
	String name = request.getParameter("userName");

	if(dbid.equals(id) && dbpwd.equals(pwd)){
		session.setAttribute("sessionName", name);
		session.setAttribute("sessionTime",new Date().toLocaleString());
		
		//쿠키정보 저장하기 - 마지막에 로그인된 사용자 ID 저장한다
		 Cookie co1 = new Cookie("id",id);
		 
		 co1.setMaxAge(60*60*24);
		 
		 response.addCookie(co1);
		 
		 
		
		
		//이동해줘야함
		response.sendRedirect("LoginOK.jsp");
		//request 사라지고 session은 유지되며 
		
		
	}else{
		%>
		<script>
		alert("<%=name%>님 정보를 확인해주세요");
		location.href="LoginForm.html";
		history.back(); //뒤로가기
		</script>
		
		<%
		
		out.println("<script>");
		out.println("alert('"+name+"님 정보를 확인해주세요')");
		
		out.println("</script>");
		
		
		
		
		//<script>는 정적코드여서 이것을 만나도 was가 무시하고 동적코드만 보냄.
		//그래서 		response.sendRedirect("LoginForm.jsp"); 방식으로는 알람창 띄우고 이동 불가
		//스크립트단(클라이언트쪽)에서 알림 띄우고 이동시켜야 함 

		
		
			

		
		}

	%>


</body>
</html>