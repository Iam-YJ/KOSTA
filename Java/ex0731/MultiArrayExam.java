class MultiArrayExam{

	//2차원 배열
	//int [][] arr; //null
	//int arr [][] = new int [3][5];
	//String arr[][] = new String [3][5];
	
	int arr[][] = new int [][]{
		{2,4,6},
		{1,3,5,7,9,1,2,3},
		{10,20,30,40,50},
		{10,20}
	
	};

	public void test(){
		System.out.println("arr=" + arr);
		System.out.println("arr[0]=" + arr[0]);
		System.out.println("arr[0][0]=" + arr[0][0]);

		System.out.println("arr.length=" + arr.length); //행의 길이
		System.out.println("arr[0].length=" + arr[0].length); //0행의 길이 

		//값변경
		arr[1][2] = 100;
		// arr[0][3] = 10; 없는 곳에 값을 넣으려고 해서 ArrayIndexOutOfBound
		

		System.out.println("****************************");
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j] + "\t");
			
			}System.out.println();
		}

		System.out.println("**********개선된 for로 변경************");
		for(int [] row : arr){ //행
			for(int col : row){
				System.out.print(col + "\t");
			
			}System.out.println();
		}

	
	}
	
	public static void main(String [] args){
		MultiArrayExam mae = new MultiArrayExam();
		mae.test();
	
	
	}


}