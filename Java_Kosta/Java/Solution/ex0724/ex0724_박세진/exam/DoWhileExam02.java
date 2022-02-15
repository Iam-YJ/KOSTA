public class DoWhileExam02
{
	public static void main(String[] args)
	{
		System.out.println("1. Do/While 1~100까지 10행 10열로 출력 (다중 While문 사용)");
		int iNumX = 0, iNumY = 0, iNum = 0;
		do
		{
			iNumX = 0;
			while(iNumX++ < 10)
				System.out.print(++iNum + "\t");
			System.out.println();
		} while(iNumY++ < 9);

		System.out.println("\n\n2. Do/While 구구단 출력");
		iNumY = 1;
		do
		{
			iNumX = 0;
			while(iNumX++ < 9)
				System.out.print(iNumY + "x" + iNumX + "=" + iNumX*iNumY + "\t");
			System.out.println();
		} while(iNumY++ < 9);

		System.out.println("\n\n3. Do/While 구구단 출력 (5단 제외)");
		iNumY = 1;
		do
		{
			if (iNumY == 5) continue;
			iNumX = 0;
			while(iNumX++ < 9)
				System.out.print(iNumY + "x" + iNumX + "=" + iNumX*iNumY + "\t");
			System.out.println();
		} while(iNumY++ < 9);
	}
}