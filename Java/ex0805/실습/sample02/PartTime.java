class PartTime extends Employee
{

	private int timePay;

	PartTime(){}


	PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay){
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.timePay = timePay;
	}
	
/*
	public void message(PartTime [] pt){
		System.out.println("**************Part Time 정보*************");
		for(int i=0; i<pt.length; i++){
			System.out.print(pt[i].getEmpNo()+" | ");
			System.out.print(pt[i].getEName()+" | ");
			System.out.print(pt[i].getJob()+" | ");
			System.out.print(pt[i].getMgr()+" | ");
			System.out.print(pt[i].getHiredate()+" | ");
			System.out.print(pt[i].getDeptName()+" | ");
			System.out.print(pt[i].getTimePay()+" | ");
			System.out.println();

		}System.out.println();
	} */

	public void message(){
		super.message();
		System.out.print("사원은 비정규직입니다.");
	}

	@Override
	public String toString(){
		return(super.toString() +" | " +timePay) ;
	}

	public int getTimePay() {
		return timePay;
	}


	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}




}