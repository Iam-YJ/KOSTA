<%@page import="ex1021.el.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>EL - 표현언어</h3>

<h3> 
 \${5 } = ${5 } <br>
 \${5*2 } = ${5*2} <br>
 \${5/2 } = ${5/2 } <br>
 \${5>2 } = ${5>2  } <br>
 \${5 lt 2 } = ${5 lt 2  } <br>
 \${"안녕" } = ${"안녕" } <br>
 
 \${ 5 gt 3 && 10 eq 10} = ${ 5 gt 3 && 10 eq 10 } <br>
 \${ 5 >3 ? "맞다" : "틀리다"} = ${ 5 >3 ? "맞다" : "틀리다"} <br><hr>
 
 <!-- 
 만약, http://localhost:8000/step07_EL_JSTL/ex01_ELTest.jsp 
 여기에 나이가 하나 들어올 수 있도록 해볼것이다 
 http://localhost:8000/step07_EL_JSTL/ex01_ELTest.jsp?age=20
 
 된다면 나이에 따라 성인, 미성년자 출력한다 
 -->
 <%=request.getParameter("age") %> /  ${param.age }<br>
 ${param.age > 18 ? "성인" : "미성년자"}<br>
 
 <!-- 
 만약 id가 있으면 id를 출력하고 없으면 Guest라고 출력한다 
  -->
  ${param.id }<br>
  ${param.id != null ? param.id : "Guest" }<br>
  ${empty param.id ? "Guest" : param.id }<br>
  ${not empty param.id ? param.id : "Guest" }<br><hr>

 <!-- 표현언어 안에서 문자열 연결  -->
 ${param.id != null ? param.id+="님" : "Guest"}<br>
 ${param.id != null ? param.id.concat("님") : "Guest"}<br><hr>
</h3>

<%
//scope 영역에 데이터 저장
request.setAttribute("id","jang");
session.setAttribute("addr","서울");
session.setAttribute("message","점심메뉴는?");

application.setAttribute("message","즐거운 수요일");
application.setAttribute("hobbys",new String[]{"A","B","C"});
%>

<!-- 
	표현언어넹서 SCOPE 영역에 있는 데이터는 출력할 수 있다
	pageScope < requestScope < sessionScope < applicationScope
 -->

id = <%=request.getAttribute("id") %> / ${requestScope.id } / ${id } <br>
addr = <%=session.getAttribute("addr") %> / ${sessionScope.addr } / ${addr } <br>
message = <%=session.getAttribute("message") %> / ${sessionScope.message } / ${message } <br>

message = <%=application.getAttribute("message") %> / ${applicationScope.message } / ${message } <br>
hobbys = <%=application.getAttribute("hobbys") %> / ${applicationScope.hobbys } / ${hobbys } <br>

<hr>

<!-- 자바의 객체의 getXxx() 메소드를 호출 -->
<%-- <%
	Product p = new Product();
	out.println("이름 : "+p.getName()+"<br>");
%> --%>

<!-- 객체생성 액션태그  id가 p가 된 것이다 -->
<jsp:useBean id="p" class="ex1021.el.Product"></jsp:useBean>
코드 : <%=p.getCode() %> / ${p.code}<br> <!-- p.getCode()를 호출하는 문법이다 -->
이름 : <%=p.getName() %> / ${p.name }<br> <!--  ${bean.num1}  => bean객체의 getNum1()호출됨. -->
가격 : ${p.price }<br>
수량 : ${p.qty }<br>
총금액 : ${p.price * p.qty }<br>
</body>
</html>