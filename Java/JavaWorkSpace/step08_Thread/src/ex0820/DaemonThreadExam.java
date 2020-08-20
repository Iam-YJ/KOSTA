package ex0820;

public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("*** 메인 시작입니다 ***");

		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("DaemonThread 입니다");
						Thread.sleep(200);
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		};

		th.setDaemon(true); //데몬스레드 됨(주 스레드가 종료되면 자동 종료된다)
		
		th.start();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*** 메인 끝 입니다 ***");

	}

}
