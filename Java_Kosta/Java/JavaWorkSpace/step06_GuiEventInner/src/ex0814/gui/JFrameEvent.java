package ex0814.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameEvent extends JFrame implements ActionListener {
	JButton btn1 = new JButton("첫 번째");
	JButton btn2 = new JButton("두 번째");
	JTextField text = new JTextField(30); // (int columns) 는 길이지정

	public JFrameEvent() {
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
		btn1.addActionListener(this); // 버튼 1이 눌리면 actionPerformed 함수가 실행
		btn2.addActionListener(this); // 버튼 1이 눌리면 actionPerformed 함수가 실행

		this.addMouseListener(new MEventExam(text));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameEvent();
	}

	int i;

	@Override
	public void actionPerformed(ActionEvent e) {

		String label = e.getActionCommand(); // 버튼의 글씨 가져올 수 있음

		Object eventObj = e.getSource(); // 이벤트를 발생시킨 주체

		if (eventObj == btn1) {
			// text 박스 위에 "안녕" 출력
			text.setText(label + " 버튼 안녕" + i++);
		} else if (eventObj == btn2) {
			System.exit(0);
		}
	}

}

///////////////////////////////

/**
 * 마우스를 클릭했을 때 호출되는 메소드 정의
 */
class MEventExam extends MouseAdapter { // MouseAdapter를 상속받아서 필요한 메소드만 재정의하면 된다.
	JTextField text;

	MEventExam(JTextField text) {
		this.text = text;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 마우스 좌표 구하기
		int x = e.getX();
		int y = e.getY();
		
		text.setText("x =" +x +" y = "+y);
		
		//JFrame의 title에 글씨 올리기 

	}
}
