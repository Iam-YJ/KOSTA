<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script> <!-- static은 따로 안써도 된다 -->


<script>
$(function(){
	$("#ajax").click(function(){
		  $.ajax({
			  type: "post" , //전송방식
			  url:"${pageContext.request.contextPath}/test2" ,//서버주소
			  dataType:"text" , //응답결과데이터타입(xml, html, text, json)
			  data: { keyWord: $(this).val() }, //서버에게 전송할 data 
			  success: function(result){//개수|단어,단어,..
				  alert(result)
			  } ,
			  error: function(err){
				  console.log(err+"-> 오류");
			  }
				 
		  });//ajax끝
	})//ajax.click 끝
})

</script>
</head>
<body>

<h1>Spring Boot 시작하기</h1>
<a href="${pageContext.request.contextPath}/test">이동하장</a><p>


<a href="#" id="ajax">Ajax Test</a>

</body>
</html>