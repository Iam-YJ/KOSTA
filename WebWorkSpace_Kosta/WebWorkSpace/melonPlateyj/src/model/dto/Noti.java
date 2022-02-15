package model.dto;

public class Noti {
	private int notiNo;// 공지사항 No
	private int userNo;// 유저 No
	private String notiTitle;// 공지사항 제목
	private String notiDate;// 공지사항 작성날짜
	private String notiContent;// 공지사항 내용
	private int notiHits;// 공지사항 조회수

	
	public Noti() {}
	
	public Noti(int userNo, String notiTitle, String notiDate, String notiContent, int notiHits) {
		super();
		this.userNo = userNo;
		this.notiTitle = notiTitle;
		this.notiDate = notiDate;
		this.notiContent = notiContent;
		this.notiHits = notiHits;
	}

	public Noti(int notiNo, int userNo, String notiTitle, String notiDate, String notiContent, int notiHits) {
		this.notiNo = notiNo;
		this.userNo = userNo;
		this.notiTitle = notiTitle;
		this.notiDate = notiDate;
		this.notiContent = notiContent;
		this.notiHits = notiHits;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNotiTitle() {
		return notiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	public String getNotiDate() {
		return notiDate;
	}

	public void setNotiDate(String notiDate) {
		this.notiDate = notiDate;
	}

	public String getNotiContent() {
		return notiContent;
	}

	public void setNotiContent(String notiContent) {
		this.notiContent = notiContent;
	}

	public int getNotiHits() {
		return notiHits;
	}

	public void setNotiHits(int notiHits) {
		this.notiHits = notiHits;
	}

}