package model.dto;

public class WriList {
	private int wriListNo;
	private int wriNo;
	private int resNo;
	private String wriContent;
	//private String wriPhoto;
	
	public WriList() {}

	public WriList(int wriListNo, int wriNo, int resNo, String wriContent) {
		super();
		this.wriListNo = wriListNo;
		this.wriNo = wriNo;
		this.resNo = resNo;
		this.wriContent = wriContent;
		//this.wriPhoto = wriPhoto;
	}

	public int getWriListNo() {
		return wriListNo;
	}

	public void setWriListNo(int wriListNo) {
		this.wriListNo = wriListNo;
	}

	public int getWriNo() {
		return wriNo;
	}

	public void setWriNo(int wriNo) {
		this.wriNo = wriNo;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getWriContent() {
		return wriContent;
	}

	public void setWriContent(String wriContent) {
		this.wriContent = wriContent;
	}
	
	
}
