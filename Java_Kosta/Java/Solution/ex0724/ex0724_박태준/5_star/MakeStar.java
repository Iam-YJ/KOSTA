/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : ����� �����
*/

class MakeStar
{
	public static void main(String [] args)
	{
		// 
		System.out.println("\nProblem01");
		System.out.println("--------------------------------------------------------------");
		
		for (int i = 1; i <= 5 ; i++)
		{
			for (int j = 1; j <= 5 ; j++)
			{
				if (i < j) System.out.print(" ");
				else System.out.print("��");	
			}
			System.out.println(); 
		}
		System.out.println("--------------------------------------------------------------");

		for (int i = 1; i <= 5 ; i++)
		{
			for (int j = 1; j <= 5 ; j++)
			{
				if ((5-i+1) < j) System.out.print("  ");
				else System.out.print("��");	
			}
			System.out.println(); 
		}

		System.out.println("--------------------------------------------------------------");
		
		for (int i = 1; i <= 5 ; i++)
		{
			for (int j = 1; j <= 5 ; j++)
			{
				if ((5-i+1) > j) System.out.print("  ");
				else System.out.print("��");	
			}
			System.out.println(); 
		}

		System.out.println("--------------------------------------------------------------");
		
		for (int i = 1; i <= 5 ; i++)
		{
			for (int j = 1; j <= 5 ; j++)
			{
				if (i > j) System.out.print("  ");
				else System.out.print("��");	
			}
			System.out.println(); 
		}

		System.out.println("--------------------------------------------------------------");

	}
}
