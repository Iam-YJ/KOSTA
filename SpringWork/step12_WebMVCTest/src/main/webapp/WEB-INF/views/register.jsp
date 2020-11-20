<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 500px;
		height: 300px;
		border: 1px red solid;
		border-collapse: collapse;
	}
	table tr td:first-child{
		width: 110px;
	}
	td{
		border: 1px gray solid;
	}
	#n{
		text-align: center;
		background-color: pink;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	function can() {
		//document.write("<a href='center.jsp' target='target'></a>");
		location.href = "center.jsp";
	}//cancle
</script>
</head>
<body>
	<div style="background-color: #50bcdf; color: white;">사용자 정보입력</div>
	<h5 style="margin-block-start: 0;">
		안녕하세요. 지훈이의 홈페이지를 자유롭게 이용하려면 회원가입을 하셔야 합니다.<br>
		아래의 사항들을 빠짐없이 기록해 주세요.
	</h5>
	
	<table>
		<tr>
			<td id="n">사용자ID</td>
			<td colspan="3">
				<input type="text" name="id" style="width:90px;"/>
				<input type="button" value="ID중복확인"/>
			</td>
		</tr>
		<tr>
			<td id="n">비밀번호</td>
			<td><input type="text" name="pwd" style="width:70px;"/></td>
			<td id="n">비밀번호 확인</td>
			<td><input type="text" name="pwdCheck" style="width:70px;"/></td>
		</tr>
		<tr>
			<td id="n">사용자 이름</td>
			<td colspan="3"><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td id="n">주민등록번호</td>
			<td colspan="3">
				<input type="text" name="firstNum" style="width: 60px;"/>
				 - 
				<input type="text" name="secondNum" style="width: 60px;"/>
			</td>
		</tr>
		<tr>
			<td id="n">생년월일</td>
			<td colspan="3">
			<form name="f">
				<input type="text" name="birth"/>년
				
				<script type="text/javascript">
					var mon = "";
					
					var mon01 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"]; 
					var mon02 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"];
					var mon03 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					var mon04 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"];
					var mon05 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					var mon06 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"];
					var mon07 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					var mon08 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					var mon09 =  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"];
					var mon10 = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					var mon11 = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"];
					var mon12 = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"];
					
					/* for(var i = 1; i <= 12; i++){
						if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
							var moni = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"]; 
						}//if
						else if(i == 4 || i == 6 || i == 9 || i == 11){
							var moni = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"]; 
						}//else if
						else{
							var moni = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"]; 
						}//else
					}//for */
					
					
					
					function changeDay(th, fr) {
						var subM = eval(th.value);
						
						//기존 서브메뉴 제거
						while(fr.day.length > 1){
							fr.day.options[1] = null;
						}//for
						
						//서브메뉴 추가
						for(var i = 0; i < subM.length; i++){
							fr.day.options[fr.day.length] = new Option(subM[i], subM[i]);
						}//for
						
					}//changeDay
					
					document.write("<select name='month' onchange='changeDay(this, form)'>");
					for(var i = 1; i <= 12; i++){
						if(i < 10){
							mon = "0" + i;
						}//if
						else{
							mon = i;
						}//else
						document.write("<option value='mon" + mon + "'> " + mon+ " </option>");
					}//for
					document.write("</select>월");
					
					document.write("<select name='day'>");
					for(var i = 0; i < mon01.length; i++){
						document.write("<option value='0'> " + mon01[i] + "</option>");
					}//for
					document.write("</select>일");
				</script>
			</form>
			</td>
		</tr>
		<tr>
			<td id="n">우편번호</td>
			<td colspan="3">
				<input type="text" name="firstPostNum" style="width: 120px;"/>
				-
				<input type="text" name="secondPostNum" style="width: 120px;"/>
				<input type="button" value="우편번호검색" onclick=""/>
			</td>
		</tr>
		<tr>
			<td id="n">주소</td>
			<td colspan="3"><input type="text" name="address" style="width: 90%;"/></td>
		</tr>
		<tr>
			<td id="n">나머지주소</td>
			<td colspan="3"><input type="text" name="resAddress"/></td>
		</tr>
		<tr>
			<td id="n">E-Mail</td>
			<td colspan="3">
				<input type="text" name="email" style="width: 120px;"/>
				@
				<select name="site">
					<option value="0">선택하세요</option>
					<option value="naver">naver.com</option>
					<option value="daum">daum.net</option>
					<option value="google">google.com</option>
					<option value="nate">nate.com</option>
					<option value="yahoo">yahoo.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td id="n">직업</td>
			<td colspan="3">
				<select name="job">
					<option value="컴퓨터/정보통신">컴퓨터/정보통신</option>
					<option value="문화/예술">문화/예술</option>
					<option value="회사원">회사원</option>
					<option value="학교/학원">학교/학원</option>
					<option value="대학생">대학생</option>
					<option value="초.중.고등학생">초.중.고등학생</option>
					<option value="주부">주부</option>
					<option value="기타">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<input type="button" value="등록" onclick=""/>
				<input type="button" value="취소" onclick="can()"/>
			</td>
		</tr>
	</table>
</body>
</html>