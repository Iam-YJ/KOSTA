/**
�����̸�: ������
��¥:20 07 23
����: �����߻�, ���
*/



class Test{


public static void main(String [] args){

//���� 1~100
double random = Math.random() * 100 + 1;
int num = (int)random;

//������ ������ ¦������ Ȧ������ �����ؼ� ¦���Դϴ�, Ȧ���Դϴ� ����ϱ�

int test = num % 2 ;

System.out.println(num);
if (test == 0)
{
	System.out.println("¦���Դϴ�");
}else{

	System.out.println("Ȧ���Դϴ�");

}
}

}