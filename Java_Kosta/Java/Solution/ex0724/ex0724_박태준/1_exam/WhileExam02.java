/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : while ���� 2

	2.WhileExam02.java�� �����.
	1) 1~ 100���� �� 10�� 10�� ���
      ����(while�� �ȿ� while�� )
	2) �������� ���
	3) 2)�� �������� ������� 5�� ���� ��� 
*/

class WhileExam02
{
	public static void main(String [] args)
	{
		// 1) 1~ 100���� �� 10�� 10�� ���, cf) ����(while�� �ȿ� while�� )
		System.out.println("Problem01 : 1~ 100���� �� 10�� 10�� ���, cf) ����(while�� �ȿ� while��) ");
		System.out.println("---------------------------------------");
		int i = 1; //�ʱ�ȭ
		int sum = 0; 
		while (i <= 10) // ���ǽ�
		{
			int j = 1; //�ʱ�ȭ
			while (j <= 10) // ���ǽ�
			{
				System.out.print(++sum + "\t");	//���๮
				j += 1; // ������
			}
		
			System.out.println(); //���๮��
			i += 1; // ������
		}
		System.out.println("---------------------------------------");


		// 2) �������� ���
		System.out.println("\nProblem02 : �������� ���");
		System.out.println("--------------------------------------------------------------");
		i = 1; //�ʱ�ȭ 
		while (i <= 9) // ���ǽ�
		{
			int j = 2; //�ʱ�ȭ
			while (j <= 9) // ���ǽ�
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//���๮
				j += 1; // ������
			}
		
			System.out.println(); //���๮��
			i += 1; // ������
		}
		System.out.println("--------------------------------------------------------------");


		// 3) 2)�� �������� ������� 5�� ���� ��� 

		System.out.println("\nProblem03 : 2)�� �������� ������� 5�� ���� ���");
		System.out.println("------------------------------------------------------");
		i = 1; //�ʱ�ȭ 
		while (i <= 9) // ���ǽ�
		{
			int j = 1; //�ʱ�ȭ
			while (j < 9) // ���ǽ�
			{
				j += 1; // ������
				if (j == 5) continue; //continue�� �̿��Ͽ� 5�� �ǳʶٱ�
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//���๮
			}
		
			System.out.println(); //���๮��
			i += 1; // ������
		}
		System.out.println("------------------------------------------------------");




	}
}
