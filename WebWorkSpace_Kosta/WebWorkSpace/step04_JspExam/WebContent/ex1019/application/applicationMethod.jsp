<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ServletContext - application 내장객체 관련메소드 </h3>
application.getContextPath() : <%=application.getContextPath()%><br> 
<!-- 서버에 올려질 때 자동으로 생성되는 이름 -->

application.getRealPath("/") : <%=application.getRealPath("/")%><br>
application.getMajorVersion() : <%=application.getMajorVersion()%><br>
application.getMinorVersion() : <%=application.getMinorVersion()%><br>
application.getServerInfo() : <%=application.getServerInfo()%><br>

<h3>application 영역(scope)에 정보 저장하기</h3>

<%
	application.setAttribute("addr","판교");
	application.setAttribute("message","배고파");

%>

<h3>application에 저장된 정보 조회하기</h3>
주소 : <%=application.getAttribute("addr") %><br>
메세지 : <%=application.getAttribute("message") %><br>

<a href="../../ex1016/session/sessionGet.jsp">정보 확인하러 가자 </a>

</body>
</html>