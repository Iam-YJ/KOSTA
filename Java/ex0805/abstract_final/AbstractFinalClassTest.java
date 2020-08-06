//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{ //상속불가, 생성가능 
 final int i = -999999; //상수, 값변경 불가, 반드시 초기화 필수(전역변수여도 초기화해야함)
}
/*
	final 변수 초기화 방법
	1. 명시적 초기화 -> final int i = 100;
	2. 생성자를 이용한 초기화 

	FinalClassExam (){
		i = 100;
	} -> 객체가 생성되는 시점에 명시적 초기화 같은 것 

*/


abstract class AbstractClassExam{ //상속가능, 생성안됨 
    abstract String abstractMethodExam(int i,String s); //기능이 없다. 자식클래스에서 재정의를 위해 만듬     
    //ex) 상속 sound 만들고 -> 각 클래스에서 상속받아 -> 구체화
	final int finalMethodExam(int i, int j){ //재정의 불가 
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	@Overriding
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	/*int finalMethodExam(int i, int j){
		return i*j;
	}*/ //위에 final로 되어있어서 재정의 불가 
	
}

class Sample02 /* extends FinalClassExam */ {  } //extends FinalClassExam 불가. final이여서 상속 안됨


 
abstract class Sample03 extends AbstractClassExam{ //abstract 상속은 abstract만 
	 String abstractMethodExam(int i,String s){
		return s+i;
	 }

	abstract String abstractMethodExam(); 
	// Abstract는 public abstract void aa(); 선언부만 있고 구현 x

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		//AbstractClassExam ace = new AbstractClassExam(); 
		//abstract 는 new 사용 불가 
		FinalClassExam fce = new FinalClassExam();
//		fce.i=100000;
//final은 값 변경 불가 (상수여서)
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
