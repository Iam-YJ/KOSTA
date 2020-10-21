<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>
<%

Date date = new Date();
Cookie lastDate= null;
Cookie currentDate = null;
boolean exsist = false; //쿠키 존재 여부 
long oldTime=System.currentTimeMillis();
String newValue =  "" + System.currentTimeMillis();  //현재 시간을 의미

Cookie [] cookies = request.getCookies();


if(cookies != null){
    for(Cookie co: cookies){
    	out.println(co.getName());
        if( co.getName().equals("lastDate") ){
        	lastDate = co;
            exsist = true;
            break;
        }
       
    }
   
} //하기 위한 준비 작업 
%>
<%
	if(!exsist){//쿠키가 없다면 
		  lastDate = new Cookie("lastDate", newValue); //새로운 쿠키 생성 후 
	       lastDate.setMaxAge(60*60*24);//최대 유효기간을 7일로 지정
	       lastDate.setPath("/");
	       
	     	response.addCookie(lastDate); 

	
		%>
		<h3>당신은 처음 방문하셨습니다.</h3><p><p>
		<h3>현재 접속 시간 : <%=date %></h3><p>
		<h3>다시 저장된 시간 : <%=lastDate.getValue() %></h3><p>
		<%

	}else{
		lastDate = new Cookie("MyCookie1", newValue); //새로운 쿠키 생성 후 
	       lastDate.setMaxAge(60*60*24);    //최대 유효기간을 7일로 지정
	       lastDate.setPath("/");
	       response.addCookie(lastDate);      //서버에 추가 요청한다(저장은 클라이언트에 )

		
		%>
		<h3>당신의 마지막 접속일은 <%=date.toLocaleString() %> </h3><p><p>
		<h3>현재 접속 시간 : <%=date %></h3><p>
		<h3>다시 저장된 시간 : <%=lastDate.getValue() %></h3><p>
		<%

		

		}

%>
</h4>
</body>
</html>