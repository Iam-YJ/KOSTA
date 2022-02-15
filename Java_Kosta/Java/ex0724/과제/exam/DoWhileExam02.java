class DoWhileExam02{

	public static void main(String [] args){

		//1
		int a = 0;
		do{
			int b = 1;
			do{
				System.out.print((a*10)+b+"\t");
				b++;
			}while(b<=10);
			System.out.println();
			a++;
		}while(a<10);

		System.out.println();
		System.out.println("----------");


		//2
		int c = 2;
		do{
			int d = 1;
			do{
				System.out.print(c+" * "+d+" = " +(c*d)+"\t");
				d++;
			}while(d<=9);
			System.out.println();
			c++;
		}while(c<=9);

		System.out.println();
		System.out.println("----------");


		//3
		int c = 2;
		do {
			int d = 1;
			do {
				if (c == 2 | c == 3 | c == 4 | c == 6 | c == 7 | c == 8 | c == 9) {
					System.out.print(c + " * " + d + " = " + (c * d) + "\t");
					d++;
				}
			} while (d <= 9);
			System.out.println();
			c++;
		} while (c <= 9);

		System.out.println();
		System.out.println("----------");



	}


}