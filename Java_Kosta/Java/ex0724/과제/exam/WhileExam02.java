class WhileExam02{

	public static void main(String [] args){

		//1
		int i = 0; 
		while(i < 10){
			int j =1;
			while (j<=10)
			{
				System.out.print((i*10)+j + "\t");
				j++;
			}
			i++;
			System.out.println();

		}		
		System.out.println();
		System.out.println("----------");

		//2
		int m = 2;
		while(m <=9){
			int n = 1;
			while(n <= 9){
				System.out.print(m +" * "+ n+" = "+(m*n)+"\t");
				n++;
			}m++;
			System.out.println();
		}
		System.out.println();
		System.out.println("----------");

		//3
		int x = 2;
		while(x <=9){
			int y = 1;
			while(y <= 9){
				if(x==2 | x==3 | x==4 | x==6 |x==7 |x==8|x==9) {

				
				System.out.print(x +" * "+y +" = "+(x*y)+"\t");
				y++;
				}
				else {
					x = 6;
				}
			}x++;
			System.out.println();
		}
		System.out.println();
		System.out.println("----------");

	}
}