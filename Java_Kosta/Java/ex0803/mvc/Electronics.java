//������ǰ�� �Ӽ��� �����ϴ� ��ü

class Electronics{
	private int modelNo; //�𵨹�ȣ
	private String modelName; //���̸�
	private int modelPrice; // �𵨰���
	private String modelDetail; //�𵨼���

	//������ �ۼ�

	public Electronics(){}

	public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail){
		this(modelNo, modelDetail);
		this.modelName = modelName;
		this.modelPrice = modelPrice;
	}

	//������ �� �ʿ��� ������(�𵨹�ȣ, �𵨼���)
	public Electronics(int modelNo, String modelDetail){
		this. modelNo = modelNo;
		this.modelDetail = modelDetail;
	}

	//setter : public void (�μ� o)
	public void setModelNo(int modelNo){
		this.modelNo = modelNo;
	}

	public void setModelName(String modelName){
		this.modelName = modelName;
	}

	public void setModelPrice(int modelPrice){
		this.modelPrice = modelPrice;
	}

	public void setModelDetail(String modelDetail){
		this.modelDetail = modelDetail;
	}

	//getter : public dataType, �μ� x

	public int getModelNo(){
		return modelNo;
	}

	public String getModelName(){
		return modelName;
	}

	public int getModelPrice(){
		return modelPrice;
	}

	public String getModelDetail(){
		return modelDetail;
	}

	
	@Override // ������
	public String toString(){
		return (getModelNo() + "\t" + getModelName() + "\t" +  getModelPrice() + "\t" + getModelDetail());
	}


}