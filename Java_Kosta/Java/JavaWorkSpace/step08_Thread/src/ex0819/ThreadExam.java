package ex0819;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println(" ***** ���� ���� ***** ");
		NumberThread th1 = new NumberThread("ù��° Thread");
		NumberThread th2 = new NumberThread("�ι�° Thread");

		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "����° Thread");

		// th1.run();
		
		th1.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
		th1.join(); //th1 �����尡 ���������� ������ ����� ���� ���Ѵ�. 
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("���� : "+ th1.sum);
		*/
		
		System.out.println(" ***** ���� �� ***** ");

	} // �� 4���� Thread (main�� Thread �̴�)

}

/////////////////////////////////////

/**
 * 1 ~ 100 ���� ����ϴ� ������
 */

class NumberThread extends Thread {
	int sum;

	public NumberThread(String name) {
		super(name);
	}

	/**
	 * Thread �� ������ ��� ����
	 */

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(super.getName() + " ==> " + i+  ", " +super.getPriority() );
			sum += i;
			/*try {
				Thread.sleep(100); //0.1 �� ���
			}catch (Exception e) {
				e.printStackTrace();
			}*/
			
			//Thread.yield();
		}
		System.out.println(super.getName() + " END ***** ");

	}

}

/*
 *  A ~ Z ���� ����ϴ� ������
 */
class AlphaThread implements Runnable {

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(th.getName() + " ==> " + ch +  ", " +th.getPriority() );
			/*try {
			Thread.sleep(100); //0.1 �� ���
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
			//Thread.yield();
		}
		System.out.println(th.getName() + " END ***** ");

	}

}