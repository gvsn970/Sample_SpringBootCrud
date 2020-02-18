package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.List;

public class EmpResponse {

	private int statusCode;
	private String statusMessage;
	private List<EmployeeDetailesDTO> list;
	private EmployeeDetailesDTO empDetailes;
	private List<DepartmentRequestDTO> departmentDetailes;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<EmployeeDetailesDTO> getList() {
		return list;
	}
	public void setList(List<EmployeeDetailesDTO> list) {
		this.list = list;
	}
	public EmployeeDetailesDTO getEmpDetailes() {
		return empDetailes;
	}
	public void setEmpDetailes(EmployeeDetailesDTO empDetailes) {
		this.empDetailes = empDetailes;
	}
	public List<DepartmentRequestDTO> getDepartmentDetailes() {
		return departmentDetailes;
	}
	public void setDepartmentDetailes(List<DepartmentRequestDTO> departmentDetailes) {
		this.departmentDetailes = departmentDetailes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpResponse [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMessage=");
		builder.append(statusMessage);
		builder.append(", list=");
		builder.append(list);
		builder.append(", empDetailes=");
		builder.append(empDetailes);
		builder.append(", departmentDetailes=");
		builder.append(departmentDetailes);
		builder.append("]");
		return builder.toString();
	}
	
}
