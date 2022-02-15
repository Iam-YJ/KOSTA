class Board 
{
	//글번호, 제목, 작성자, 내용

	private int no;
	private String subject;
	private String writer;
	private String content;

	Board(){}

	Board(int no,  String writer, String content){
		this.no = no;
		this.writer = writer;
		this.content = content;
	}

	Board(int no, String subject, String writer, String content){
		this(no, writer, content);
		this.subject = subject;
	}

	//setter 작성 

	public void setNo(int no){
		this.no = no;
	}

	public void setSubject(String subject){
		this.subject = subject;
	}


	public void setWriter(String writer){
		this.writer = writer;
	}

	public void setContent(String content){
		this.content = content;
	}


	//getter 작성
	public int getNo(){
		return no;
	}

	public String getSubject(){
		return subject;
	}

	public String getWriter(){
		return writer;
	}

	public String getContent(){
		return content;
	}

}
