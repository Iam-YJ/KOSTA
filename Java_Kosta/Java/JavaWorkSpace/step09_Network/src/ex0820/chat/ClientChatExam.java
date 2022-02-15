package ex0820.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	Socket sk;

	public ClientChatExam() {
		try {
			sk = new Socket("192.168.0.115",8888);		
			System.out.println("������ ä�� ��������");
			// �б� ������
			new Thread(new Runnable() {
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
			}).start();

			// ������ ������
			new SendThread(sk, "CLIENT").start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientChatExam();
	}

}
