/**
본인이름: 박유진
날짜:20 07 23
주제: 난수발생, 제어문
*/


class Test1{

//1. 1~10 사이의 난수 발생해서 
//1이면 일요일, 2면 월요일, 3이면 화요일, 4면 수요일, 5면 목요일, 6이면 금요일,7 이면토요일 출력

 
public static void main(String [] args){

	double random = Math.random() * 10 + 1 ;
	int week = (int)random;
	int day = week % 7;

	if (week == 1)
	{
		System.out.println(week+"는 일요일입니다");
	}else if (week == 2)
	{
		System.out.println(week+"는 월요일입니다");
	}else if (week == 3)
	{
		System.out.println(week+"는 화요일입니다");
	}else if (week == 4)
	{
		System.out.println(week+"는 수요일입니다");
	}else if (week == 5)
	{
		System.out.println(week+"는 목요일입니다");
	}else if (week == 6)
	{
		System.out.println(week+"는 금요일입니다");
	}else
	{
		System.out.println(week+"는 토요일입니다");
	}

}

}