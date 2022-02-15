//전자제품의 속성을 관리하는 객체

class Sing{
	private int singRank; //순위
	private String singTitle; //제목
	private String singSinger; //가수

	//생성자 작성

	public Sing(){}

	public Sing(int singRank, String singTitle, String singSinger){
		this(singRank, singTitle);
		this.singSinger = singSinger;
	}

	//수정할 때 필요한 생성자(순위, 제목)
	public Sing(int singRank, String singTitle){
		this. singRank = singRank;
		this.singTitle = singTitle;
	}

	public Sing(String singTitle){
		this.singTitle = singTitle;
	}

	/*
	public Sing(int singRank, String singSinger){
		this. singRank = singRank;
		this.singSinger = singSinger;
	} */


	//setter : public void (인수 o)
	public void setSingRank(int singRank){
		this.singRank = singRank;
	}

	public void setSingTitle(String singTitle){
		this.singTitle = singTitle;
	}

	public void setSingSinger(String singSinger){
		this.singSinger = singSinger;
	}


	//getter : public dataType, 인수 x

	public int getSingRank(){
		return singRank;
	}

	public String getSingTitle(){
		return singTitle;
	}

	public String getSingSinger(){
		return singSinger;
	}



}