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

//클라이언트에서 액션이벤트와 connection이 계속 돌고
//back 에서는 while문이 왔다갔다 하는 것임 

public class ClientGUIChatExam extends JFrame {

	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea); // scrollPane에 textArea가 올라감
	JTextField text = new JTextField();

	Socket sk;
	BufferedReader br;
	PrintWriter pw;

	public ClientGUIChatExam() {
		// Container의 Layout 결정
		Container con = super.getContentPane();

		// 추가(올리기)
		con.add(jsp, BorderLayout.CENTER);
		con.add(text, BorderLayout.SOUTH);

		// 옵션설정
		textArea.setFocusable(false); // 커서 비활성화
		textArea.setBackground(Color.pink);
		text.requestFocus(); // 커서 놓기

		// 창크기
		super.setSize(400, 300);

		// 창위치
		super.setLocationRelativeTo(null);

		// 보여줘
		super.setVisible(true);

		// x 클릭했을 때 창닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 접속
		this.connection();
		
		//이벤트 (엔터치면 보내지기)
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력된 text 값을 읽어서 서버에서 전송한다.
				pw.println(text.getText());
			
				
				//text 내용 비우기
				text.setText("");
				
			}
		});
	}

	/**
	 * 서버에 접속하는 메소드
	 */
	public void connection() {
		try {
			sk = new Socket("192.168.0.136", 8000);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw = new PrintWriter(sk.getOutputStream(), true);

			String name = JOptionPane.showInputDialog("대화명을 입력해주세요");
			pw.println(name);

			super.setTitle("[" + name + "]");

			// 받는 스레드
			new Thread() {
				@Override
				public void run() {
					try {
						String data = null;
						while ((data = br.readLine()) != null) {
							textArea.append(data + "\n"); //setText가 아닌 이유는.. 글을 끝에만 추가하기 때문
						
							//옵션
							  textArea.setCaretPosition(textArea.getText().length());//스크롤의 위치 이동시킴 
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
