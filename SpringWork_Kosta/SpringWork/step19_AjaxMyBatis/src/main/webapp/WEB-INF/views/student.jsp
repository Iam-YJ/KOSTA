<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.a {
	border: solid red 5px
}

span {
	width: 150px;
	color: red
}

input {
	border: solid gray 1px
}

table {
	width: 100%
}

th, td {
	border: 1px gray solid;
	text-align: center;
	padding: 3px
}

h2 {
	text-align: center
}
</style>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {

		printMember();

		$('#customSel').click(function() {
			printMember();
		});

		/*아이디 중복체크*/
		$('#stNo').keyup(function() {
			if ($(this).val() == '') {
				$('#inForm span').text('학번중복결과여부');
				$('#btn').attr("disabled", false);
				return;
			} else {
				$.ajax({
					url : "check",
					type : "post",
					data : "stNo=" + $(this).val(),
					dataType : "text",
					success : function(result) {

						$('#inForm span').text(result);
					},
					error : function(err) {
						//alert("err : "+err);
						//console.log("err");
					}
				})
			}
		});

	/*가입하기*/
	/* 		$('#btn').click(function() {
			$.ajax({
				url : "insert",
				type : "post",
				data : $('#inForm').serialize(),//폼전송(name=value)
				dataType : "text",
				success : function(result) {
					if (result == 1) {
						alert("등록 성공");
					} else {
						alert("등록 실패");
					}
					$('input[type=text]').val("");
					$('#inForm span').text('학번중복결과여부');
					printMember();
				},
				error : function(err) {
					//alert("err : "+err);
				}
			})
		}) */

		//삭제하기
		$('#listTable').on('click', 'input[value=삭제]', function() {
			$.ajax({
				url : "delete",
				type : "post",
				data : "stNo=" + $(this).attr('id'),
				//data:{"stNo : $(this).attr('id')}
				dataType : "text",
				success : function(result) {
					if (result == 1) {
						alert("삭제 성공");
					} else {
						alert("삭제 실패");
					}
					printMember();
				},
				error : function(err) {
					//alert("err : "+err);
				}
			})
		});
	

	//전체레코드 가져오기
	function printMember() {
		$
				.ajax({
					url : "select",
					type : "get",
					dataType : "json",
					success : function(result) {

						$('#listTable tr:gt(0)').empty();

						var str = "";
						$
								.each(
										result,
										function(index, item) {
											str += '<tr>';
											str += "<td><a href ='#'>"
													+ item.stNo + "</td>";
											str += '<td>' + item.stName
													+ '</td>';
											str += '<td>' + item.stAge
													+ '</td>';
											str += '<td>' + item.stPhone
													+ '</td>';
											str += '<td>' + item.stAddr
													+ '</td>';
											str += '<td><input type="button" value="삭제" id='+item.stNo+'></td>';
											str += '</tr>';
										});
						$('#listTable').append(str);
					},
					error : function(err) {
						//alert("err : "+err);
					}
				}) 
	}//전체 레코드 가져오기 끝

	//등록 or 수정
	$('#btn').click(function() {
		
		var state = true; //등록 or 수정을 해야하는지 여부 체크(true:한다, false:안한다)

		$("input[type=text]").each(function(index, item) {
			if ($(this).val() == "") {
				alert("값을 입력해주세요");
				$(this).focus();
				state = false;//등록or수정 하지말자
				return false; //반복문 빠져나갈 때 전체 each를 나가는법-false를 리턴하면 each 함수를 빠져나가라
			}
		});

		var urlAddr = "${pageContext.request.contextPath}/insert";

		if (state) {

			if ($(this).val() == "수정하기") {
				urlAddr = "${pageContext.request.contextPath}/update";
				//id박스 활성화
				$("#stNo").removeAttr("readonly");

				//span보이기
				$("span").show();

				//버튼글씨 변경
				$("#btn").val("가입하기");

			}//if
		
		$.ajax({
			type : "post", //전송방식 (get, post, put, delete,)
			url : urlAddr,//서버주소
			dataType : "text",//응답데이터의 타입(text, html, xml, json)
			data : $("#inForm").serialize(),
			success : function(result) {//요청결과가 성공했을때 호출될 함수
				if (result > 0) {
					$("input[type=text]").val("");
					$("span").text("중복결과여부");
					alert("성공하였습니다.");
					printMember();
				}//if
				else {
					alert("성공하지 않았습니다");
				}//else
			}, //success
			error : function(err) {//요청결과가 실패했을때 호출될 함수
				console.log(err + "예외발생...");
			}//error

		});//ajax
		} 
	});//등록 수정 끝
	
	

	$(document).on("click", "#listTable > tbody > tr > td > a", function() {
		var idV = $(this).text();
		$("#stNo").val(idV);
		//id박스 비활성화
		$("#stNo").attr("readonly", "readonly");
		//span숨기기
		$("span").hide();
		//버튼글씨 변경
		$("#btn").val("수정하기");
		$("#stName").val($(this).parent().next().text());
		$("#stAge").val($(this).parent().next().next().text());
		$("#stPhone").val($(this).parent().next().next().next().text());
		$("#stAddr").val($(this).parent().next().next().next().next().text());

	});//on

	$(document).on("click", "#listTable>tbody>tr>td>a", function() {

		//alert($(this).text());
		var idV = $(this).text();
		$("#stNo").val(idV);
		$("#stName").val($(this).parent().next().text());
		$("#stAge").val($(this).parent().next().next().text());
		$("#stPhone").val($(this).parent().next().next().next().text());
		$("#stAddr").val($(this).parent().next().next().next().next().text());

		//id박스 비활성화 
		$("#stNo").attr("readonly", "readonly");

		//span태그 감추기
		$("span").hide();

		//버튼 글씨 "수정하기" 변경
		$("#btn").val("수정하기")

	})
	}); //스크립트 괄호 끝
</script>
</head>


<body>
	<h2>Student 입력</h2>

	<form name="insert" method="post" id="inForm">
		<table cellspacing="0">
			<tr bgcolor="pink">
				<th>학번</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<tr>
				<td style="text-align: left"><input type="text" size="8"
					name="stNo" id="stNo"> <span>학번중복결과여부</span></td>
				<td><input type="text" size="8" name="stName" id="stName"></td>
				<td><input type="text" size="4" name="stAge" id="stAge"></td>
				<td><input type="text" size="12" name="stPhone" id="stPhone"></td>
				<td><input type="text" size="30" name="stAddr" id="stAddr"></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="button"
					value="가입하기" id="btn"></td>
			</tr>
		</table>

		<br>

	</form>

	<hr color="red">

	<h2>Student 리스트 !</h2>
	<table cellspacing="0">
		<tr>
			<td style="text-align: right"><input type="button" value="가져오기"
				id="customSel"></td>
		</tr>
	</table>

	<table id="listTable" cellspacing="0">
		<tr bgcolor="pink">
			<th>학번</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>삭제</th>
		</tr>



	</table>



</body>
</html>