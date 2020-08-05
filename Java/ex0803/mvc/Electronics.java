//전자제품의 속성을 관리하는 객체

class Electronics{
	private int modelNo; //모델번호
	private String modelName; //모델이름
	private int modelPrice; // 모델가격
	private String modelDetail; //모델설명

	//생성자 작성

	public Electronics(){}

	public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail){
		this(modelNo, modelDetail);
		this.modelName = modelName;
		this.modelPrice = modelPrice;
	}

	//수정할 때 필요한 생성자(모델번호, 모델설명)
	public Electronics(int modelNo, String modelDetail){
		this. modelNo = modelNo;
		this.modelDetail = modelDetail;
	}

	//setter : public void (인수 o)
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

	//getter : public dataType, 인수 x

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



}