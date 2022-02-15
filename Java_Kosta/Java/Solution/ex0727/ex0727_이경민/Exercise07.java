import java.util.Scanner;//내가 사용하려는 클래스가 어떤 폴더(package)에 있는지 선언.

public class Exercise07{
	public static void main(String [] ags){
		boolean run =true;

		int balance =0;
		//키보드 입력받기 위한 준비
		Scanner sc = new Scanner(System.in);//메소드 선언

		while(run){
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			int no = sc.nextInt();
			if(no==1){
			System.out.print("예금액> ");
			int inp = sc.nextInt();
			}else if(no==2){
			System.out.print("출금액> ");
			int oup = sc.nextInt();
			}else if(no==3){
			System.out.print("잔고> ");
			int bal = sc.nextInt();
			}else break;
		}

		System.out.println("프로그램 종료");
/*
제가원하는 그림은 3번 선택하고 잔고 뜨면 바로 예금액 출금액을 미리 넣었다면 그거 계산해주길 바라는데 
변수 선언하고 inp-oup을 잔고 옆에다 추가 하니까 컴파일에 실패하네요 원인을 알고싶습니다.
*/
	}
}