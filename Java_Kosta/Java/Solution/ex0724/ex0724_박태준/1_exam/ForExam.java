/**
	본인이름 : 박태준
	날짜 : 2020-07-24
	주제 : For 연습

	5. 2중 for문을 이용해서 구구단을 출력(9행 8열)
*/

class ForExam
{
	public static void main(String [] args)
	{
		// 1) 2중 for문을 이용해서 구구단을 출력(9행 8열)
		System.out.println("\nProblem01 : 2중 for문을 이용해서 구구단을 출력(9행 8열)");
		System.out.println("--------------------------------------------------------------");
		
		for (int i = 1; i <= 9 ; i++)
		{
			for (int j = 2; j <= 9 ; j++)
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//실행문
			}
			System.out.println(); //실행문장
		}

		System.out.println("--------------------------------------------------------------");

	}
}
