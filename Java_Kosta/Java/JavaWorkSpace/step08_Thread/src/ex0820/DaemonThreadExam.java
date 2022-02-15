package ex0820;

public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("*** ���� �����Դϴ� ***");

		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("DaemonThread �Դϴ�");
						Thread.sleep(200);
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		};

		th.setDaemon(true); //���󽺷��� ��(�� �����尡 ����Ǹ� �ڵ� ����ȴ�)
		
		th.start();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*** ���� �� �Դϴ� ***");

	}

}
