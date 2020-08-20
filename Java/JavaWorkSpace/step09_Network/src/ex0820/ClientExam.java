package ex0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
	// 본인 ip는 local host -> 127.0.0.1
	public ClientExam() {
		// 서버에 접속

		try (Socket sk = new Socket("192.168.0.180", 8000)) {
			// 서버에게 데이터 보내기
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			pw.println("퍼가요~♡");

			// 서버가 보내온 내용 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String message = br.readLine();
			System.out.println("서버가 보내온 내용 : " + message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClientExam();

	}

}
