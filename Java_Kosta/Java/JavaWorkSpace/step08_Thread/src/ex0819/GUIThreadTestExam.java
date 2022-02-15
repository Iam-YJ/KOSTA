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
	private JButton btn = new JButton("Ŭ��");
	
	/**
	 * ȭ�鱸���ϱ�
	 */
	public GUIThreadTestExam() {
		
		//���̾ƿ� ����
		super.setLayout(new FlowLayout());
		
		//Container ���� ������Ʈ �߰�
		Container con = super.getContentPane();
		con.add(text1);
		con.add(text2);
		con.add(btn);
		
		
		//â�� ũ��
		super.setSize(500,400);
		//â�� ��ġ
		super.setLocationRelativeTo(null); //null�� �˾Ƽ� �� ��� ���� 
		
		//������
		super.setVisible(true);
		
		//x�� Ŭ������ �� ����
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//////////////////////////////////////
		//�ð� Thread ����
		new TimerThread(this).start();
		
		//���� �ֱ�
		new DecimalThread().start();
		
		//��ư�� Ŭ���ϸ� ��� ����
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�͸� ������ 
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
				}.start(); //thread(){}.start();
				
			}
		});
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIThreadTestExam();
	}//���� ��
	
	
	class DecimalThread extends Thread{ //�̳�Ŭ������
		//�׷��� text1 �׳� �� �� ���� 
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
 * JFrame ���� �ð踦 ���۽�ų thread
*/

class TimerThread extends Thread{
	GUIThreadTestExam gui;
	
	public TimerThread(GUIThreadTestExam gui) {
		this.gui = gui;
		
		
	}
	
	@Override
	public void run() {
		// ���� ��¥�� �ð��� �������� 
		while(true) {
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR); //��
			int m = now.get(Calendar.MONTH)+1; //��
			int d = now.get(Calendar.DATE); //��
			
			int h = now.get(Calendar.HOUR); //��
			int min = now.get(Calendar.MINUTE); //��
			int s = now.get(Calendar.SECOND); //��
			
			String time = y+"�� "+m+"�� "+d+"�� "+h+"�� "+min+"�� "+s+"��";
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
