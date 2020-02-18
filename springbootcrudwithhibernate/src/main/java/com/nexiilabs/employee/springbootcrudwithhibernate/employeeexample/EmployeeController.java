package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emplyoee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public EmpResponse addEmp(@RequestBody EmpRequestDTO requestDTO) {
		EmpResponse response=new EmpResponse();
		try {
			if(requestDTO == null) {
				response.setStatusCode(0);
				response.setStatusMessage("Employee Detailes Required..");
				return response;
			}
			response=service.AddEmployee(requestDTO);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("getallemp")
	public EmpResponse getEmployees() {
		EmpResponse res=new EmpResponse();
		List<EmployeeDetailesDTO> list=new ArrayList<>();
		list=service.getemployeeList();
		if(!list.isEmpty()) {
			res.setStatusCode(1);
			res.setStatusMessage("Employee Detaies Found");
			res.setList(list);
		}else {
			res.setStatusCode(0);
			res.setStatusMessage("Employee Detaies Not Found");
			res.setList(new ArrayList<>());
		}
		return res;
	}
	@GetMapping("department")
	public EmpResponse getDepartmnents() {
		EmpResponse res=new EmpResponse();
		List<DepartmentRequestDTO> list=new ArrayList<DepartmentRequestDTO>();
		list=service.getDepartmentList();
		if(!list.isEmpty()) {
			res.setStatusCode(1);
			res.setStatusMessage("Employee Detaies Found");
			res.setDepartmentDetailes(list);
		}else {
			res.setStatusCode(0);
			res.setStatusMessage("Employee Detaies Not Found");
			res.setList(new ArrayList<>());
		}
		return res;
	}
	
	@GetMapping("/getempbyid")
	public EmpResponse getempDetailesById(@RequestParam int empId) {
		EmpResponse res=new EmpResponse();
		EmployeeDetailesDTO dto=null;
		dto=service.getempById(empId);
		if(dto == null) {
			res.setStatusCode(0);
			res.setStatusMessage("EMp Detailes Not Found");
		}else {
			res.setStatusCode(1);
			res.setStatusMessage("EMp Detailes Found");
			res.setEmpDetailes(dto);
		}
		
		return res;
	}
	@DeleteMapping
	public EmpResponse deleteEmp(@RequestParam int empId) {
		EmpResponse res=new EmpResponse();
		res=service.deleteEmp(empId);
		return  res;
		
	}
	@PutMapping("update")
	public EmpResponse updateEmp(@RequestBody EmpRequestDTO requestDTO) {
		EmpResponse res=null;
		res=service.updateEmployee(requestDTO);
		return res;
	}
}
