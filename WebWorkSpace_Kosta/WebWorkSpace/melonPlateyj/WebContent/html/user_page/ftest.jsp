<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보자보자 당신은 말입니다 ~</title>
</head>

<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<style>
  h1 {
    color: black;
    font-family: "Nanum Gothic", sans-serif;
    .textCenter { text-align: center; }

  }
  
  div{
   color: black;
    font-family: "Nanum Gothic", sans-serif;
     .textCenter { text-align: center; }
  }
/*   body { text-align: center; /* Quirks Mode 를 위한 가운데 정렬 */ } */

</style>
<body>

<div class="col-md-6">
					<div class="box_general padding_bottom">
						<div class="agree">
							<h1>나와 어울리는 음식은 ? </h1>
							<hr>
							<form
								action="${pageContext.request.contextPath}/dispatcher?key=user&methodName=miniTest"
								method="post">
								<!-- .agree -->
								<ul>
								<h3> 친구와의 약속이 취소됐을 때 나는</h3> 
									<li><label for="a2"><span>다른 친구에게 연락해서 나오라고 한다</span></label><input
										type="checkbox" value="z" /></li>

									<li><label for="a3"><span>혼자 집에서 뒹굴뒹굴 거린다</span><input
											type="checkbox" value="z"  /></label></li>

									<br>
									
								<!--  -->
									
									<h3>내 최애 맛집이 맛없다고 소문이 났을 때 나는</h3> 
									<li><label for="a2"><span>“음~ 냠냠쩝쩝~~” 아랑곳하지 않고 계속 먹는다</span></label><input
										type="checkbox" value="z" /></li>

									<li><label for="a3"><span>“맛이 변했나?” 괜히 맛없게 느껴진다</span><input
											type="checkbox" value="z"  /></label></li>
									<br>
										<!--  -->
										
										
									<h3> 사람이 많은 길거리에서 넘어졌을 때 나는</h3> 
									<li><label for="a2"><span>“아씨 아파라! 뭐야 이건??” 괜히 큰소리 친다</span></label><input
										type="checkbox" value="z" /></li>

									<li><label for="a3"><span>(머쓱;;) 꾹 참고 가던길 간다</span><input
											type="checkbox" value="z"  /></label></li>
									<br>
									
							
										<!--  -->
							
									<h3> 예전에 한 번 먹어본 음식에 대해서 나는</h3> 
									<li><label for="a2"><span>한 번 먹어봤지만 생생하게 기억한다</span></label><input
										type="checkbox" value="a" name="interests"  /></li>

									<li><label for="a3"><span>한 번 먹어봣는데 어떻게 기억해?</span><input
											type="checkbox" value="b" name="interests"  /></label></li>
									<br>
									
										<!--  -->
									
									<h3> 음식점을 고를 때 나는</h3> 
									<li><label for="a2"><span>“역시 이게 짱이지!” 최애 식당을 선택한다</span></label><input
										type="checkbox" value="c" name="interests"  /></li>

									<li><label for="a3"><span>“오? 새로생긴 음식점이네?” 신상을 선택한다</span><input
											type="checkbox" value="d" name="interests"  /></label></li>
									<br>
						
										<input type="submit" value="Submit"> &nbsp <input
											type="reset" value="Reset">

								</ul>
							</form>
						</div>


					</div>
				</div>

</body>
</html>