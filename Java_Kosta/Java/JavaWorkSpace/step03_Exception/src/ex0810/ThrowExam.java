package ex0810;

import java.io.IOException;

/*
 * ������ ����
 * 1) üũ Exception : �ݵ�� ����ó�� �ʼ�
 * 2) ��üũ Exception : ���൵�� �߻��ϹǷ� ����ó�� ���� 
 * */

class Adult {
	public void setAge(int age) {
		// ���� ���
		if (age < 18) {
			try {
				// ���ܹ߻���Ų��
				throw new IOException(
						"���̴� 18���� ū ���� �Է��ϼ���`````````																																																						```````````````````````````````																																																																																																										`````````````````````````````````````````````````````````````````````````````````````````````````````````````````																																																																														`																																																																																																																																																									```````````````````````````````````````````````````````````````````````																															"); // ����ó��
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								// �ʼ�
				// throw new RuntimeException(); // ����ó�� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThrowExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** ���� ���� *****");
		Adult ad = new Adult();
		ad.setAge(10);
		System.out.println("***** ���� �� *****");

	}

}
