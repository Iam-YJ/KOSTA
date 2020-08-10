package ch06;

public class ShopService {
	private static ShopService sc=new ShopService();
	private ShopService() {}
	public static ShopService getInstance() {
		return sc;
		
		
	}
	}

