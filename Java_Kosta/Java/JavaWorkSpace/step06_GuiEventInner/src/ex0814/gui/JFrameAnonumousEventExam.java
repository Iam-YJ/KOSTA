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
	JButton btn1 = new JButton("ù ��°");
	JButton btn2 = new JButton("�� ��°");
	JTextField text = new JTextField(30); // (int columns) �� ��������

	public JFrameAnonumousEventExam() {
		super("JFrameExam �Դϴ� ");

		// Container�� Layout�� �����ϱ�
		super.setLayout(new FlowLayout());

		// Container ���� Component�� �߰��ϱ�
		super.add(btn1);
		super.add(btn2);
		super.add(text);

		// �ɼ�
		// â�� ��ġ�� ũ�� ����
		super.setSize(500, 400);

		// ��ġ �����ϱ�
		// super.setLocation(100,200);
		super.setLocationRelativeTo(null); // ����� ���� (�� â�� ũ�Ⱑ ���� ��������. ��ũ�� ����� ���� �� ��� ��������)

		// â ������
		super.setVisible(true);

		// x�� Ŭ������ �� â�� ������ �ݱ�
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �̺�Ʈ ��� -> �̺�Ʈ��ü.addXxxListener(������ü);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("�ȳ�!");

			}
		});
		
		

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		
		
		// MouseAdapter()�� �������� �޼ҵ尡 �־
		// � ���� ������ ���� �������༭
		// �츮�� ���� �������Ѵ�.
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

} // Outer Ŭ���� ��

///////////////////////////////
