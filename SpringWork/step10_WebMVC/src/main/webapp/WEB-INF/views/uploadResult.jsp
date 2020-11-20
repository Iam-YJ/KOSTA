<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> upload download 실습입니당</h1>

name : ${name} <p>
fileName : ${fileName} <p>
path : ${path} <p>
fileSize : ${fileSize} <p>



<h1> 업로드 결과 - UploadDTO 이용</h1>

name : ${uploadDTO.name} <p>
fileName : ${uploadDTO.file.originalFilename} <p>
fileSize : ${uploadDTO.file.size} <p>


</body>
</html>