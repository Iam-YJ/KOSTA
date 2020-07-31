/*본인이름:김다정
  날짜: 20.07.27
  주제 : MethodinvokeExam.java 과제  */

class Methodinvoke01{
	//다음과 같이 메소드를 작성하세요.
	
	/*method 이름 : method01
	어디서나 누구나 접근가능
	정수 리턴
	인수로 정수2개 받음
	인수로 들어온 정수 2개를 곱해서 출력하고 리턴*/
	public int method01(int a, int b){
		int sum = a*b;
		System.out.println("정수 2개 곱하기 출력:"+sum);
		return sum;
	}
}

class Methodinvoke02{
	
	//method 이름 : method02
	//어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능=>static메서드 만들기
	//정수 리턴
	//인수로 정수2개 받음
	
	//인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴
		
	public static int method02(int a, int b){
		int sum = a+b;
		System.out.println("정수 2개 더해서 출력:"+sum);
		return sum;
	}
		
}

class MethodInvokeExam{
	public static void main(String []args){
		
		//MethodInvoke01의 method01 호출
		Methodinvoke01 me = new Methodinvoke01();
			int a = me.method01(10,20);
			System.out.println(a);

		//MethodInvoke02의 method02 호출
		int b = Methodinvoke02.method02(1,2);
		System.out.println(b);
		

	}
}

