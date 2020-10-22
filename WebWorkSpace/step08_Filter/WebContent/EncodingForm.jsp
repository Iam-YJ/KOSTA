<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>jsp 문서 인코딩 처리 </h1>
<form name="f" action="encodingResult.jsp" method="post" >
이름 : <input type="text" name="name"/>
<input type="submit" value="전송"/>
</form>
<hr>



<h1>servlet 문서 인코딩 처리 </h1>
<form name="f" action="encResult" method="post" >
이름 : <input type="text" name="name"/>
<input type="submit" value="전송"/>
</form>

</body>
</html>