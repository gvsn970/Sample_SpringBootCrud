package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

public class EmpDTO {

	private int empId;
	private String empName;
	private String empCountry;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCountry() {
		return empCountry;
	}
	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}
	@Override
	public String toString() {
		return "EmpDTO [empId=" + empId + ", empName=" + empName + ", empCountry=" + empCountry + "]";
	}
	
	
}
