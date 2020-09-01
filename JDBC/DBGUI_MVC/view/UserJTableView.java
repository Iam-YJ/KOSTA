package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserJTableView  extends JFrame implements ActionListener{
	JMenu m = new JMenu("관리");
	JMenuItem  insert=new JMenuItem("가입");
	JMenuItem  update=new JMenuItem("수정");
	JMenuItem  delete=new JMenuItem("삭제");
	JMenuItem  quit=new JMenuItem("종료");
	JMenuBar mb=new JMenuBar();
		
	String [] name={"id","name","age","addr"};
	
	DefaultTableModel dt= new DefaultTableModel(name,0);
	JTable jt=new JTable(dt);
	JScrollPane jsp=new JScrollPane(jt);
	
	/*
		South 영역에 추가할 Componet들
	*/
	JPanel p= new JPanel();
	String [] comboName={"  ALL  ","  ID  "," name "," addr "};
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton serach = new JButton("검색");


	
/**
	화면구성 및 이벤트등록

*/
	public UserJTableView(){
		super("DB연동");
		
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(quit);
		mb.add(m);

		setJMenuBar(mb);
		
		//South영역
		
		p.setBackground(Color.yellow);
		p.add(combo);
		p.add(jtf);
		p.add(serach);

		add(jsp, "Center");
		add(p, "South");

		setSize(500,400);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}//생성자끝
	
	

    /**
     * 가입/수정/삭제/검색기능을 담당하는 메소드
     * */
		
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
