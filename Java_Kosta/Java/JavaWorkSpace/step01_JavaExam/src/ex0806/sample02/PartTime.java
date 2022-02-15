package ex0806.sample02;

public class PartTime extends Employee {
	private int timePay;

	public PartTime() {
		super();
	}

	public PartTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int TimePay) {
		super(empNo, empName, job, mgr, hiredate, deptName);
		this.timePay = TimePay;
	}

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		timePay = timePay;
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println(getEmpName() + "님은 비정규직입니다.");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()+" | ");
		builder.append(timePay);
		return builder.toString();
	}
	
	
	
	


}
