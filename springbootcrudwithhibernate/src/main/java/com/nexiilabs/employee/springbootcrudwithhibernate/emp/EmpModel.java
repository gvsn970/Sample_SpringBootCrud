package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class EmpModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="emp_id")
	private int empId;
    
    @Column(name="country")
    private String country;
    
    @Column(name="name")
    private String name;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmpModel [empId=" + empId + ", country=" + country + ", name=" + name + "]";
	}
    
	
}
