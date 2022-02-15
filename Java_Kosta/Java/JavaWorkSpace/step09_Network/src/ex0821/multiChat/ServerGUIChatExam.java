package ex0821.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//서버 : 연결하는 역할 

public class ServerGUIChatExam {
	ServerSocket server;
	Socket sk;
	List<ClientSocketThread> list = new ArrayList<ClientSocketThread>();

	public ServerGUIChatExam() {
		try {
			server = new ServerSocket(8000);
			while (true) {
				System.out.println("Client 접속 대기중입니다. ");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "님 접속되었습니다. ");

				ClientSocketThread th = new ClientSocketThread();
				list.add(th);
				th.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 생성자 끝

	/**
	 * 각각의 클라이언트에 대한 스레드 구현 : 현재 스레드의 클라이언트가 보내오는 데이터를 읽어서 
	 * 모든 클라이언트에게 데이터를 전송하는 기능 - run(); 에서
	 */
	class ClientSocketThread extends Thread {
		PrintWriter pw; // 접속된 클라이언트에게 데이터 보내기
		BufferedReader br; // 접속된 클라이언트가 보내온 데이터 읽기
		String name; // 대화명
		String ip;

		ClientSocketThread() {
			try {
				pw = new PrintWriter(sk.getOutputStream(), true); //true는 autoFlush 관련
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				ip = sk.getInetAddress().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				name = br.readLine(); // 대화명 받기
				sendMessage("[" + name + "] 님이 입장하셨습니다.");
				
				String message = null;
				while((message=br.readLine())!=null) {
					sendMessage("["+name+"] "+message);
				}
				
			} catch (Exception e) {
				//현재 클라이언트가 창을 닫고 나갔다.
				list.remove(this); //현재 객체가 소켓이 끊겨서 catch로 왔기 때문에 -> 현재 객체 제거하기
				sendMessage("[" + name + "] 님이 퇴장하셨습니다.");
				
				System.out.println("[" + name + "] 님이 퇴장하셨습니다.\n"); //서버에 보내는거
			}
		}// inner 클래스 끝

		/**
		 * list 안에 있는 모든 클라이언트에게 데이터 전송하기
		 */
		public void sendMessage(String message) {
			for (ClientSocketThread th : list) {
				th.pw.println(message);
			}
		}

	}

	public static void main(String[] args) {
		new ServerGUIChatExam();

	}
}// 클래스 끝
