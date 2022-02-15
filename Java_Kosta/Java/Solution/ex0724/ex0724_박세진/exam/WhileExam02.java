public class WhileExam02
{
	public static void main(String[] args)
	{
		System.out.println("1. 1~100까지 10행 10열로 출력 (다중 While문 사용)");
		int iNumX = 0, iNumY = 0, iNum = 0;
		while(iNumY++ < 10)
		{
			iNumX = 0;
			while(iNumX++ < 10){
				System.out.print( ++iNum + "\t");
			}
			System.out.println();
		}

		System.out.println("1. 1~100까지 10행 10열로 출력 (다중 While문 사용)");
		 iNumX = 0 ; iNumY = 0;
		while(iNumY < 100) //10행
		{
			iNumX = 0;
			while(iNumX++ < 10){//10열
				System.out.print( (iNumX+iNumY)+ "\t");
			}

			iNumY+=10;
			System.out.println();
		}

       /**
	     구구단 for문
	   */
	   System.out.println("\n------------------------------");
	   for(int row=1; row<=9 ; row++){//9행
           for(int col=2; col<=9 ; col++){//8열
              System.out.print(col+"*"+row+"="+(col*row)+"\t");
		   }
		   System.out.println();
	   }


      System.out.println("\n------------------------------");

		System.out.println("\n\n2. 구구단 출력");
		iNumY = 1;//행
		while(iNumY <= 9)
		{
			iNumX = 2;//열
			while(iNumX <= 9){
				System.out.print(iNumX + "x" + iNumY + "=" + (iNumX*iNumY) + "\t");
				iNumX++;
			}
            iNumY++;
			System.out.println();
		}



		System.out.println("\n\n2. 구구단 출력 - 5단 빼고.....");
		iNumY = 1;//행
		while(iNumY <= 9)
		{
			iNumX = 1;//열
			while(iNumX <= 9){
				iNumX++;

				if(iNumX==5)continue;
				 System.out.print(iNumX + "x" + iNumY + "=" + (iNumX*iNumY) + "\t");
				 
			}
            iNumY++;
			System.out.println();
		}


	}
}