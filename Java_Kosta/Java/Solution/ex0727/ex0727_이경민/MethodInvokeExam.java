class Methodinvoke01{
	//������ ���� �޼ҵ带 �ۼ��ϼ���.
	public int method01(int no1, int no2){
		System.out.println("���ϱ� ��°� :" + (no1*no2));
		return no1*no2;
	}
	/*method �̸� : method01
	��𼭳� ������ ���ٰ���
	���� ����
	�μ��� ����2�� ����
	�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ����*/
		
	
}

class Methodinvoke02{
	
	public static int method02( int no1, int no2){
		System.out.println("���ϱ� ��°� :" + (no1+no2));
		return no1+no2;
	}
	//method �̸� : method02
	//��𼭳� ������ ���ٰ���,��ü�� �������� �ʰ� ���ٰ���
	//���� ����
	//�μ��� ����2�� ����
	
	//�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ���Ѽ� ����
		
		
	

	
}

class MethodInvokeExam{
	public static void main(String []args){
		
		//MethodInvoke01�� method01 ȣ��
		Methodinvoke01 met = new Methodinvoke01();
		int mul =met.method01(3,4);

		//MethodInvoke02�� method02 ȣ��
		int sum = Methodinvoke02.method02(1,2);

		

	}
}

