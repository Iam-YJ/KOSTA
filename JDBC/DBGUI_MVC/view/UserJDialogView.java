package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserJDialogView extends JDialog implements ActionListener{
	JPanel pw=new JPanel(new GridLayout(4,1));
	JPanel pc=new JPanel(new GridLayout(4,1));
	JPanel ps=new JPanel();

	JLabel lableId = new JLabel("ID");
	JLabel lableName=new JLabel("이름");
	JLabel lableAge=new JLabel("나이");
	JLabel lableAddr=new JLabel("주소");


	JTextField id=new JTextField();
	JTextField name=new JTextField();
	JTextField age=new JTextField();
	JTextField addr=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("취소");

   UserJTableView userJTableView;

   JPanel idCkP =new JPanel(new BorderLayout());
   JButton idCkBtn = new JButton("IDCheck");
   
  
   

	public UserJDialogView(UserJTableView userJTableView, String index){
		super(userJTableView,"다이어로그");
		
		this.userJTableView=userJTableView;
		
		if(index.equals("가입")){
			confirm=new JButton(index);
		}else{
			confirm=new JButton("수정");	
			
			
			
			//id text박스 비활성
			id.setEditable(false);
	
			//IDCheck버튼 비활성화
			idCkBtn.setEnabled(false);
		}
		
		
		//Label추가부분
		pw.add(lableId);//ID
		pw.add(lableName);//이름
		pw.add(lableAge);//나이
		pw.add(lableAddr);//주소
	
		
		idCkP.add(id,"Center");
		idCkP.add(idCkBtn,"East");
		
		//TextField 추가
		pc.add(idCkP);
		pc.add(name);
		pc.add(age);
		pc.add(addr);
		
		
		
		ps.add(confirm); 
		ps.add(reset);
	
		add(pw,"West"); 
		add(pc,"Center");
		add(ps,"South");
		
		setSize(300,250);
		setVisible(true);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//이벤트등록
        confirm.addActionListener(this); //가입/수정 이벤트등록
        reset.addActionListener(this); //취소 이벤트등록
        idCkBtn.addActionListener(this);// ID중복체크 이벤트 등록
		
	}//생성자끝
    
	/**
	 * 가입/수정/취소/IDCheck 기능에 대한 부분
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed끝
	
}//클래스끝







