/**
	본인이름 : 박태준
	날짜 : 2020-07-24
	주제 : while 연습 2

	2.WhileExam02.java를 만든다.
	1) 1~ 100까지 를 10행 10열 출력
      조건(while문 안에 while문 )
	2) 구구단을 출력
	3) 2)의 구구단의 결과에서 5단 빼고 찍기 
*/

class WhileExam02
{
	public static void main(String [] args)
	{
		// 1) 1~ 100까지 를 10행 10열 출력, cf) 조건(while문 안에 while문 )
		System.out.println("Problem01 : 1~ 100까지 를 10행 10열 출력, cf) 조건(while문 안에 while문) ");
		System.out.println("---------------------------------------");
		int i = 1; //초기화
		int sum = 0; 
		while (i <= 10) // 조건식
		{
			int j = 1; //초기화
			while (j <= 10) // 조건식
			{
				System.out.print(++sum + "\t");	//실행문
				j += 1; // 증감식
			}
		
			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		System.out.println("---------------------------------------");


		// 2) 구구단을 출력
		System.out.println("\nProblem02 : 구구단을 출력");
		System.out.println("--------------------------------------------------------------");
		i = 1; //초기화 
		while (i <= 9) // 조건식
		{
			int j = 2; //초기화
			while (j <= 9) // 조건식
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//실행문
				j += 1; // 증감식
			}
		
			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		System.out.println("--------------------------------------------------------------");


		// 3) 2)의 구구단의 결과에서 5단 빼고 찍기 

		System.out.println("\nProblem03 : 2)의 구구단의 결과에서 5단 빼고 찍기");
		System.out.println("------------------------------------------------------");
		i = 1; //초기화 
		while (i <= 9) // 조건식
		{
			int j = 1; //초기화
			while (j < 9) // 조건식
			{
				j += 1; // 증감식
				if (j == 5) continue; //continue를 이용하여 5단 건너뛰기
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//실행문
			}
		
			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		System.out.println("------------------------------------------------------");




	}
}
