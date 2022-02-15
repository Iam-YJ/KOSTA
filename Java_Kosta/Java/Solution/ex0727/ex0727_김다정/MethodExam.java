/*본인이름:김다정
  날짜: 20.07.27
  주제 : 메서드 호출 과제  */

  //1.두개의 정수와 연산기호(+,-,*,/,%) 전달
      // 연산기호 저 이외 값은 오류메시지 출력
  //2.전달된 연산기호에 따라 두 수 연산
  //3.연산 결과 출력 메서드 만들 것

  //4.이 메서드를 호출하는 메인메서드를 정의할 것

  //메서드를 먼저 만들고
  //호출을 한다.
class MethodExam{
	//메인메서드: 이곳에서 객체를 생성해서 method01을 호출한다.
	public static void main(String [] args){
		Calculation cal = new Calculation();
        cal.method01(15, 4, '+');
		cal.method01(15, 4, '-');
		cal.method01(15, 4, '*');
		cal.method01(15, 4, '/');
		cal.method01(15, 4, '%');
		cal.method01(15, 4, '&');
		
	}
}

//일단 연산기호 빼고 정수값 먼저 받아오기 테스트
//연산기호 값을 어떻게 가져오지? 일단 String은 객체의 주소값을 저장해서 == 비교 불가할듯

class Calculation{
	public  void method01(int a, int b, char c){
		switch(c){
           case '+' : 
             System.out.println(a+" + " + b +" = " + (a+b) ); 
		     break;
		   case '-' : 
             System.out.println(a+" - " + b +" = " + (a-b) ); 
		     break;
           case '*' : 
             System.out.println(a+" * " + b +" = " + (a*b) ); 
		     break;
           case '/' : 
             System.out.println(a+" / " + b +" = " + (a/b) ); 
		     break;
          case '%' : 
             System.out.println(a+" % " + b +" = " + (a%b) ); 
		     break;
          default : System.out.println(c+"는 잘못된 연산기호입니다..");
		}//switch문끝
		System.out.println("\n");
	}//메소드끝
}//클래스끝