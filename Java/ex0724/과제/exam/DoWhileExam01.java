class DoWhileExam01{

	public static void main(String [] args){

		//1
		int a = 1;
		do{
			System.out.print(a+"\t");
			a++;
		}while(a<=100);

		System.out.println();
		System.out.println("----------");

		//2
		int b = 65;
		do{
			System.out.print((char)b+"\t");
			b++;
		}while(b<=90);
		System.out.println();
		System.out.println("----------");

		//3
		int c = 1;
		do{
			System.out.print(c+"\t");
			if(c%10 == 0){
				System.out.println();
			}
			c++;
		}while(c<=100);
		System.out.println();
		System.out.println("----------");

	}


}