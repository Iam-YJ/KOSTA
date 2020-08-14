package ex0814.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam extends JFrame {
	JButton btn1 = new JButton("첫 번째");
	JButton btn2 = new JButton("두 번째");
	
	public JFrameExam() {
		super("JFrameExam 입니다 ");
		
		
		//Container의 Layout을 변경하기 
		super.setLayout(new FlowLayout());
		
		//Container 위에 Component를 추가하기
		super.add(btn1);
		super.add(btn2);
		
		//옵션
		//창의 위치와 크기 설정 
		super.setSize(500,400);
		
		//위치 조정하기
		//super.setLocation(100,200);
		super.setLocationRelativeTo(null); //정가운데 놓기 (단 창의 크기가 먼저 정해져야. 스크린 사이즈에 맞춰 정 가운데 맞춰진다)
		
		
		//창 보여줘
		super.setVisible(true);
		
		//x를 클릭했을 때 창을 완전히 닫기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameExam();
	}

}
