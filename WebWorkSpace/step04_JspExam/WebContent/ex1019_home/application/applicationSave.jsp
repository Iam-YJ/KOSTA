<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
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


<%!	
String name;
String subject;
String content;
Date date;
String fName;
String fPath;
%>

<%
	request.setCharacterEncoding("utf-8");
	name = request.getParameter("name");
	subject = request.getParameter("subject");
	content = request.getParameter("content");
	
	date = new Date();
	long time = date.getTime();
	fName = name + time+".txt";
	
	  if(name.isEmpty()||content.isEmpty())       // ''''''''''SEC 1.     
      {
          response.sendRedirect("board_Form.html?result=fail");
      }
      else
      {
          PrintWriter pw=null;                // ''''''''''''SEC 2.
          try{
              String rltv="/";
              fPath=application.getRealPath(rltv)+fName;
              out.println(rltv+fName+"<br>"+fPath);
              pw = new PrintWriter(fPath);
              pw.println("제목 : "+fName);
              pw.println(content);
              out.println("저장되었습니다.<BR>");
              out.println(content);
          }catch(IOException e){
              out.println("저장 실패 : 파일에 데이터를 쓸 수 없습니다.");
          }finally
          {
              try{            
                  pw.close();
              }catch(Exception e)
              {
                   
              }
          }
          }
  %></p>
	
	
	
	
%>

</body>
</html>