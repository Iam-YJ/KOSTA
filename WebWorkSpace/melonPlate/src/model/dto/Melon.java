package model.dto;

public class Melon {
	private int resNo;
	private String resName;
	private String resPlace;
	private String resTel;
	private String resType;
	private String resPhoto;
	private int resHits;
	private double resGrade;
	private String resPrice;

	public Melon() {}

	
	
	public Melon(String resName, String resPlace, String resTel, String resType, String resPhoto, String resPrice) {
		super();
		this.resName = resName;
		this.resPlace = resPlace;
		this.resTel = resTel;
		this.resType = resType;
		this.resPhoto = resPhoto;
		this.resPrice = resPrice;
	}



	public Melon(int resNo, String resName, String resPlace, String resTel, String resType, String resPhoto,
			int resHits, double resGrade, String resPrice) {
		this.resNo = resNo;
		this.resName = resName;
		this.resPlace = resPlace;
		this.resTel = resTel;
		this.resType = resType;
		this.resPhoto = resPhoto;
		this.resHits = resHits;
		this.resGrade = resGrade;
		this.resPrice = resPrice;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResPlace() {
		return resPlace;
	}

	public void setResPlace(String resPlace) {
		this.resPlace = resPlace;
	}

	public String getResTel() {
		return resTel;
	}

	public void setResTel(String resTel) {
		this.resTel = resTel;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResPhoto() {
		return resPhoto;
	}

	public void setResPhoto(String resPhoto) {
		this.resPhoto = resPhoto;
	}

	public int getResHits() {
		return resHits;
	}

	public void setResHits(int resHits) {
		this.resHits = resHits;
	}

	public double getResGrade() {
		return resGrade;
	}

	public void setResGrade(double resGrade) {
		this.resGrade = resGrade;
	}

	public String getResPrice() {
		return resPrice;
	}

	public void setResPrice(String resPrice) {
		this.resPrice = resPrice;
	}

}
