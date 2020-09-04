package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {

	int screenWidth;
	int screenHeight;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel panel1, panel2, panelInput, panelOutput, mainPanel, panelSubmit;
	JTextArea textOutputArea, textInputArea;
	JLabel word, mean;
	JTextField wordWord, meanMean;

	Frame() {
		this("잊혀질 단어장 ");
	}

	public void init() {
		mainPanel = new JPanel();
		panel1 = new JPanel();
		panelSubmit = new JPanel();

		btn1 = new JButton("단어장 보기");
		btn1.addActionListener(this);

		btn2 = new JButton("주관식 시험");
		btn2.addActionListener(this);

		btn3 = new JButton("객관식 시험");
		btn3.addActionListener(this);

		btn4 = new JButton("단어 추가");
		btn4.addActionListener(this);

		btn5 = new JButton("단어 탐색");
		btn5.addActionListener(this);

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		panel1.add(btn4);
		panel1.add(btn5);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(panel1);
		panelInput = new JPanel();
		panelOutput = new JPanel();
		textOutputArea = new JTextArea();
		textInputArea = new JTextArea();
		JScrollPane scrollPaneOutput = new JScrollPane(textOutputArea);
		scrollPaneOutput.setPreferredSize(new Dimension(screenWidth, screenHeight / 3));

		mainPanel.add(scrollPaneOutput);
		mainPanel.add(textInputArea);
		mainPanel.add(panelSubmit);

		Container container = this.getContentPane();
		container.add(mainPanel, BorderLayout.NORTH);

	}

	Frame(String title) {
		super(title);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.screenWidth = screenSize.width;
		this.screenHeight = screenSize.height;

		init();
		find();

		this.setSize(screenWidth / 2, screenHeight / 2);
		// 크기는 화면에 맞춰서 (1/2배)
		this.setLocation(screenWidth / 4, screenHeight / 4);
		// 위치는 화면에 맞춰서 (1/4 위치)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);

	}

	void find() {
		mainPanel = new JPanel();
		word = new JLabel("단어:");
		wordWord = new JTextField(10);
		mean = new JLabel("의미:");
		meanMean = new JTextField(10);


		mainPanel.add(word);
		mainPanel.add(wordWord);
		mainPanel.add(mean);
		mainPanel.add(meanMean);
		
		this.add(mainPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
