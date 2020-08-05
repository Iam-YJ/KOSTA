//에러나는부분을 주석처리하고 이유를 써보세요!
class Car{} 
class EfSonata extends Car{}
class Excel extends Car{}
class Canival extends Car{}
class People{}

public class InstanceofExam{
	public static void main(String args []){
		
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Canival ca = new Canival();
		//People p = new People();	-//people은 상속관계가 없기 때문에 instanceof 사용 x	
		
		if(car instanceof Car){
			System.out.println("car instanceof Car is true"); //o
		}else{
			System.out.println("car instanceof Car is false");
		}
		
		if(car instanceof EfSonata){
			System.out.println("car instanceof EfSonata is true");
		}else{
			System.out.println("car instanceof EfSonata is false");//o
		}
		
		if(ef instanceof Car){ 
			System.out.println("ef instanceof Car is true");//o
		}else{
			System.out.println("ef instanceof Car is false");
		}
		
		if(ex instanceof Car){
			System.out.println("ex instanceof Car is true");//o
		}else{
			System.out.println("ex instanceof Car is false");
		}
		
		if(ca instanceof Car){
			System.out.println("ca instanceof Car is true");//o
		}else{
			System.out.println("ca instanceof Car is false");
		}
		
		/*
		if(p instanceof Car){
			System.out.println("p instanceof Car is true"); // x
			//instanceof 연산자는 상속관계일 때 상용할 수 있다.
		} 
		*/
	}
}	
