class Star{

	public static void main(String [] args){
		

		//1
		
		for (int i=1; i<=5; i++ ){
			for(int j=1; j<=i; j++){
				System.out.print("??");
			}
			System.out.println();
		}
		System.out.println("************************");

		//2
		for (int i=5; i>=1; i-- ){
			for(int j=1; j<=i; j++){
				System.out.print("??");
			}
			System.out.println();
		}
		System.out.println("************************");

		//3
		for (int i=1; i<=5; i++ ){
			for(int j=1; j<=6-i; j++){
				System.out.print("??");
			}
			for(int k=1; k<=i; k++){
				System.out.print("??");
			}
			System.out.println();
		}
		System.out.println("************************");





		//4
			for (int i=1; i<=5; i++ ){
			for(int j=1; j<=i; j++){
				System.out.print("??");
			}
			for(int k=1; k<=6-i; k++){
				System.out.print("??");
			}
			System.out.println();
		}
		System.out.println("************************");




	}



}