package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public EmpResponse AddEmployee(EmpRequestDTO requestDTO) {
		DepartmentModel depart = null;
		EmpResponse res = new EmpResponse();
		EmployeModel model = new EmployeModel();
		model.setName(requestDTO.getEmpName());
		model.setEmail(requestDTO.getEmail());
		model.setPassword(requestDTO.getPassword());
		entityManager.persist(model);
		if (model.getEmployeeId() != 0) {
			if (requestDTO.getDepartmentList().size() != 0) {
				for (DepartmentRequestDTO departDetailes : requestDTO.getDepartmentList()) {
					depart = new DepartmentModel();
					depart.setDepartName(departDetailes.getDepartmentName());
					depart.setEmpId(model.getEmployeeId());
					entityManager.persist(depart);
				}

			}
			res.setStatusCode(1);
			res.setStatusMessage("Emp Added Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp Added Failed!......");
		}
		return res;
	}

	@Override
	public List<EmployeeDetailesDTO> getemployeeList() {
		List<DepartmentRequestDTO> departmentList = null;
		List<EmployeeDetailesDTO> list = new ArrayList<EmployeeDetailesDTO>();
		try {
			String query = "select * from employee";

			List<Object> listobj = entityManager.createNativeQuery(query).getResultList();
			Iterator<?> itr = listobj.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				EmployeeDetailesDTO dto = new EmployeeDetailesDTO();
				dto.setEmpId(Integer.parseInt(String.valueOf(obj[0])));
				dto.setEmail(String.valueOf(obj[1]));
				dto.setName(String.valueOf(obj[2]));
				departmentList = getDepartmentList(dto.getEmpId());
				dto.setDepartmentList(departmentList);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	private List<DepartmentRequestDTO> getDepartmentList(int empId) {

		DepartmentRequestDTO dto = null;
		List<DepartmentRequestDTO> dlist = new ArrayList<>();
		try {

			String query = "SELECT * FROM department WHERE fk_emp_id=" + empId + "";
			List<Object> list1 = entityManager.createNativeQuery(query).getResultList();
			System.err.println("list :" + list1.toString());
			Iterator<?> itr1 = list1.iterator();
			while (itr1.hasNext()) {
				Object[] obj1 = (Object[]) itr1.next();
				dto = new DepartmentRequestDTO();
				dto.setDepartmentId(Integer.parseInt(String.valueOf(obj1[0])));
				dto.setDepartmentName(String.valueOf(obj1[1]));
				dlist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dlist;
	}

	@Override
	public EmployeeDetailesDTO getempById(int empId) {

		EmployeeDetailesDTO dto = null;
		List<DepartmentRequestDTO> dlist = new ArrayList<DepartmentRequestDTO>();
		try {

			String query = "SELECT * FROM employee WHERE emp_id=" + empId + "";
			List<Object> list = entityManager.createNativeQuery(query).getResultList();

			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				dto = new EmployeeDetailesDTO();
				dto.setEmpId(Integer.parseInt(String.valueOf(obj[0])));
				dto.setEmail(String.valueOf(obj[1]));
				dto.setName(String.valueOf(obj[2]));
				System.err.println("dto  : " + dto);

				dlist = getDepartmentList(empId);
				dto.setDepartmentList(dlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public EmpResponse deleteEmp(int empId) {

		EmpResponse res = new EmpResponse();
		List<DepartmentRequestDTO> dlist = new ArrayList<>();
		String query = "delete FROM employee where emp_id=" + empId + "";

		int i = entityManager.createNativeQuery(query).executeUpdate();
		if (i > 0) {
			dlist = getDepartmentList(empId);
			for (DepartmentRequestDTO d : dlist) {
				String query2 = "delete FROM department where department_id=" + d.getDepartmentId() + "";

				int i2 = entityManager.createNativeQuery(query2).executeUpdate();
			}
			res.setStatusCode(1);
			res.setStatusMessage("Emp Deleted Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp Deletion Failed!......");
		}

		return res;
	}

	@Override
	public EmpResponse updateEmployee(EmpRequestDTO requestDTO) {
		List<DepartmentRequestDTO> dlist = new ArrayList<>();
		EmpResponse res = new EmpResponse();
		String query = "update employee SET emp_name='" + requestDTO.getEmpName() + "',emp_email='"
				+ requestDTO.getEmail() + "',password=" + requestDTO.getPassword() + " WHERE emp_id="
				+ requestDTO.getEmpId() + " ";
		int i = entityManager.createNativeQuery(query).executeUpdate();

		if (i > 0) {
			for (DepartmentRequestDTO d1 : requestDTO.getDepartmentList()) {
				String query2 = "update department set department_name='" + d1.getDepartmentName()
						+ "' WHERE department_id=" + d1.getDepartmentId() + "";
				int i2 = entityManager.createNativeQuery(query2).executeUpdate();
			}

			res.setStatusCode(1);
			res.setStatusMessage("Emp Update Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp updation Faild !......");
		}
		return res;
	}

	@Override
	public List<DepartmentRequestDTO> getDepartmentList() {
		List<DepartmentRequestDTO> departmentList = new ArrayList<>();
		try {
			String query = "select * from department";

			List<Object> listobj = entityManager.createNativeQuery(query).getResultList();
			Iterator<?> itr = listobj.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				DepartmentRequestDTO dto = new DepartmentRequestDTO();
				dto.setDepartmentId(Integer.parseInt(String.valueOf(obj[0])));
				dto.setDepartmentName(String.valueOf(obj[1]));
				departmentList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return departmentList;
	}

}
