package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.List;

public class EmployeeDetailesDTO {

	private int empId;
	private String name;
	private String email;
	private List<DepartmentRequestDTO> departmentList;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<DepartmentRequestDTO> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<DepartmentRequestDTO> departmentList) {
		this.departmentList = departmentList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDetailesDTO [empId=");
		builder.append(empId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", departmentList=");
		builder.append(departmentList);
		builder.append("]");
		return builder.toString();
	}
	
}
