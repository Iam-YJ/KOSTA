package p314;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent=new Child();
		
		parent.field1="data1";
		parent.method1();
		parent.method02();
		
		/*
		 * parent.field2="data2";
		 * parent.method03();  //호출불가
		 * */
		
		Child child=(Child)parent;//object down casting을해야 부모부분의 것을 접근가능하다.
		child.field2="yyy";
		child.method03();
		

	}

}
