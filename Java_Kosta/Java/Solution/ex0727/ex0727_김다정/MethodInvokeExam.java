/*�����̸�:�����
  ��¥: 20.07.27
  ���� : MethodinvokeExam.java ����  */

class Methodinvoke01{
	//������ ���� �޼ҵ带 �ۼ��ϼ���.
	
	/*method �̸� : method01
	��𼭳� ������ ���ٰ���
	���� ����
	�μ��� ����2�� ����
	�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ����*/
	public int method01(int a, int b){
		int sum = a*b;
		System.out.println("���� 2�� ���ϱ� ���:"+sum);
		return sum;
	}
}

class Methodinvoke02{
	
	//method �̸� : method02
	//��𼭳� ������ ���ٰ���,��ü�� �������� �ʰ� ���ٰ���=>static�޼��� �����
	//���� ����
	//�μ��� ����2�� ����
	
	//�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ���Ѽ� ����
		
	public static int method02(int a, int b){
		int sum = a+b;
		System.out.println("���� 2�� ���ؼ� ���:"+sum);
		return sum;
	}
		
}

class MethodInvokeExam{
	public static void main(String []args){
		
		//MethodInvoke01�� method01 ȣ��
		Methodinvoke01 me = new Methodinvoke01();
			int a = me.method01(10,20);
			System.out.println(a);

		//MethodInvoke02�� method02 ȣ��
		int b = Methodinvoke02.method02(1,2);
		System.out.println(b);
		

	}
}

