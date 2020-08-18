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

			// Buffered를 이용해서 한줄읽기
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new FileWriter("src/ex0818/chat.txt"));
			
			while (flag) {

				System.out.print("입력 : ");
				String data = br.readLine();
				
				if (!data.equals("exit")) {
					System.out.println("출력 : " + data);
					bw.write(data);
					bw.newLine();

				} else if (data.equals("exit")) {
					System.out.println("프로그램 종료 ~");
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
