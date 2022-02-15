class ExampleFor2{

	//이중for문 예제 

	public static void main(String [] args){
		//1. 3행 3열의 모양으로 "열공" 글자 출력하기
		//2. 1~100까지 출력하는데 10행 10열의 모양으로 (이중 for문 이용해서)
	

	//1

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print("열공\t");
			
			}System.out.println();
		}
		System.out.println("-----------------");
	

	//2
		int num = 0;
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				num++;
				System.out.print(num+"\t");
			
			}System.out.println();
		
		}
		System.out.println("-----------------");n

	//2-1
		for(int i=0; i<10; i++){
			for(int j=1; j<=10; j++){
				System.out.print((i*10)+(j)+"\t");
			
			}System.out.println();
		
 		}


	}
}





