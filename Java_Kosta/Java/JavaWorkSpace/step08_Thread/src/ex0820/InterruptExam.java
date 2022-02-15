package ex0820;

public class InterruptExam {

	public static void main(String[] args) {
		System.out.println("*** 메인 시작입니다 ***");

		// new Thread() {public void rub(){}}.start();

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					while (true) {
						System.out.println("Thread 재미있다.");
						Thread.sleep(100); // 0.1초
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		th.start();

		try {
			Thread.sleep(1000);// 5초
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5초 지난 후 스레드를 중지시키기
		th.interrupt();

		System.out.println("*** 메인 끝 입니다 ***");
	}

}
