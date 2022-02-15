import java.util.Scanner;

class MainApp{
	public static void main(String [] args){
		

		Scanner scan = new Scanner(System.in);
		Score se = new Score();

		boolean menu = true;
		
		while(true){
			System.out.println("=====메뉴 선택======");
			System.out.println("1. 성적표 구하기	2. 종료하기");
			System.out.println("====================");

			System.out.print("선택 > ");
			int menu = scan.nextInt();
			
			switch(menu){
				case 1 :
					System.out.println("이름은 ? ");
					String name = scan.next();
					System.out.println("국어점수 ? ");
					int kor = scan.nextInt();
					System.out.println("수학점수 ? ");
					int math = scan.nextInt();
					System.out.println("영어점수 ? ");
					int eng = scan.nextInt();
					
					se.print(name, kor, eng, math);

					break;

				case 2 :
					System.out.println("프로그램 종료합니다");
					System.exit(0);
					break;

				default:
					System.out.println("메뉴는 1~2만 가능합니다");
			
			}
		}

		
	
		
	}
}