class Methodinvoke01{
	//������ ���� �޼ҵ带 �ۼ��ϼ���.
	
	/*method �̸� : method01
	��𼭳� ������ ���ٰ���
	���� ����
	�μ��� ����2�� ����
	�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ����*/

	public int method01(int a, int b){
		int c = a * b;
		System.out.println(c);
		return c;
	
	}
		
	
}

class Methodinvoke02{
	
	//method �̸� : method02
	//��𼭳� ������ ���ٰ���,��ü�� �������� �ʰ� ���ٰ���
	//���� ����
	//�μ��� ����2�� ����
	
	//�μ��� ���� ���� 2���� ���ؼ� ����ϰ� ���Ѽ� ����
		

		public static int method02(int a, int b){
			int c = a+b;
			System.out.println(c);

			return c;
		
		}
		
	}

	


class MethodInvokeExam{
	public static void main(String []args){


		
		//MethodInvoke01�� method01 ȣ��
		Methodinvoke01 mi01 = new Methodinvoke01();
		int c = mi01.method01(10,20);
		System.out.println(c);


		//MethodInvoke02�� method02 ȣ��
		int d = Methodinvoke02.method02(30,40); 
		System.out.println(d);

	}
}

