package ex0820.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sk;
	ServerSocket server;

	public ServerChatExam() {
		try {
			server = new ServerSocket(8888); 
			System.out.println("클라이언트 접속 대기중");
			sk = server.accept(); // 접속 대기
			System.out.println(sk.getInetAddress()+"님과 채팅 시작합니다.");

			// 읽기 Thread - 받기
			new ReciveThread().start();

			// 쓰기 Thread - 보내기
			new SendThread(sk, "SERVER").start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerChatExam();
	}

	/**
	 * 클라이언트가 보낸오는 데이터를 읽어서 화면에 출력하는 스레드
	 */
	class ReciveThread extends Thread {
		@Override
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))) {
				String message = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}// 클래스 끝
