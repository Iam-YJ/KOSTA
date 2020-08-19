package ex0819;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadTestExam extends JFrame {
	private JTextField text1 = new JTextField(5);
	private JTextField text2 = new JTextField(5);
	private JButton btn = new JButton("클릭");
	
	/**
	 * 화면구성하기
	 */
	public GUIThreadTestExam() {
		
		//레이아웃 변경
		super.setLayout(new FlowLayout());
		
		//Container 위에 컴포넌트 추가
		Container con = super.getContentPane();
		con.add(text1);
		con.add(text2);
		con.add(btn);
		
		
		//창의 크기
		super.setSize(500,400);
		//창의 위치
		super.setLocationRelativeTo(null); //null은 알아서 정 가운데 놔줌 
		
		//보여줘
		super.setVisible(true);
		
		//x를 클릭했을 때 종료
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//////////////////////////////////////
		//시계 Thread 생성
		new TimerThread(this).start();
		
		//숫자 넣기
		new DecimalThread().start();
		
		//버튼을 클릭하면 기능 실행
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//익명 구조임 
				new Thread() {
					@Override
					public void run() {
						for(char ch='A';  ch <= 'Z'; ch++) {
							text2.setText(ch + "");
							try {
								Thread.sleep(100);
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}.start(); //thread.start();
				
			}
		});
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIThreadTestExam();
	}//메인 끝
	
	
	class DecimalThread extends Thread{ //이너클래스임
		//그래서 text1 그냥 쓸 수 있음 
		@Override
		public void run() {
			for(int i=0; i<=1000; i++) {
				text1.setText(i+"");
				try {
					Thread.sleep((long)(Math.random()*200));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

//////////////////////////////////////////////////////////////////////////////

/**
 * JFrame 위에 시계를 동작시킬 thread
*/

class TimerThread extends Thread{
	GUIThreadTestExam gui;
	
	public TimerThread(GUIThreadTestExam gui) {
		this.gui = gui;
		
		
	}
	
	@Override
	public void run() {
		// 현재 날짜와 시간을 가져오기 
		while(true) {
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR); //년
			int m = now.get(Calendar.MONTH)+1; //월
			int d = now.get(Calendar.DATE); //일
			
			int h = now.get(Calendar.HOUR); //시
			int min = now.get(Calendar.MINUTE); //분
			int s = now.get(Calendar.SECOND); //초
			
			String time = y+"년 "+m+"월 "+d+"일 "+h+"시 "+min+"분 "+s+"초";
			gui.setTitle(time);
			
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

/////////////////////////////////////////////////////////////////////////////
