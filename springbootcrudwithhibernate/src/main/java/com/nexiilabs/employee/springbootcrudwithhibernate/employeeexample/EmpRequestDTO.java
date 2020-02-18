package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.List;

public class EmpRequestDTO {

	private int empId;
	private String empName;
	private String email;
	private String password;
	private List<DepartmentRequestDTO> departmentList;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		builder.append("EmpRequestDTO [empId=");
		builder.append(empId);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", departmentList=");
		builder.append(departmentList);
		builder.append("]");
		return builder.toString();
	}
	
 }
