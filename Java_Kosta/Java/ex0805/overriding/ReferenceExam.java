class ObjectExam{
	String str;

	public ObjectExam(){   }

	public ObjectExam(String str){
		this.str = str;
	}
	
	public String toString(){
		return str +" �ּ�: " +  super.toString();
	} //�������̵� �ؼ� �ּҰ��� �ƴ� ����� ������ �Ѵ�.

	//������ @Overriding ... Annotation : ǥ��

}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="������"; 
			String s02="Java";
			String s03=new String("������");
			ObjectExam oe1=new ObjectExam("����");
			ObjectExam oe2=new ObjectExam("�ȳ�");

			
			System.out.println(c);//
			/* 
			print(Object obj) or println(Object obj)�� �μ��� Object�� ������
			�ڵ����� Object�� ���ǵǾ� �ִ� toString() �޼ҵ尡 ȣ��ȴ�.

			:Object�� ���ǵ� toString()�� �޼ҵ�� ��ü�� �ּҸ� String�� ���ڿ��� ����� �����Ѵ�.
			 ex) Ŭ�����̸� @hashcode ���·� �����Ѵ�.
			*/

			System.out.println(s01);
			//System.out.println(s01.toString()); �� ���� 
			//�ּҰ��� ���� �ʰ� ���ڿ��� ��� ���� 
			// -> String�� Object�� ���ǵǾ� �ִ� toString() ������ �ؼ� �ٸ� ���� �Ѵ� .
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1);//
			System.out.println(oe2);//
			
	}
}
