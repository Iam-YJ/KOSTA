class PartTime{

	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int timePay;

	PartTime(){}


	PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay){
		this.empNo = empNo;
		this.eName = eName;
		this.job = this.job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.timePay = timePay;
	}

	public void message(PartTime [] pt){
		System.out.println("**************Part Time Á¤º¸*************");
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
	}

	public String toString(){
		
		return null;
	}

//SETTER
	public void setEmpNo(int empNo){
		this.empNo = empNo;
	}

	public void setEName(String eName){
		this.eName = eName;
	}

	
	public void setJob(String job){
		this.job = job;
	}

	public void setMgr(int mgr){
		this.mgr = mgr;
	}

	public void setHiredate(String hiredate){
		this.hiredate = hiredate;
	}

	public void setDeptName(String deptName){
		this.deptName = deptName;
	}

	public void setTimePay(int timePay){
		this.timePay = timePay;
	}




//GETTER
	public int getEmpNo(){
		return empNo;
	}

	public String getEName(){
		return eName;
	}

	
	public String getJob(){
		return job;
	}

	public int getMgr(){
		return mgr;
	}

	public String getHiredate(){
		return hiredate;
	}

	public String getDeptName(){
		return deptName;
	}

	public int getTimePay(){
		return timePay;
	}

	



}