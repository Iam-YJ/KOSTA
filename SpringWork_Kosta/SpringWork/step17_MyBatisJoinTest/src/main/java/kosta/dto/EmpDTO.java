package kosta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDTO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgt;
	private String hireDate;
	private int sal;
	private int comm;
	private int deptno;
	
	private DeptDTO dept;
	
	private SalgradeDTO salgrade;

}

