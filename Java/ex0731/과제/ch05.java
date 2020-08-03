import java.util.Scanner;

class ch05 {

	public static void main(String[] args) {

		// 6
		// array.length = 3
		// array[2].length = 5

		
		// 7
		/* int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };

		for (int i = 0; i < array.length; i++) {
			max = array[0];
			if (max < array[i]) {
				max = array[i];
				i++;
			}
		}
		System.out.println("max: " + max);
		System.out.println();
		*/
		
		//8 전체항목합, 평균
		/* int [][] array2 = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		
		for(int i=0; i<array2.length; i++) {
			for(int j =0; j<array2[i].length; j++) {
				sum += array2[i][j];
				count ++;
			}
		}
		
		avg = sum/count;

		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		*/
		
		
		//9 최고점수, 평균
		boolean run = true;
		int studentNum = 0;
		int [] scores = null;
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		double sum = 0.0;
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------------");
			System.out.println("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				System.out.println("학생수> ");
				studentNum = scanner.nextInt();
				scores = new int [studentNum];
				
			}else if(selectNo == 2) {
				
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores["+i+"] >");
					scores[i] = scanner.nextInt();
				}
				
			}else if(selectNo == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores["+i+"]:"+scores[i]);
				}
			}else if(selectNo == 4) {
				for(int i=0; i<scores.length; i++) {
					max = scores[0];
					if(max < scores[i]) {
						max = scores[i];
						i++;
					}
				}
				
				System.out.println("최고 점수 : "+max);
				
				for(int i=0; i<scores.length; i++) {
					sum += scores[i];
				}

				System.out.println("평균 점수 : "+((double)sum/studentNum));
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}