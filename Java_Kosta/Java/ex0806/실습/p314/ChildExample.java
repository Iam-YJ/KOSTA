package p314;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent=new Child();
		
		parent.field1="data1";
		parent.method1();
		parent.method02();
		
		/*
		 * parent.field2="data2";
		 * parent.method03();  //ȣ��Ұ�
		 * */
		
		Child child=(Child)parent;//object down casting���ؾ� �θ�κ��� ���� ���ٰ����ϴ�.
		child.field2="yyy";
		child.method03();
		

	}

}
