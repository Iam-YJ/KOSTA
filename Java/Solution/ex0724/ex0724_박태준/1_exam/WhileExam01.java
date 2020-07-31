/**
	본인이름 : 박태준
	날짜 : 2020-07-24
	주제 : while 연습 1

	1. WileExam01.java를 만든다.
	1) 1 ~ 100까지 한줄 출력
	2) A ~ Z까지 한줄 출력
	3) 1~ 100까지 10행 10열 출력(while안에 if문이용)
*/

class WhileExam01
{
	public static void main(String [] args)
	{
		// 1) 1 ~ 100까지 한줄 출력
		System.out.println("Problem01 : 1 ~ 100까지 한줄 출력 ");
		int i = 1; //초기화
		while (i <= 100) // 조건식
		{
			System.out.print(i + "\t"); //실행문장
			i += 1; // 증감식
		}
		System.out.println("\n-------------------------------------------");


		// 2) A ~ Z까지 한줄 출력
		System.out.println("Problem02 : A ~ Z까지 한줄 출력 ");
		char ch = 'A'; // 초기화
		while (ch <= 'Z') // 조건식
		{
			System.out.print(ch + "\t"); // 실행문장
			ch += 1; // 증감식
		}
		System.out.println("\n-------------------------------------------");


		// 3) 1~ 100까지 10행 10열 출력(while안에 if문이용)
		System.out.println("Problem03 : 1~ 100까지 10행 10열 출력(while안에 if문이용) ");
		i = 1; // 초기화
		while (i <= 100) // 조건식
		{
			// 실행문장
			System.out.print(i + "\t"); 
			if (i%10 == 0) System.out.println(); // 실행문장이 1열이므로 {} 생략
			i += 1; // 증감식
		}
		System.out.println("-------------------------------------------");

	}
}
