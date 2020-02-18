package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.List;


public interface EmployeeService {

	EmpResponse AddEmployee(EmpRequestDTO requestDTO);

	List<EmployeeDetailesDTO> getemployeeList();

	EmployeeDetailesDTO getempById(int empId);

	EmpResponse deleteEmp(int empId);

	EmpResponse updateEmployee(EmpRequestDTO requestDTO);

	List<DepartmentRequestDTO> getDepartmentList();

}
