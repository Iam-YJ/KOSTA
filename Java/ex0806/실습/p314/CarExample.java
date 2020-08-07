package p314;

public class CarExample {

	public static void main(String[] args) {
	 Car car=new Car();
	 for (int i = 1; i <5; i++) {
		 int problemLocation=car.run();
		 
		 if(problemLocation!=0){
			 System.out.println(car.tires[problemLocation-1].location+"HankookTire 로 교체");
			 car.tires[problemLocation-1]=new HankookTire(car.tires[problemLocation-1].location,15);
			 
			 
		 }
		 System.out.println("-------------------------");
		
	 
	/*
		 switch(problemLocation) {
	 case 1 :
		 System.out.println("앞왼쪽 HankookTire로 교체");
		 car.frontLeftTire=new HankookTire("앞왼쪽",15);
		 break;
	 case 2:
		 System.out.println("앞오른쪽 KumhoTire로 교체");
		 car.frontRightTire=new HankookTire("앞오른쪽",13);
		 break;
	 case 3 :
		 System.out.println("뒤왼쪽 HankookTire로 교체");
		 car.backLeftTire=new HankookTire("뒤왼쪽",14);
		 break;
	 case 4 :
		 System.out.println("뒤오른쪽 KumhoTire로 교체");
		 car.backRightTire=new KumhoTire("뒤오른쪽",17);
		 break;
	 }
	 System.out.println("---------------------------------");
	 
	 }
*/
	}

}
}
