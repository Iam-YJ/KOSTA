//������ǰ�� �Ӽ��� �����ϴ� ��ü

class Sing{
	private int singRank; //����
	private String singTitle; //����
	private String singSinger; //����

	//������ �ۼ�

	public Sing(){}

	public Sing(int singRank, String singTitle, String singSinger){
		this(singRank, singTitle);
		this.singSinger = singSinger;
	}

	//������ �� �ʿ��� ������(����, ����)
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


	//setter : public void (�μ� o)
	public void setSingRank(int singRank){
		this.singRank = singRank;
	}

	public void setSingTitle(String singTitle){
		this.singTitle = singTitle;
	}

	public void setSingSinger(String singSinger){
		this.singSinger = singSinger;
	}


	//getter : public dataType, �μ� x

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