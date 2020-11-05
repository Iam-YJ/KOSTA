package model.dto;

public class Menu {

	private int menuNo;
	private int resNo;
	private String menuName;
	private String menuPrice;

	public Menu(int menuNo, int resNo, String menuName, String menuPrice) {
		super();
		this.menuNo = menuNo;
		this.resNo = resNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

}
