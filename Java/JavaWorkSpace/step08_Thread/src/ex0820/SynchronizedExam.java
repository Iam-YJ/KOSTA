package ex0820;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("*** 메인 시작 ***");

		Bank bank = new Bank();

		CustomerThread th1 = new CustomerThread(bank, "생산자", true);
		CustomerThread th2 = new CustomerThread(bank, "소비자", false);
		// 같은 bank(주소)를 참조함. 공유함.

		th1.start();
		th2.start();

		System.out.println("*** 메인 끝 ***");

	}

}

/////////////////////////////////////////////
/**
 * 여러 스레드가 공유할 객체
 */
class Bank {
	int balance;

	/**
	 * 잔액을 (입금, 출금) 변경하는 메소드
	 * 
	 * @param : String은 입금자 or 출금자// state는 true이면 생산(입금), false이면 소비(출금)
	 * 
	 *          :synchronized 블럭안에서 사용할 수 있는 메소드 wait(); - 현재 스레드를 중지상태로 만듦
	 *          notify(); - wait()에 의해 중지상태인 스레드 중에 우선순위 높은 스레드 깨워서 대기상태로 만듦
	 *          notifyAll(); - wait()에 의해 중지상태인 모든 스레드 깨워서 대기상태로 만듦
	 *          
	 *          * 반드시 synchronized 블럭 안에서 wait(), notify() 사용할 수 있다.
	 *          아니면 java.lang.IllegalMonitorStateException 예외 발생함 
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if (state) { // 생산 - 입금
//			//synchronized (this) { // this는 공유객체를 뜻함. (bank)
//				System.out.print(name + "==> 현재잔액 : " + balance + ", ");
//				balance++;
//				System.out.println(name + "==> 증가 후 잔액 : " + balance);
//			//}

			if (balance == 0) {
				System.out.print(name + "==> 현재잔액 : " + balance + ", ");
				balance++;
				System.out.println(name + "==> 증가 후 잔액 : " + balance);
			} else {
				System.out.println(name + "대기중 입니다.");
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
                               
		} else { // 소비 - 출금
			if (balance > 0) {
				System.out.print(name + "==> 현재잔액 : " + balance + ", ");
				balance--;
				System.out.println(name + "==> 감소 후 잔액 : " + balance);
			} else {
				System.out.println(name + "대기중 입니다.");
				try {
					wait();
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		notifyAll();
	} // 메소드 끝

} // 클래스끝
////////////////////////////////////////////

class CustomerThread extends Thread {
	Bank bank; // 뱅크타입 1개 - 동일한 뱅크를 이용하기 위함
	// customer는 여러개 - 여러명이 customer 이용함
	String name;
	boolean state;

	CustomerThread(Bank bank, String name, boolean state) { // customer thread 만들 때 누구, boolean도 결정나야한다.
		super(name); // thread의 이름 세팅
		this.bank = bank;
		this.name = name;
		this.state = state;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(super.getName() + " Thread 종료 ***");
	}
}