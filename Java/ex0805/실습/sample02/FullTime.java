class  FullTime extends Employee
{
	
	private int salary;
	private int bonus;

	FullTime(){}

	FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus){
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.salary = salary;
		this.bonus = bonus;
	}

/*
	public void message(FullTime [] ft){
		System.out.println("**************Full Time 정보*************");
		for(int i=0; i<ft.length; i++){
			System.out.print(ft[i].getEmpNo()+" | ");
			System.out.print(ft[i].getEName()+" | ");
			System.out.print(ft[i].getJob()+" | ");
			System.out.print(ft[i].getMgr()+" | ");
			System.out.print(ft[i].getHiredate()+" | ");
			System.out.print(ft[i].getDeptName()+" | ");
			System.out.print(ft[i].getSalary()+" | ");
			System.out.print(ft[i].getBonus()+" | ");
			System.out.println();

		}System.out.println();
	}
*/

	public void message(){
		super.message();
		System.out.print("사원은 정규직입니다.");
	}

	public String toString(){
		return( super.toString() +  " | " +salary+ " | " +bonus) ;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	

	



}
