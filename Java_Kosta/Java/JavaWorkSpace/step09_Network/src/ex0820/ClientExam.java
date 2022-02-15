package ex0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
	// ���� ip�� local host -> 127.0.0.1
	public ClientExam() {
		// ������ ����

		try (Socket sk = new Socket("192.168.0.180", 8000)) {
			// �������� ������ ������
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			pw.println("�۰���~��");

			// ������ ������ ���� �б�
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String message = br.readLine();
			System.out.println("������ ������ ���� : " + message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ClientExam();

	}

}
