//UsingMethod.java

class UsingMethodExam{
     //�Ʒ��� ���� �޼ҵ带 �ۼ��ϼ���.
   
     /*Method�̸� :  methodExam03_01
     �ڱ��ڽŸ� ���ٰ���
     ReturnType : ����
     Parameter : ���� 1��
	(�����ο���)�ϴ� �� : 
	methodExam03_01�� ȣ��Ǿ����ϴ�. ���
	�μ��� ���� ���� ��� 
	����*2 ����. */

	private int methodExam03_01(int a){
		System.out.println("methodExam03_01�� ȣ��Ǿ����ϴ�.");
		System.out.println(a);

		return a*2 ; 
	
	}
		
	
	 
	 /*Method�̸� :  methodExam03_02
     ��𼭳� �ƹ��� ���ٰ���
     Return String
     Parameter : String 1��, ���� 1��
	(�����ο���)�ϴ� �� : 
		methodExam03_02�� ȣ��Ǿ����ϴ�. ���
		�μ��� ���� String �� �ٺ��� �ٿ��� ���
		�ι�°�μ��� ���� ���� methodExam03_01�� �־� �ָ� methodExam03_01�� ȣ���ϰ� �����ϴ� ���� ���
		�μ��� ���� String �� �ٺ��� �ٿ��� ����
	*/	

		public String methodExam03_02(String s, int i){
			System.out.println("methodExam03_02�� ȣ��Ǿ����ϴ�.");
			String ns = s + "�ٺ�";
			System.out.println(ns);
			int ni = this.methodExam03_01(i);
			System.out.println(ni);
			
			return ns;
		}
	
	 /*Method�̸� :  methodExam03_03
     ���� package���� �ƹ��� ���� ����
     ReturnType : ���Ͼ���
     Parameter : ���� 1���� String 1��
     (�����ο���)�ϴ� �� : 
		methodExam03_03�� ȣ��Ǿ����ϴ�. ���
		�μ��� ���� ���� 1���� String 1���� �Ѱ��ָ�
		methodExam03_02ȣ��
	*/	
		void methodExam03_03(int i, String s){
			System.out.println("methodExam03_03�� ȣ��Ǿ����ϴ�.");
			this.methodExam03_02(s,i);
	}
		
	
     
     /*Method�̸� :  methodExam03_04
     ��Ӱ����� ��𼭳� ���� ����
     ReturnType : �Ǽ�(�ε��Ҽ���)
     Parameter : ù��° �μ�(����),�ι�° �μ�(�Ǽ�), ����°�μ�(����)
	(�����ο���)�ϴ� �� : 
		methodExam03_04�� ȣ��Ǿ����ϴ�. ���
		�μ��� ���� ���� �̿��� 
		MakeMethodExam02��ü�� methodExam02_04�޼ҵ� ȣ���ϰ�
		method02_04�� �����ϴ� ���� ����
	*/	

		protected double methodExam03_04(int a, double b, int c){
			System.out.println("methodExam03_04�� ȣ��Ǿ����ϴ�.");
			MakeMethodExam02 mme = new MakeMethodExam02();
			double d = mme.methodExam02_04(1,2.0,3);

			return d;
		}
		
} // UsingMethodExam ��

class UsingMethod{
	//���θ޼ҵ忡��
		//UsingMethodExam�� ȣ�Ⱑ���� �޼ҵ���� ȣ���ϰ�
		// �����ϴ� �� �ִٸ� ���
		public static void main(String [] args){

		UsingMethodExam ume = new UsingMethodExam();

		//ume.methodExam03_01(1);
		//System.out.println(ume.methodExam03_01(1));
		//private�� ȣ�� ���ϰ�, ���ϵ� �ȵ�
		System.out.println("============1����=============");
		
		ume.methodExam03_02("s",2);
		System.out.println(ume.methodExam03_02("s",2));
		System.out.println("=============2����============");

		ume.methodExam03_03(3,"r");
		//System.out.println(ume.methodExam03_03(3,"r"));
		//void ���� return�� ���� 
		System.out.println("============3����=============");

		ume.methodExam03_04(4,5.5,6);
		System.out.println(ume.methodExam03_04(4,5.5,6));
		System.out.println("============4����=============");
		}

		
	
}

  
