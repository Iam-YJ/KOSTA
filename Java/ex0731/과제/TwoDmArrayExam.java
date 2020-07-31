//TwoDmArrayExam.java

class TwoDmArray{
	//String을 저장하는 twoDmArray 배열선언
	String [][] twoDmArray = new String [10][];
	int [][] arr = new int [10][];
	
	//메소드 make2DmArray
	//twoDmArray 배열에  값을 할당
	public void make2DmArray(){
		int count = 1;
		for(int i=0; i<10; i++){
			for(int k=1; k<=10-i; i++){
				twoDmArray[i] = new String[k];
				//twoDmArray[i][k] = (String)("동");
			}
			for(int l=1; l<=10-i; l++){
				twoDmArray[i][l] = ("동");
			}
			

		}

	}

/*	for (int i=1; i<=5; i++ ){
		for(int j=1; j<=i; j++){
			System.out.print("☆");
		}
		for(int k=1; k<=6-i; k++){
			System.out.print("★");
		}
		System.out.println(); */
		
		
	//메소드 print2DmArray
	//	twoDmArray 배열의 값을 주어진형식으로 출력
	public void print2DmArray(){
		System.out.println("ㅗㅗㅗ");
		for(int i=0; i<twoDmArray.length; i++){
			for(int j=0; j<twoDmArray[i].length; j++){
				System.out.print(twoDmArray[i][j]+"\t");

			}System.out.println();
		}
	}
		
}

public class TwoDmArrayExam{
	//main메소드에서
	public static void main(String [] args){
		//TwoDmArray객체생성
		TwoDmArray tda = new TwoDmArray();
		//TwoDmArray객체의 make2DmArray메소드 호출
		tda.make2DmArray();
		//TwoDmArray객체의 print2DmArray메소드 호출
		tda.print2DmArray();

	
	}
	
		
	
}
