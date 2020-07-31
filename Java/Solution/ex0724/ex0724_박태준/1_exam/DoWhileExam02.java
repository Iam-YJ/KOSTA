/**
	본인이름 : 박태준
	날짜 : 2020-07-24
	주제 : Dowhile 연습 2

	4. DoWhileExam02.java만든다.
	1) 1~ 100까지 를 10행 10열 출력 조건(do_while문 안에 do_while문 )
	2) 구구단을 출력
	3) 2)의 구구단의 결과에서 5단 까지 찍기
*/

class DoWhileExam02
{
	public static void main(String [] args)
	{
		// 1) 1~ 100까지 를 10행 10열 출력 조건(do_while문 안에 do_while문 )
		System.out.println("1~ 100까지 를 10행 10열 출력 조건(do_while문 안에 do_while문)");
		System.out.println("---------------------------------------");
		int i = 1; //초기화
		int sum = 0; 
		
		do
		{
			int j = 1; //초기화
			do
			{
				System.out.print(++sum + "\t");	//실행문
				j += 1; // 증감식
			}
			while (j <= 10);
			
			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		while (i <= 10);



		System.out.println("---------------------------------------");


		// 2) 구구단을 출력
		System.out.println("\nProblem02 : 구구단을 출력");
		System.out.println("--------------------------------------------------------------");
		i = 1; //초기화 
		
		do
		{
			int j = 2;
			do
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//실행문
				j += 1; // 증감식
			}
			while (j <= 9);

			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		while (i <= 9);


		System.out.println("--------------------------------------------------------------");


		// 3) 2)의 구구단의 결과에서 5단 까지 찍기

		System.out.println("\nProblem03 : 2)의 구구단의 결과에서 5단 까지 찍기");
		System.out.println("------------------------------");
		
		i = 1; //초기화 
		do
		{
			int j = 2;
			do
			{
				if (j==6) break;
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//실행문
				j += 1; // 증감식
			}
			while (j <= 9);

			System.out.println(); //실행문장
			i += 1; // 증감식
		}
		while (i <= 9);

		System.out.println("------------------------------");




	}
}
