class CarCenter{
	public void engineer(Car cd){ //매개변수를 이용한 다형성 
		//Car(부모) 타입으로 받아서 자식들에 접근할 수 있음
		//하지만 자식 중 car 타입만 접근 가능하고 자식 타입은 접근 x 
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{ // InferitanceExam.java와 같은 클래스에 있어야한다.
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata(); //ef를 car라고 부를 수 있기 때문에 engineer에서도 오류 x
		Canival ca=new Canival();
		Excel ex=new Excel();
		Car c= new Car();
		
	sdd	cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		
		/*
		System.out.println("ex 주소 : " + ex);
		System.out.println("ex.a : "  + ex.a);
		
		
		System.out.println("cd.a : "  + cd.a); 
		//부모타입 변수로는 자식부분 접근할 수 없다
		// -> 접근가능하게 하려면 부모타입변수를 자식타입변수에 담는다
		// -> 부모 > 자식 : 그래서 ObjectDownCasting 필요하다 
		//Excel e = (Excel) cd; ->ObjectDownCasting
		// -->> System.out.println("e.a : "  + e.a); 
*/
		cc.engineer(ex);//
		
		
	
	}
}
