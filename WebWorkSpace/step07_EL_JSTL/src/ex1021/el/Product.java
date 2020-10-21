package ex1021.el;

public class Product {
	
	private String code="A01";
	private String name="에이스";
	private int price=2500;
	private int qty=5;
	
	public Product() {
		System.out.println("Product() 기본 생성자 호출됨 ");
	}

	public String getCode() {
		System.out.println("getCode() call");
		return code;
	}

	public String getName() {
		System.out.println("getName() call");
		return name;
	}

	public int getPrice() {
		System.out.println("getPrice() call");
		return price;
	}

	public int getQty() {
		System.out.println("getQty() call");
		return qty;
	}
	
	
	
	

}
