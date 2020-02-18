package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

public class DepartmentRequestDTO {

	private int departmentId;
	private String departmentName;
	private int empId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentRequestDTO [departmentId=");
		builder.append(departmentId);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append(", empId=");
		builder.append(empId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
