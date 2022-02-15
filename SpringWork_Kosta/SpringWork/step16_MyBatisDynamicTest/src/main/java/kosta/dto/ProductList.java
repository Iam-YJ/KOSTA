package kosta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductList {

	private String code;
	private String name;
	private int qty;
	private int price;
	private String detail;
	
	
	
	public ProductList() {
	}

	
	public ProductList(String code, String name, int qty, int price, String detail) {
		this.code = code;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "ProductList [code=" + code + ", name=" + name + ", qty=" + qty + ", price=" + price + ", detail="
				+ detail + "]";
	}

	
	



	

}
