public class DoWhileExam01
{
	public static void main(String[] args)
	{
		System.out.println("1. Do/While 1~100까지 한 줄로 출력");
		int iNum = 0;
		do
		{
			System.out.print(++iNum + " ");
		} while (iNum < 100);

		System.out.println("\n\n2. Do/While A~Z까지 한 줄로 출력");
		iNum = 65;
		do
			System.out.print((char)iNum++ + " ");
		while(iNum <= 90);

		System.out.println("\n\n3. Do/While 1~100까지 10행 10열로 출력 (if문 사용)");
		iNum = 0;
		do
		{
			System.out.print(++iNum + " ");
			if (iNum%10 == 0) System.out.println();
		} while(iNum < 100);
	}
}