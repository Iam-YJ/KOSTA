package ex0820.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client or Server 가 상대측에게 데이터를 보내기(전송)
 *
 */

//Client는 Server 에게 , Server는 Client 에게 
public class SendThread extends Thread {
	Socket socket;
	String name;

	public SendThread(Socket socket, String name) {
		super(name); // Thread에 이름 설정
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {
			// 키보드 입력 받기
			Scanner sc = new Scanner(System.in);
			String data = null;
			while ((data = sc.nextLine()) != null) {
				pw.println(name + "가 보낸 내용 : " + data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
