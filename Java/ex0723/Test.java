/**
본인이름: 박유진
날짜:20 07 23
주제: 난수발생, 제어문
*/



class Test{


public static void main(String [] args){

//난수 1~100
double random = Math.random() * 100 + 1;
int num = (int)random;

//선언한 변수가 짝수인지 홀수인지 구분해서 짝수입니다, 홀수입니다 출력하기

int test = num % 2 ;

System.out.println(num);
if (test == 0)
{
	System.out.println("짝수입니다");
}else{

	System.out.println("홀수입니다");

}
}

}