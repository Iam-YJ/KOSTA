 class WhileExam01
{
	public static void main(String[] args)
	{
		System.out.println("1. 1~100���� �� �ٷ� ���");
		int iNum = 0;
		while(iNum < 100){
			++iNum;
			System.out.print(iNum + " ");
        }


		System.out.println("\n\n2. A~Z���� �� �ٷ� ���");
		iNum = 65;
		while(iNum <= 90){
			System.out.print((char)iNum++ + " ");
        }

       System.out.println("\n\n2. A~Z���� �� �ٷ� ���");
	   char ch='A';
	   while(ch<='Z'){
             System.out.print(ch++ + " ");
	   }				

       
		System.out.println("\n\n3. 1~100���� 10�� 10���� ��� (if�� ���)");
		iNum = 0;
		while(iNum < 100)
		{
			System.out.print(++iNum + " ");
			if (iNum%10 == 0) System.out.println();
		}

	}
}