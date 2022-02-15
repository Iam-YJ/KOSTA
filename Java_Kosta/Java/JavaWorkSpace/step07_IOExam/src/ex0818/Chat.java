package ex0818;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Chat {

	public Chat() {
		
		BufferedReader br = null;
		BufferedWriter bw = null;

		boolean flag = true;

		try {

			// Buffered�� �̿��ؼ� �����б�
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new FileWriter("src/ex0818/chat.txt"));
			
			while (flag) {

				System.out.print("�Է� : ");
				String data = br.readLine();
				
				if (!data.equals("exit")) {
					System.out.println("��� : " + data);
					bw.write(data);
					bw.newLine();

				} else if (data.equals("exit")) {
					System.out.println("���α׷� ���� ~");
					flag = false;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Chat();

	}

}
