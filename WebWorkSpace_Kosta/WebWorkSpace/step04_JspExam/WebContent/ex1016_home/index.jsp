<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="../js/jquery-3.5.1.js"></script>
<style>
  table{width: 800px; height:600px ;border: 1px red solid;
      border-collapse:collapse; 
      }
  th,td{border: 1px gray solid;}
  table tr:first-child {
	  height:100px; 
   }
   
   table tr:last-child {
	  height:50px; 
   }
   
   table tr td:first-child {
	 width: 200px;
}
</style>

<script type="text/javascript">

</script>

</head>
<body>

<table>
 <tr>
 <td colspan="2">
 <%@ include file="top.jsp" %><br> <!-- top.jsp의 코드가 실행시에 이 안으로 들어옴. 파일이(서블릿문서) 1개로  -->

 </td>
 </tr>
 <tr>
  <td><iframe src="left.jsp" name="left" width="100%" height="100%" frameborder="0"></iframe></td>
  <td><iframe src="center.jsp" name="center" width="100%" height="100%" frameborder="0"></iframe></td>
 </tr>
 <tr>
  
   <td colspan="2">Programmer 박유진<br>
   <%@ include file="footer.jsp" %></td>
  
   <br>
 </tr>

</table>



</body>
</html>