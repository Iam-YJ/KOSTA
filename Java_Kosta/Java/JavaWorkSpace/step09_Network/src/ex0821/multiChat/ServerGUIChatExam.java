package ex0821.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//���� : �����ϴ� ���� 

public class ServerGUIChatExam {
	ServerSocket server;
	Socket sk;
	List<ClientSocketThread> list = new ArrayList<ClientSocketThread>();

	public ServerGUIChatExam() {
		try {
			server = new ServerSocket(8000);
			while (true) {
				System.out.println("Client ���� ������Դϴ�. ");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "�� ���ӵǾ����ϴ�. ");

				ClientSocketThread th = new ClientSocketThread();
				list.add(th);
				th.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // ������ ��

	/**
	 * ������ Ŭ���̾�Ʈ�� ���� ������ ���� : ���� �������� Ŭ���̾�Ʈ�� �������� �����͸� �о 
	 * ��� Ŭ���̾�Ʈ���� �����͸� �����ϴ� ��� - run(); ����
	 */
	class ClientSocketThread extends Thread {
		PrintWriter pw; // ���ӵ� Ŭ���̾�Ʈ���� ������ ������
		BufferedReader br; // ���ӵ� Ŭ���̾�Ʈ�� ������ ������ �б�
		String name; // ��ȭ��
		String ip;

		ClientSocketThread() {
			try {
				pw = new PrintWriter(sk.getOutputStream(), true); //true�� autoFlush ����
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				ip = sk.getInetAddress().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				name = br.readLine(); // ��ȭ�� �ޱ�
				sendMessage("[" + name + "] ���� �����ϼ̽��ϴ�.");
				
				String message = null;
				while((message=br.readLine())!=null) {
					sendMessage("["+name+"] "+message);
				}
				
			} catch (Exception e) {
				//���� Ŭ���̾�Ʈ�� â�� �ݰ� ������.
				list.remove(this); //���� ��ü�� ������ ���ܼ� catch�� �Ա� ������ -> ���� ��ü �����ϱ�
				sendMessage("[" + name + "] ���� �����ϼ̽��ϴ�.");
				
				System.out.println("[" + name + "] ���� �����ϼ̽��ϴ�.\n"); //������ �����°�
			}
		}// inner Ŭ���� ��

		/**
		 * list �ȿ� �ִ� ��� Ŭ���̾�Ʈ���� ������ �����ϱ�
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
}// Ŭ���� ��
