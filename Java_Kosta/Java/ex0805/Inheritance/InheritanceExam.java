
class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
	class EfSonata extends Car{
		EfSonata(){
			this.carname = "소나타";
			this.cost = 1000;
		}
	}
//ObjectDownCasting을 하기 전에 inststanceof를 이용하여 형변환 가능한지를 체크한 후 캐스팅을 한다.
	class Excel extends Car{
		Excel(){
			int a = 5;
			suㅁ2is.cost = 2000;
		}
	}

	class Canival extends Car{
		Canival(){
			this.carname = "카니발";
			this.cost = 3000;
		}
	}

	
public class InheritanceExam{
	//메인메소드에서 
	public static void main(String [] args){
		Car c = new Car();
		EfSonata efs = new EfSonata();
		Excel ex = new Excel();
		Canival cv = new Canival();

		c.printAttributes();
		efs.printAttributes();
		ex.printAttributes();
		cv.printAttributes();
 // 동일한 객체를 상속받아도 부모는 각각 생성된다.

		
	}
	
		//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
		
	
}

