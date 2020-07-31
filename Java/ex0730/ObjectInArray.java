//ObjectInArray.java

class ObjectOne{
	public int a;
}

public class ObjectInArray{
	//메인 메소드에서 
	public static void main(String [] args){
		ObjectOne oo = new ObjectOne();

		ObjectOne [] arr = new ObjectOne[5];

		for(int i=0; i<arr.length; i++){
			arr[i] = new ObjectOne();
		}

		for(int i=0; i<arr.length; i++){
			System.out.println("arr["+i+"]의 전역변수 "+arr[i].a);
			System.out.println("arr["+i+"]의 주소값 "+ arr[i]);
			System.out.println();
		}

		for(int i=0; i<arr.length; i++){
			int num = (int)(Math.random()*50+1);
			arr[i].a = num;
			System.out.println("변경된 arr["+i+"]의 전역변수 "+arr[i].a);
			System.out.println();
		}
	}
	
		//ObjectOne 타입을 5개 까지 저장하는 배열을 선언하고
		 
		//5개의 ObjectOne객체를 생성하세요.
		//각 객체가 갖고있는 전역변수 출력
		//각 객체의 주소값 출력
			
		//각각의 ObjectOne객체가 서로 다른 a의 값을 갖도록 a의 값을 변경하세요.			
		//각 ObjectOne 객체의 a를 출력하세요
}
