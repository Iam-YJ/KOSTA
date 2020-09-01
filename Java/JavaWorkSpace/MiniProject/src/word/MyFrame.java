package word;

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

public class MyFrame extends JFrame implements ActionListener {

	int screenWidth;
	int screenHeight;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel panel, panelInput, panelOutput, mainPanel, panelSubmit;
	JTextArea textOutputArea, textInputArea;
	ShortAnswer shortanswer;
	DB db;
	Set<Word> wordlist;
	JLabel word, mean;
	JTextField wordWord, meanMean;

	MyFrame() {
		this("박유진의 단어장");
	}

	public void init() {
		db = new DB();
		db.Run();
		wordlist = db.getWordlist();
		mainPanel = new JPanel();
		panel = new JPanel();
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

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(panel);
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

	MyFrame(String title) {
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

		Image img = kit.getImage("image/wordpic.JPG");
		this.setIconImage(img);
		// 저장한 이미지 불러오는 경로

		this.setVisible(true);
		this.shortanswer = new ShortAnswer(wordlist, this);
	}

	void find() {
		mainPanel = new JPanel();
		word = new JLabel("단어:");
		wordWord = new JTextField(10);
		mean = new JLabel("의미:");
		meanMean = new JTextField(10);
		wordWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					System.out.println(wordWord.getText());
					String answer = db.select(wordWord.getText());
					System.out.println(answer);
					if (answer.equals("")) {
						answer = "단어가 존재하지 않습니다.\n";
					}
					textOutputArea.append(answer);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		meanMean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					db.connectDB();
					db.registerWord(wordWord.getText(), meanMean.getText());
					db.readWord();
					wordlist = db.getWordlist();
					db.closeDB();
					textOutputArea.append("단어가 등록되었습니다 ==> " + wordWord.getText() + " : " + meanMean.getText());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mainPanel.add(word);
		mainPanel.add(wordWord);
		mainPanel.add(mean);
		mainPanel.add(meanMean);
		this.add(mainPanel, BorderLayout.SOUTH);
	}

//	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {

			String tmp = "";
			for (Word w : wordlist) {
				tmp += w.toString() + "\n";
			}

			textOutputArea.setText(tmp);

		} else if (e.getSource() == btn2) {

			String tmp = "";
			tmp = " ===== 영단어 퀴즈 ===== ";
			textOutputArea.append(tmp + "\n");
			tmp = " ==주관식 시험을 시작합니다==";
			textOutputArea.append(tmp + "\n");

			textOutputArea.append("hi2");
			
		} else if (e.getSource() == btn3) {
			String tmp = "자바 콘솔창에서 시험을 보세요\n";

			System.out.println("-----영단어 퀴즈-----");
			System.out.println(" 1. 주관식 / 2. 객관식 ");
			System.out.print("메뉴를 입력하세요 : ");
			System.out.println();

		} else if (e.getSource() == btn4) {
			String tmp = "추가할 단어를 입력하세요" + "\n" + "의미 입력 후 엔터\n";
			textOutputArea.setText(tmp);

		} else if (e.getSource() == btn5) {
			String tmp = "아래 단어창에서 검색하세요(한/영)" + "\n" + "검색 후 엔터\n";
			textOutputArea.setText(tmp);
		} else if (e.getSource() == btn6) {

		}

//		
	}

}
