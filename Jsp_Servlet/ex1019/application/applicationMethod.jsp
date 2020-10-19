<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ServerContext - application내장객체 관련메소드 </h3>
application.getContextPath() : <%=application.getContextPath()%> <br>
application.getRealPath("/") : <%=application.getRealPath("/")%> <br>
application.getMajorVersion() : <%=application.getMajorVersion()%> <br>
application.getMinorVersion() : <%=application.getMinorVersion()%> <br>
application.getServerInfo() : <%=application.getServerInfo()%> <br>

<h3>application 영역(scope)에 정보 저장하기 </h3>
<%
  application.setAttribute("addr", "판교");
  application.setAttribute("message", "배고프다~~");
%>

<h3>application 에 저장된 정보 조회하기 </h3>
주소 : <%=application.getAttribute("addr") %><br>
메시지 : <%=application.getAttribute("message") %><br>

<a href="../../ex1016/session/sessionGet.jsp">정보 확인하러 가자</a>


</body>
</html>










