package ex0820;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	public ServerExam() {
		try (ServerSocket server = new ServerSocket(8000)) {
			while (true) {
				System.out.println("Client ���� ������Դϴ� ");
				Socket sk = server.accept(); // Ŭ���̾�Ʈ ���� ���
				System.out.println(sk.getInetAddress() + "�� ���ӵǾ����ϴ�. ");

				// Ŭ���̾�Ʈ�� ������ ������ �б�
				InputStream is = sk.getInputStream(); // byte ���� �б�
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String data = br.readLine();
				System.out.println("Ŭ���̾�Ʈ�� ������ ���� : " + data);

				// Ŭ���̾�Ʈ���� ������ ����
				OutputStream os = sk.getOutputStream(); // byte ���� ó��
				// byte ���� ó�� -> ���ڴ���ó�� ����, Buffered �̿�
				PrintWriter pw = new PrintWriter(os, true); // autoFlush �� ���� ���̵� �˾Ƽ� �� ����
				pw.println("Java ���� ���Ű� ȯ���մϴ�"); //ln�� �־�� Ŭ���̾�Ʈ ������ �����Ͱ� ������ 
				
				sk.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerExam();
	}

}
