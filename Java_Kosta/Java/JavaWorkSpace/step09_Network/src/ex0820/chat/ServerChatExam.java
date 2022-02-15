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
			System.out.println("Ŭ���̾�Ʈ ���� �����");
			sk = server.accept(); // ���� ���
			System.out.println(sk.getInetAddress()+"�԰� ä�� �����մϴ�.");

			// �б� Thread - �ޱ�
			new ReciveThread().start();

			// ���� Thread - ������
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
	 * Ŭ���̾�Ʈ�� �������� �����͸� �о ȭ�鿡 ����ϴ� ������
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

}// Ŭ���� ��
