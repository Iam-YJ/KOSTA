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
		
		//8 ��ü�׸���, ���
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
		
		
		//9 �ְ�����, ���
		boolean run = true;
		int studentNum = 0;
		int [] scores = null;
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		double sum = 0.0;
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1. �л��� | 2. �����Է� | 3. ��������Ʈ | 4. �м� | 5. ����");
			System.out.println("-------------------------");
			System.out.println("����> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				System.out.println("�л���> ");
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
				
				System.out.println("�ְ� ���� : "+max);
				
				for(int i=0; i<scores.length; i++) {
					sum += scores[i];
				}

				System.out.println("��� ���� : "+((double)sum/studentNum));
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}

}