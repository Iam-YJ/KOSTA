package ex0807;
//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.

interface InterfaceExam00{//상속x, 생성x , 구현(implements) 한다
	//모든 변수는 public static final 이다 (즉 상수이다)
	// 모든 메소드는 public abstract 이다. (추상메소드이다)
	// 1.8ver 부터 default, static 메소드가 추가 (body 있는 메소드)
	abstract void interfaceExam00();
}


interface InterfaceExam01 extends InterfaceExam00{ //interface 끼리는 상속 가능 
	final int i = 767;
	public static final int k = 999;
	//interface의 모든 변수는 public static final이다. 상수임.
	//(public static) 자동
	void interfaceExam01(int i, int k);
	//(abstract) 자동 
}



interface InterfaceExam02{
	int j =747;
	public static final int privateInt = 8; 
	public abstract void interfaceExam02(int j); 
	 // interface의 모든 method는 public abstract이다. ⇨ 기능X 
	
}



class SuperClassExam{
	String superString = "Super";

	String superMethod(){
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01{
	//다형성 형성 - 상속, 구현으로 
	public void interfaceExam01(int i, int k) {}
	public void interfaceExam00() {}
	
	
} 



 abstract class SubClassExam02 extends SuperClassExam 
				implements InterfaceExam01, InterfaceExam02{
	 
	 

}


abstract class SubClassExam03 extends
			 SuperClassExam implements InterfaceExam01, InterfaceExam02{
}
			

class SubClassExam04 extends SubClassExam02{
	//여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00(){}
	public void interfaceExam01(int i, int k){}
	public void interfaceExam02(int j){}

	SubClassExam04(){
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = "+i);
		System.out.println(" j = "+j);
	}
	SubClassExam04(String s1, String s2){
		System.out.println(s1+" 타입 "+"subClassExam04("+s2+") 객체 생성");
		
	}
	void printSuperString(){
		InterfaceExam01 ie01; //생성은 가능 
		//InterfaceExam01 ie01 = new InterfaceExam01(); 
		//interface는 생성 불가능 

		System.out.println(" superString = "+superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam{ 
	public static void main(String args[]){		
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam  superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1,7);
		sub04.superMethod();
	}
}

