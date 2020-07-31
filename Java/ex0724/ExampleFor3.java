class ExampleFor3{

	public static void main(String [] args){
		for (int i=1; i<=5; i++ )
		{	if(i==3){
				break;
			}
			System.out.print(i+"\t");

		}

		System.out.println("\n-------------");

		for(int i=1; i<=3; i++){
			for(int j=1; j<=5; j++){
				if(j==3){
					continue;
				}
				System.out.print(j+"\t");

			}System.out.println();
		}
	}
}