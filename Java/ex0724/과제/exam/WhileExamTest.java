class WhileExamTest{

	public static void main(String [] args){
	
		iNumY = 1;
		while(iNumX <= 9) {
			iNumX=1;

			if(iNumX ==5 ) continue;{
				System.out.print(iNumY + "*" + iNumX+ "=" + (iNumX*iNumY) + "\t");
				iNumX ++;
			
			}System.out.println();
			iNumY++;

		
		}



		i = 1;
		do{
			int j = 2;
			do{
				if(j>5) break;
				System.out.print(j + "*" + i+ "=" + (j*i) + "\t");
				j ++;
			
			}while(j <=9);
			System.out.println();
			i++;
		
		}while(i<=9);

	
	
	}



}