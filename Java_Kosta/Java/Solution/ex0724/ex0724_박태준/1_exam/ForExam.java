/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : For ����

	5. 2�� for���� �̿��ؼ� �������� ���(9�� 8��)
*/

class ForExam
{
	public static void main(String [] args)
	{
		// 1) 2�� for���� �̿��ؼ� �������� ���(9�� 8��)
		System.out.println("\nProblem01 : 2�� for���� �̿��ؼ� �������� ���(9�� 8��)");
		System.out.println("--------------------------------------------------------------");
		
		for (int i = 1; i <= 9 ; i++)
		{
			for (int j = 2; j <= 9 ; j++)
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//���๮
			}
			System.out.println(); //���๮��
		}

		System.out.println("--------------------------------------------------------------");

	}
}
