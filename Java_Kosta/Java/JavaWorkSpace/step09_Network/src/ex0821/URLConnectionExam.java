package ex0821;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class URLConnectionExam {

	public URLConnectionExam() {

		try {
		/*	URL url = new URL("https://www.daum.net/");
			
			InputStream is = url.openStream(); // �����ѰŸ� ��������(�д�) openStream()
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0821/daum.txt"));
			String data = null;
			while((data=br.readLine())!=null) {//readLine�� �������� ������ null ��ȯ�� 
				System.out.println(data);
				bw.write(data);
				bw.newLine();
			} */ //�뷮�� ���̰� ����. �������� �ִ� newLine() ������
			
			
			/*
			URL url = new URL("https://192.168.0.136/Edu/SW/epp351.exe");
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src/ex0821/daum.txt"));
			
			//byte b [] = new byte[bis.available()]; //bis�� ���̸�ŭ 
			
			byte b [] = new byte[1024]; //byte ������ �ʰ��ϸ�(1024) �ٿ�޾����� �ʾƼ� while������ ��� ���� ����
		
			bis.read(b);
			
			while(bis.read()!= -1) {
				bw.write(b);
				bw.flush();
			} */
			//�뷮�� �� �°� �ϴ� �ڵ� + �ٿ�ε� �ϴ� �ڵ�
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLConnectionExam();

	}

}
