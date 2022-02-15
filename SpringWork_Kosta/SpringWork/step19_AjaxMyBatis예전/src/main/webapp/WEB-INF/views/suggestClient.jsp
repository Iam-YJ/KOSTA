<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $(function(){
	  $("#keyWord").keyup(function(){
		  if($(this).val()==""){
			 
			  return;
		  }
		  
		  $.ajax({
			  type: "post" , //전송방식
			  url:"${pageContext.request.contextPath}/suggest" ,//서버주소
			  dataType:"json" , //응답결과데이터타입(xml, html, text, json)
			  data: { keyWord: $(this).val() }, //서버에게 전송할 data 
			  success: function(result){//개수|단어,단어,..
				  $( "#keyWord" ).autocomplete({
				      source: result
				    }); 
			  } ,
			  error: function(err){
				  console.log(err+"-> 오류");
			  }
				 
		  });//ajax끝
		  
	  });//keyup끝
	  
	  
  }); //function end



</script>


</head>
<body>

<h3> [ Suggest 기능 구현 ]</h3>	
<form name="search" id="search">
	<input type="text" name="keyWord" id="keyWord"/>
</form>
<!--제시어 단어 출력부분 -->
<div id="suggest" style="display:none">
 

</div>

</body>
</html>








