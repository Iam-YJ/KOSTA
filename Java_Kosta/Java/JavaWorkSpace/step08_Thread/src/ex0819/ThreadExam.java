package ex0819;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println(" ***** 메인 시작 ***** ");
		NumberThread th1 = new NumberThread("첫번째 Thread");
		NumberThread th2 = new NumberThread("두번째 Thread");

		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "세번째 Thread");

		// th1.run();
		
		th1.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
		th1.join(); //th1 스레드가 끝날때까지 이하의 기능을 실행 안한다. 
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("총합 : "+ th1.sum);
		*/
		
		System.out.println(" ***** 메인 끝 ***** ");

	} // 총 4개의 Thread (main도 Thread 이다)

}

/////////////////////////////////////

/**
 * 1 ~ 100 까지 출력하는 스레드
 */

class NumberThread extends Thread {
	int sum;

	public NumberThread(String name) {
		super(name);
	}

	/**
	 * Thread 로 동작할 기능 구현
	 */

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(super.getName() + " ==> " + i+  ", " +super.getPriority() );
			sum += i;
			/*try {
				Thread.sleep(100); //0.1 초 대기
			}catch (Exception e) {
				e.printStackTrace();
			}*/
			
			//Thread.yield();
		}
		System.out.println(super.getName() + " END ***** ");

	}

}

/*
 *  A ~ Z 까지 출력하는 스레드
 */
class AlphaThread implements Runnable {

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(th.getName() + " ==> " + ch +  ", " +th.getPriority() );
			/*try {
			Thread.sleep(100); //0.1 초 대기
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
			//Thread.yield();
		}
		System.out.println(th.getName() + " END ***** ");

	}

}