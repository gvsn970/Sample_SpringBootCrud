package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class DepartmentModel {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="department_id")
	private int departId;
    
    @Column(name="department_name")
    private String departName;
    
    @Column(name="fk_emp_id")
    private int empId;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
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
		builder.append("DepartmentModel [departId=");
		builder.append(departId);
		builder.append(", departName=");
		builder.append(departName);
		builder.append(", empId=");
		builder.append(empId);
		builder.append("]");
		return builder.toString();
	}
    
    
}
