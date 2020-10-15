<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- 한글 처리 때문에 들어가있음  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
h1{background-color:pink}
</style>
<script>
//alert("시작");
</script>


</head>
<body>
<h1> Jsp 시작하기 </h1>


<%
//자바코드 영역 즉 자바문법을 100% 사용한다  
String name = "희정"; //지역변수(사용전에 반드시 초기화 필요함 )
int age = 12; //지역변수

System.out.println("난 어디에 출력되니?"); //콘솔에 출력되는 것 

%>

<h3>

이름 : <%= name %> <br>
나이 : <%= age %>살 입니다.<p>

메소드 호출 : <%=this.test("배고프다") %><br>

<%
	if(age>18){
		out.println(age+"살은 성인입니다. "); //브라우저에 출력하는 메소드 
	}else{
		out.println(age+"살은 미성년자입니다. ");  //브라우저 출력하는 메소드 
	}
%>

<%! 
 //메소드 선언 또는 전역변수 선언하는 영역
 public String test(String message){
	System.out.println("test() 메소드 호출되었습니다."); //콘솔 출력
	return "메세지는 " + message ; 

	
}
 
%>


</h3>


</body>
</html>