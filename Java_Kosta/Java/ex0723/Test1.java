/**
�����̸�: ������
��¥:20 07 23
����: �����߻�, ���
*/


class Test1{

//1. 1~10 ������ ���� �߻��ؼ� 
//1�̸� �Ͽ���, 2�� ������, 3�̸� ȭ����, 4�� ������, 5�� �����, 6�̸� �ݿ���,7 �̸������ ���

 
public static void main(String [] args){

	double random = Math.random() * 10 + 1 ;
	int week = (int)random;
	int day = week % 7;

	if (week == 1)
	{
		System.out.println(week+"�� �Ͽ����Դϴ�");
	}else if (week == 2)
	{
		System.out.println(week+"�� �������Դϴ�");
	}else if (week == 3)
	{
		System.out.println(week+"�� ȭ�����Դϴ�");
	}else if (week == 4)
	{
		System.out.println(week+"�� �������Դϴ�");
	}else if (week == 5)
	{
		System.out.println(week+"�� ������Դϴ�");
	}else if (week == 6)
	{
		System.out.println(week+"�� �ݿ����Դϴ�");
	}else
	{
		System.out.println(week+"�� ������Դϴ�");
	}

}

}