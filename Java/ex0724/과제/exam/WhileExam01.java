class WhileExam01{

	public static void main(String [] args){

		//1
		int num = 1;
		while(num <=100){
			System.out.print(num+" ");
			num++;
		
		}
		System.out.println();
		System.out.println("----------");

		//2
		int letter = 65;
		while(letter <= 90){
			System.out.print((char)letter+" ");
			letter++;
		}		
		System.out.println();
		System.out.println("----------");

		//3
		int i = 1; 
		while(i <= 100){
			System.out.print(i+"\t");
			if(i % 10 == 0){
				System.out.println();
			}
			i++;
		}		
		System.out.println();
		System.out.println("----------");


	}
}