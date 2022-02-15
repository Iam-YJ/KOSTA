package ex0811;

import java.util.ArrayList;
import java.util.List;

class Test {
	int a = 100;

	public void aa() {

	}

	/*
	 * @Override public String toString() { return a; }
	 */

}

class ArrayListExam extends ArrayList {

	// ���� Variable
	// Object Ÿ��1��, int Ÿ�� 1��;
	Object o;
	int i;

	// Constractor
	public ArrayListExam() {
		super(5);
		// ArrayList�� int�� �Ѱ� �޴� ������ ȣ��
		// �ʱ� �뷮 5�� ����
	}

	// method
	// method�̸� ����Ÿ�� �μ�

	/*
	 * addInt ���� ����(int)1�� �ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.
	 */
	public void addInt(int i) {
		Integer ii = new Integer(i);
		// int -> Integer ��ü�� ��ȯ
		super.add(ii);
		// list�� �����Ѵ�.
	}

	/*
	 * addFloat ���� �Ǽ�(float)1�� �ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.
	 */

	public void addFloat(float f) {
		Float ff = new Float(f);
		this.add(ff);
	}

	/*
	 * addString ���� String ���ڿ�1�� �ϴ��� : �μ��� ���� String �� list�� �߰�.
	 */

	public void addString(String s) {
		super.add(s);
		// String�� ���� ��ü�̴�
	}

	/*
	 * printList ���� ���� ������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� ��(size())�������� ���. List��
	 * ����� �� ��ü�� �ɹ������� �������� ���
	 */

	public void printList() {
		this.i = this.size();
		System.out.println("����� ��ü�� �� : " + i);

		for (int i = 0; i < this.i; i++) {
			this.o = this.get(i);
			System.out.println("����� ��ü : " + o);
			// ���� ����� ���� �ƴ϶� �ּҰ� ����� ���̴�.
			// o.toString()�� �����Ǿ� �ִ� ���̴�.
		}

		System.out.println("----------");
		this.o = super.get(2); // Test ��ü
		// o.a; //�θ�Ÿ������ �ڽĺκ� ���� �Ұ�

		System.out.println("obj �ּ� : " + o);
		if (o instanceof Test) {
			Test t = (Test) o;
			System.out.println("t �ּ� : " + t);
			System.out.println(t.a);
		}
		
		System.out.println("-------������ for-----");
		for(Object o : this) { 
			//this�� ����� �޾ұ� ������ ����� �� ����
			//���� �� List �̱� ������
			System.out.println(o);
		}
	}

	public static void main(String args[]) {
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

//Integer it2 = 10; //����ڽ�
//int a = new Integer(5); //��ڽ�



/*
 * ������
 * 
 * list�� ����ִ� ��ü�� �� ������=3 5 5.5 newString
 * 
 * Normal Termination ��� �Ϸ� (0�� ���).
 */