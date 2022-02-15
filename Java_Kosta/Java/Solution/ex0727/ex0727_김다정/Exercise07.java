/*본인이름:김다정
  날짜: 20.07.27
  주제 : 이것이 자바다 7번 과제  */
import java.util.Scanner;

public class Exercise07{
	public static void main(String [] args){
		boolean run = true;
		//잔액
		int balance = 0;
		
		Scanner sc = new Scanner(System.in);

		while(run){
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			
			int menu = sc.nextInt();// 1 2 3 4
			//select 값으로 1이 들어오면 예금액 입력값을 변수 deposit에 저장
			switch(menu){
				case 1 : 
					System.out.print("예금액>");
					balance += sc.nextInt();
					break;
				case 2 : 
					System.out.print("출금액>");
					balance -= sc.nextInt();
					break;
				case 3 : 
					 System.out.println("잔고>" + balance );
					break;
				case 4 : 
					System.out.println("프로그램 종료");
					System.exit(0);//프로그램 종료
				default : 
					System.out.println("메뉴는 1 ~ 4 사이만 입력해주세요^^");
			}//switch문끝

	  }//while문끝
	  
	
  }//메인메소드끝
}//클래스끝