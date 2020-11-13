package sample06;

import java.util.List;

public class ListBean {

	private List<Integer> intList;
	private List<String> strList;
	private List<Customer> customerList;

	public void setIntList(List<Integer> intList) {
		System.out.println("setIntList");
		System.out.println(intList);
		this.intList = intList;
	}

	public void setStrList(List<String> strList) {
		System.out.println("setStrList");
		System.out.println(strList);
		this.strList = strList;
	}

	public void setCustomerList(List<Customer> customerList) {
		System.out.println("setCustomerList");
		System.out.println(customerList);
		this.customerList = customerList;
	}

}
