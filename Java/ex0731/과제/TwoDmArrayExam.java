//TwoDmArrayExam.java

class TwoDmArray{
	//String을 저장하는 twoDmArray 배열선언
	String [][] twoDmArray = new String [10][];
	
	//메소드 make2DmArray
	//twoDmArray 배열에  값을 할당
	public void make2DmArray(){
		for(int i=0; i<twoDmArray.length; i++){
			twoDmArray[i] = new String[twoDmArray.length];
			for(int j=0; j<twoDmArray[i].length; j++){
				twoDmArray[i][j] = (i+1)+"동"+(j+1)+"호";
			}
		}
	}

		
	//메소드 print2DmArray
	//	twoDmArray 배열의 값을 주어진형식으로 출력
	public void print2DmArray(){
		for(int i=0; i<twoDmArray.length; i++){
			for(int j=0; j<i; j++){
				System.out.print(""+"\t");
			}for(int k=i; k<10; k++){
				System.out.print(twoDmArray[k][i]+"\t");
			}
			System.out.println();
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
