package ex0814.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam extends JFrame {
	JButton btn1 = new JButton("ù ��°");
	JButton btn2 = new JButton("�� ��°");
	
	public JFrameExam() {
		super("JFrameExam �Դϴ� ");
		
		
		//Container�� Layout�� �����ϱ� 
		super.setLayout(new FlowLayout());
		
		//Container ���� Component�� �߰��ϱ�
		super.add(btn1);
		super.add(btn2);
		
		//�ɼ�
		//â�� ��ġ�� ũ�� ���� 
		super.setSize(500,400);
		
		//��ġ �����ϱ�
		//super.setLocation(100,200);
		super.setLocationRelativeTo(null); //����� ���� (�� â�� ũ�Ⱑ ���� ��������. ��ũ�� ����� ���� �� ��� ��������)
		
		
		//â ������
		super.setVisible(true);
		
		//x�� Ŭ������ �� â�� ������ �ݱ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameExam();
	}

}
