package ex0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardExam {

	public KeyboardExam() throws Exception {
		// Ű���� �Է�
/*		InputStream is = System.in;
		int i = is.read(); // �ѹ���Ʈ �б�
		System.out.println(i + " = " + (char) i); */
		
		//byte ���� ó���� ���ڴ��� ���� 
		/* InputStreamReader isr = new InputStreamReader(System.in); //inputStream�� ���� ��Ʈ����. 
		int i = isr.read(); // �ѹ���Ʈ �б�
		System.out.println(i + " = " + (char) i); */
		
		//Buffered�� �̿��ؼ� �����б�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�Է� : ");
		String data = br.readLine();
		System.out.println("��� : "+data);
		

	}

	public static void main(String[] args) throws Exception {
		new KeyboardExam();

	}

}
