/**
본인이름: 박유진
날짜:20 07 23
주제: 난수발생, 제어문
*/





class Test2{


public static void main(String [] args){


double mon = Math.random() * 12 +1 ;
int month = (int)mon;


if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
	{
		System.out.println(month+"는 31일까지 입니다");
	}else if (month == 4 | month == 6 | month == 9 | month == 11 )
	{
		System.out.println(month+"는 30일까지 입니다");
	}else if (month == 2)
	{
		System.out.println(month+"는 28일까지 입니다");
	}



}



}