package ex0820;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("*** ���� ���� ***");

		Bank bank = new Bank();

		CustomerThread th1 = new CustomerThread(bank, "������", true);
		CustomerThread th2 = new CustomerThread(bank, "�Һ���", false);
		// ���� bank(�ּ�)�� ������. ������.

		th1.start();
		th2.start();

		System.out.println("*** ���� �� ***");

	}

}

/////////////////////////////////////////////
/**
 * ���� �����尡 ������ ��ü
 */
class Bank {
	int balance;

	/**
	 * �ܾ��� (�Ա�, ���) �����ϴ� �޼ҵ�
	 * 
	 * @param : String�� �Ա��� or �����// state�� true�̸� ����(�Ա�), false�̸� �Һ�(���)
	 * 
	 *          :synchronized ���ȿ��� ����� �� �ִ� �޼ҵ� wait(); - ���� �����带 �������·� ����
	 *          notify(); - wait()�� ���� ���������� ������ �߿� �켱���� ���� ������ ������ �����·� ����
	 *          notifyAll(); - wait()�� ���� ���������� ��� ������ ������ �����·� ����
	 *          
	 *          * �ݵ�� synchronized �� �ȿ��� wait(), notify() ����� �� �ִ�.
	 *          �ƴϸ� java.lang.IllegalMonitorStateException ���� �߻��� 
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if (state) { // ���� - �Ա�
//			//synchronized (this) { // this�� ������ü�� ����. (bank)
//				System.out.print(name + "==> �����ܾ� : " + balance + ", ");
//				balance++;
//				System.out.println(name + "==> ���� �� �ܾ� : " + balance);
//			//}

			if (balance == 0) {
				System.out.print(name + "==> �����ܾ� : " + balance + ", ");
				balance++;
				System.out.println(name + "==> ���� �� �ܾ� : " + balance);
			} else {
				System.out.println(name + "����� �Դϴ�.");
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
                               
		} else { // �Һ� - ���
			if (balance > 0) {
				System.out.print(name + "==> �����ܾ� : " + balance + ", ");
				balance--;
				System.out.println(name + "==> ���� �� �ܾ� : " + balance);
			} else {
				System.out.println(name + "����� �Դϴ�.");
				try {
					wait();
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		notifyAll();
	} // �޼ҵ� ��

} // Ŭ������
////////////////////////////////////////////

class CustomerThread extends Thread {
	Bank bank; // ��ũŸ�� 1�� - ������ ��ũ�� �̿��ϱ� ����
	// customer�� ������ - �������� customer �̿���
	String name;
	boolean state;

	CustomerThread(Bank bank, String name, boolean state) { // customer thread ���� �� ����, boolean�� ���������Ѵ�.
		super(name); // thread�� �̸� ����
		this.bank = bank;
		this.name = name;
		this.state = state;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(super.getName() + " Thread ���� ***");
	}
}