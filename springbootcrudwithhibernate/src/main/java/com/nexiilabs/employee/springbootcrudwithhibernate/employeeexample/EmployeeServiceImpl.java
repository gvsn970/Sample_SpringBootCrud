package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	@Override
	public EmpResponse AddEmployee(EmpRequestDTO requestDTO) {
		return dao.AddEmployee(requestDTO);
	}
	@Override
	public List<EmployeeDetailesDTO> getemployeeList() {
		return dao.getemployeeList();
	}
	@Override
	public EmployeeDetailesDTO getempById(int empId) {
		return dao.getempById(empId);
	}
	@Override
	public EmpResponse deleteEmp(int empId) {
		return dao.deleteEmp(empId);
	}
	@Override
	public EmpResponse updateEmployee(EmpRequestDTO requestDTO) {
		return dao.updateEmployee(requestDTO);
	}
	@Override
	public List<DepartmentRequestDTO> getDepartmentList() {
		return dao.getDepartmentList();
	}

}
