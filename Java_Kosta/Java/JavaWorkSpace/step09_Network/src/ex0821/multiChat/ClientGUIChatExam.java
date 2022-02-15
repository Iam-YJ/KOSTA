package ex0821.multiChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Ŭ���̾�Ʈ���� �׼��̺�Ʈ�� connection�� ��� ����
//back ������ while���� �Դٰ��� �ϴ� ���� 

public class ClientGUIChatExam extends JFrame {

	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea); // scrollPane�� textArea�� �ö�
	JTextField text = new JTextField();

	Socket sk;
	BufferedReader br;
	PrintWriter pw;

	public ClientGUIChatExam() {
		// Container�� Layout ����
		Container con = super.getContentPane();

		// �߰�(�ø���)
		con.add(jsp, BorderLayout.CENTER);
		con.add(text, BorderLayout.SOUTH);

		// �ɼǼ���
		textArea.setFocusable(false); // Ŀ�� ��Ȱ��ȭ
		textArea.setBackground(Color.pink);
		text.requestFocus(); // Ŀ�� ����

		// âũ��
		super.setSize(400, 300);

		// â��ġ
		super.setLocationRelativeTo(null);

		// ������
		super.setVisible(true);

		// x Ŭ������ �� â�ݱ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����
		this.connection();
		
		//�̺�Ʈ (����ġ�� ��������)
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�Էµ� text ���� �о �������� �����Ѵ�.
				pw.println(text.getText());
			
				
				//text ���� ����
				text.setText("");
				
			}
		});
	}

	/**
	 * ������ �����ϴ� �޼ҵ�
	 */
	public void connection() {
		try {
			sk = new Socket("192.168.0.136", 8000);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw = new PrintWriter(sk.getOutputStream(), true);

			String name = JOptionPane.showInputDialog("��ȭ���� �Է����ּ���");
			pw.println(name);

			super.setTitle("[" + name + "]");

			// �޴� ������
			new Thread() {
				@Override
				public void run() {
					try {
						String data = null;
						while ((data = br.readLine()) != null) {
							textArea.append(data + "\n"); //setText�� �ƴ� ������.. ���� ������ �߰��ϱ� ����
						
							//�ɼ�
							  textArea.setCaretPosition(textArea.getText().length());//��ũ���� ��ġ �̵���Ŵ 
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientGUIChatExam();

	}

}
