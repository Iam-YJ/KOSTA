
//ConstructorExam.java
class Puppy{
		//String,int  Ÿ�� ���� ���� ����(member ��������)
		 String s ;
		 int i;
		
		/*	�޼ҵ� printPuppyName�ۼ�
			�μ�����, ���Ͼ���
			"public void printPuppyName() ȣ��Ǿ����ϴ�!"���
			���������� ���
		*/	
			public void printPuppyName(){
				System.out.println("public void printPuppyName() ȣ��Ǿ����ϴ�!");
				System.out.println("�������� String : "+this.s +", �������� int : " + this.i);
			}
		
		
		
		/*�μ��� ���� ������ �ۼ�
			"������ public Puppy() ȣ��Ǿ����ϴ�!"���
			printPuppyName�޼ҵ� ȣ��
				�������� String��"�޸�" �Ҵ�
			�������� int�� -98998 �Ҵ�
		*/
		Puppy(){
			System.out.println("������ public Puppy() ȣ��Ǿ����ϴ�!");
			this.printPuppyName();
			this.s = "�޸�";
			this.i = -98998;
		}
			
		
}

class ConstructorExam{
	//���θ޼ҵ忡��
	public static void main(String [] agrs){
		//Puppy��ü ����
		 Puppy p = new Puppy();
		//Puppy��ü�� printPuppyName�޼ҵ� ȣ��
		p.printPuppyName();
	}
}
			
