package model.dto;

import java.util.ArrayList;
import java.util.List;

public class Writing {
	private int wriNo; //pk
	private String wriTitle;
	private String wriDate;
	private int userNo; //fk
	private List<WriList> wriList = new ArrayList<WriList>();
	
	public Writing() {}

	public Writing(int wriNo, String wriTitle, String wriDate, int userNo) {
		super();
		this.wriNo = wriNo;
		this.wriTitle = wriTitle;
		this.wriDate = wriDate;
		this.userNo = userNo;
	}

	public int getWriNo() {
		return wriNo;
	}

	public void setWriNo(int wriNo) {
		this.wriNo = wriNo;
	}

	public String getWriTitle() {
		return wriTitle;
	}

	public void setWriTitle(String wriTitle) {
		this.wriTitle = wriTitle;
	}

	public String getWriDate() {
		return wriDate;
	}

	public void setWriDate(String wriDate) {
		this.wriDate = wriDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public List<WriList> getWriList() {
		return wriList;
	}

	public void setWriList(List<WriList> wriList) {
		this.wriList = wriList;
	}	
	
}
