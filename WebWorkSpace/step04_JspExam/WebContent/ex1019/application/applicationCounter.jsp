<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <%
 //1. 기존에 count를 구한다 

	Object obj = application.getAttribute("count");

 //2. 1의 결과가 null이라면 count를 저장한다. 초기값 0
 	if(obj == null){
 		 application.setAttribute("count",0);
 		 obj = application.getAttribute("count");
 	}
		 
 //3. 새로운 user인지 아닌지 판단하고 새로운 user이면 1 증가하고
 //		다시 저장한다.
 Integer it = (Integer)obj;
 	if(session.isNew()){
 		it ++;
 		application.setAttribute("count", it);
 	}
 
%> --%>

	<!-- atomic..  -->
	<%
		//1. 기존에 count를 구한다 

	Object obj = application.getAttribute("count");

	//2. 1의 결과가 null이라면 count를 저장한다. 초기값 0
	if (obj == null) {
		application.setAttribute("count", new AtomicInteger());
		obj = application.getAttribute("count");
	}

	//3. 새로운 user인지 아닌지 판단하고 새로운 user이면 1 증가하고
	//		다시 저장한다.
	AtomicInteger it = (AtomicInteger) obj;
	int i = it.intValue();
	if (session.isNew()) {
		i = it.incrementAndGet();

	}
	%>

	<%-- <h3>[방문자 수 : <%=it %> 명]</h3>
 --%>
	<h3>
		[방문자 수 :
		<%=i%>
		명]
	</h3>

</body>
</html>