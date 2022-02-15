<%@page import="java.util.Date"%>
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
   String dbId="jang" , dbPwd="1234";
   
   request.setCharacterEncoding("UTF-8");

   String userId = request.getParameter("userId");
   String userPwd = request.getParameter("userPwd");
   String userName = request.getParameter("userName");

   if(dbId.equals(userId) && dbPwd.equals(userPwd)){
	    //인증이 성공했으니까 session영역에 사용자정보를 저장한다.
	    session.setAttribute("sessionName", userName);
	    session.setAttribute("creationTime", new Date().toLocaleString());
	    
	    //쿠키정보 저장하기 - 마지막에 로그인된 사용자 ID 저장한다.
	    Cookie cookie =  new Cookie("saveId", userId);
	    cookie.setMaxAge(60*60*24*365);//1년
	    cookie.setPath("/");
	    response.addCookie(cookie);
	    
	    //이동
	   response.sendRedirect("LoginOk.jsp");
   }else{
	   %>
	     <script type="text/javascript">
	        alert("<%=userName%>님 정보를 확인해주세요.");
	        //location.href="LoginForm.html";
	        history.back();//뒤로가기
	     </script>
	   <% 
	   
	   //out.println("<script>");
	   //out.println("alert('"+userName+"님 정보를 확인해...')");
	   //out.println("</script>");
	   
	   //response.sendRedirect("LoginForm.html");
   }

%>



</body>
</html>






