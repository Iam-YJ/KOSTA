<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 저장된 Cookie 정보 확인</h3>

<h4>
<%
   Cookie [] cookies = request.getCookies();
   
    
    if(cookies==null){
    	out.println("쿠키 정보가 없습니다.");
    }else{
    	 out.println("cookies.length = " + cookies.length+"<p>");
    	for(Cookie co : cookies){
    		String name = co.getName();
    		String value = co.getValue();
    		out.println(name+" = " + value+"<br>");
    	}
    }
%>
</h4>

</body>
</html>






