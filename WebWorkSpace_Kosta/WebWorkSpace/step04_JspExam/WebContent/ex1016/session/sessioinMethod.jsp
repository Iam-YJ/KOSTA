<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HttpSession - session 메소드</h1>

<h3>
<%

// 세션 유효시간 30초 설정 
 session.setMaxInactiveInterval(30); //30초
%>

session.getId() = <%=session.getId() %><br>
session.isNew() = <%=session.isNew() %><br>
session.getMaxInactiveInterval() = <%=session.getMaxInactiveInterval() %><br>
session.getCreationTime() = <%=session.getCreationTime() %><br>
session.getLastAccessedTime() = <%=session.getLastAccessedTime() %><br>

<hr>

<h3>세션의 정보를 저장하기 </h3>
<% 
session.setAttribute("id", "jang");
session.setAttribute("hobbys", new String[]{"등산","취미","낚시"});
session.setAttribute("message","session 재밌당");
%>

<h3>저장된 정보 확인하기</h3>
아이디 : <%=session.getAttribute("id") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>
메세지 : <%=session.getAttribute("message") %><br>

<a href="sessionGet.jsp">session 정보 확인하러 가자 </a>

</h3>

</body>
</html>