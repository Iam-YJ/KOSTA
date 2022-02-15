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
	JButton btn1 = new JButton("ù ��°");
	JButton btn2 = new JButton("�� ��°");
	JTextField text = new JTextField(30); // (int columns) �� ��������

	public JFrameEvent() {
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
		btn1.addActionListener(this); // ��ư 1�� ������ actionPerformed �Լ��� ����
		btn2.addActionListener(this); // ��ư 1�� ������ actionPerformed �Լ��� ����

		this.addMouseListener(new MEventExam(text));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrameEvent();
	}

	int i;

	@Override
	public void actionPerformed(ActionEvent e) {

		String label = e.getActionCommand(); // ��ư�� �۾� ������ �� ����

		Object eventObj = e.getSource(); // �̺�Ʈ�� �߻���Ų ��ü

		if (eventObj == btn1) {
			// text �ڽ� ���� "�ȳ�" ���
			text.setText(label + " ��ư �ȳ�" + i++);
		} else if (eventObj == btn2) {
			System.exit(0);
		}
	}

}

///////////////////////////////

/**
 * ���콺�� Ŭ������ �� ȣ��Ǵ� �޼ҵ� ����
 */
class MEventExam extends MouseAdapter { // MouseAdapter�� ��ӹ޾Ƽ� �ʿ��� �޼ҵ常 �������ϸ� �ȴ�.
	JTextField text;

	MEventExam(JTextField text) {
		this.text = text;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// ���콺 ��ǥ ���ϱ�
		int x = e.getX();
		int y = e.getY();
		
		text.setText("x =" +x +" y = "+y);
		
		//JFrame�� title�� �۾� �ø��� 

	}
}
