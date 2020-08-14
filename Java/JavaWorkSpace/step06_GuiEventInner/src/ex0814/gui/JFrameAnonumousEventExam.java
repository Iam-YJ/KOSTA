package ex0814.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameAnonumousEventExam extends JFrame {
	JButton btn1 = new JButton("첫 번째");
	JButton btn2 = new JButton("두 번째");
	JTextField text = new JTextField(30); // (int columns) 는 길이지정

	public JFrameAnonumousEventExam() {
		super("JFrameExam 입니다 ");

		// Container의 Layout을 변경하기
		super.setLayout(new FlowLayout());

		// Container 위에 Component를 추가하기
		super.add(btn1);
		super.add(btn2);
		super.add(text);

		// 옵션
		// 창의 위치와 크기 설정
		super.setSize(500, 400);

		// 위치 조정하기
		// super.setLocation(100,200);
		super.setLocationRelativeTo(null); // 정가운데 놓기 (단 창의 크기가 먼저 정해져야. 스크린 사이즈에 맞춰 정 가운데 맞춰진다)

		// 창 보여줘
		super.setVisible(true);

		// x를 클릭했을 때 창을 완전히 닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트 등록 -> 이벤트주체.addXxxListener(구현객체);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("안녕!");

			}
		});
		
		

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		
		
		// MouseAdapter()는 여러개의 메소드가 있어서
		// 어떤 것을 재정의 할지 안정해줘서
		// 우리가 직접 만들어야한다.
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				JFrameAnonumousEventExam.this.setTitle("x = " + x + " y = " + y);
			}

		});

		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				char ch = e.getKeyChar();

				btn1.setText("code : " + code);
				btn2.setText("ch : " + ch);
			}

		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameAnonumousEventExam();
	}

} // Outer 클래스 끝

///////////////////////////////
