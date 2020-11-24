<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

$(function(){
	$('#loadBtn').click(function(){
		$("#display").load("load"); //인수 load는 load라는 requestMapping이 있다라는 뜻
	});
	
	$('#ajaxBtn').click(function(){
		$.ajax({ //속성 : 값으로 세팅 하는 것
			url: "${pageContext.request.contextPath}/ajax" , //서버요청주소
			type: "get" , //요청방식(get / post / put / delete / patch)
			dataType: "text" , //서버가 보내온 데이터 타입 (text / html / xml / json)
			data : "name=장희정", //서버에게 보낼 parameter 정보
			success :function(result){
				$("#display").html("<h3>" + result + "</h3>")
			}, 
			error : function(err){
				console.log(err + "예외발생");
				
			}
			
		}); 
	});
	
	$('#jsonArr').click(function(){
		$.ajax({ //속성 : 값으로 세팅 하는 것
			url: "${pageContext.request.contextPath}/jsonArr" , //서버요청주소
			type: "post" , //요청방식(get / post / put / delete / patch)
			dataType: "json" , //서버가 보내온 데이터 타입 (text / html / xml / json)
			//data : "name=장희정", //서버에게 보낼 parameter 정보
			success :function(result){
				var str = ""; 
			
				
				$.each(result, function(index,item){
					str+="<input type='checkbox' value="+index+"'>'"+item
				 })
				
				$('#display').html(str);
				 

				 }, 
			error : function(err){
				console.log(err + "예외발생");
				
			}
			
		}); 
	})////////////////끝
	
	$('#jsonDto').click(function(){
		$.ajax({ //속성 : 값으로 세팅 하는 것
			url: "${pageContext.request.contextPath}/jsonDto" , //서버요청주소
			type: "post" , //요청방식(get / post / put / delete / patch)
			dataType: "json" , //서버가 보내온 데이터 타입 (text / html / xml / json)
			//data : "name=장희정", //서버에게 보낼 parameter 정보
			success :function(result){
				
				var str = "";
				
				str += result.id+" | "+result.name+" | "+result.age+" | "+result.addr;
				
				$('#display').html(str);
	//json으로 온 것은 result.id 이런식으로 빼낼 수 있음
				 }, 
			error : function(err){
				console.log(err + "예외발생");
				
			}
			
		}); 
	})//////////////////////////////
	
	
	$('#jsonList').click(function(){
		$.ajax({ //속성 : 값으로 세팅 하는 것
			url: "${pageContext.request.contextPath}/jsonList" , //서버요청주소
			type: "post" , //요청방식(get / post / put / delete / patch)
			dataType: "json" , //서버가 보내온 데이터 타입 (text / html / xml / json)
			//data : "name=장희정", //서버에게 보낼 parameter 정보
			success :function(result){
				
				var str = "<table>"
				 str += "<tr><td>ID</td><td>NAME</td><td>AGE</td><td>ADDR</td></tr>"

				$.each(result, function(index, item){
					str += "<tr>";
					str += "<td>"+item.id+"</td>"
					str += "<td>"+item.name+"</td>"
					str += "<td>"+item.age+"</td>"
					str += "<td>"+item.addr+"</td>"
					str += "</tr>"
					
				}) 
				
		/* 		for(var i=0; i<result.length; i++){
					str += "<tr>";
					str += "<td>"+result[i].id+"</td>"
					str += "<td>"+result[i].name+"</td>"
					str += "<td>"+result[i].age+"</td>"
					str += "<td>"+result[i].addr+"</td>"
					
					str+="</tr>"
				} */
				$('#display').html(str);
				str="</table>"
	//json으로 온 것은 result.id 이런식으로 빼낼 수 있음
				 }, 
			error : function(err){
				console.log(err + "예외발생");
				
			}
			
		}); 
	})//////////////////////////////
	
	
	$('#jsonMap').click(function(){
		$.ajax({ //속성 : 값으로 세팅 하는 것
			url: "${pageContext.request.contextPath}/jsonMap" , //서버요청주소
			type: "post" , //요청방식(get / post / put / delete / patch)
			dataType: "json" , //서버가 보내온 데이터 타입 (text / html / xml / json)
			//data : "name=장희정", //서버에게 보낼 parameter 정보
			success :function(result){
				alert(result.message)
				alert(result.pageNumber)
				alert(result.dto.id + " : "+result.dto.name+ " : "+result.dto.age+ " : "+result.dto.addr)
				
				$.each(result.list, function(index, item){
					alert(item + " / "+item.id + " : " + item.name + " : " + item.age + " : " + item.addr)					
				})
				
			
	
	//json으로 온 것은 result.id 이런식으로 빼낼 수 있음
				 }, 
			error : function(err){
				console.log(err + "예외발생");
				
			}
			
		}); 
	})//////////////////////////////
	
	
})///////////// ready 끝
  
</script>
</head>
<body>

<input type="button" value="load함수" id="loadBtn">
<input type="button" value="ajax함수" id="ajaxBtn">

<input type="button" value="Array결과" id="jsonArr">
<input type="button" value="DTO결과" id="jsonDto">
<input type="button" value="List결과" id="jsonList">
<input type="button" value="Map결과" id="jsonMap">

<hr>
<div id="display"></div>



</body>
</html>



