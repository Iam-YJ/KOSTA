package p314;

public class InstanceofExample {
	
	public static void method01(Parent parent) {
		if(parent instanceof Child){
			Child child=(Child)parent;
			System.out.println("method01-Child로 변환성공");
		}else {
			System.out.println("method01-Child로 변환되지않음");
		}
	}
	
	public static void method02(Parent parent) {
		Child child=(Child)parent;
		System.out.println("method02-Child로 변환성공");
	}

	public static void main(String[] args) {
		Parent parent1=new Child();
		method01(parent1);
		method02(parent1);
		
		Parent parent2=new Parent();
		method01(parent2);
		method02(parent2);
		
		

	}

}
