package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DaoImpl implements Dao {

	@Autowired
	EntityManager entityManager;

	@Override
	public ResponseEmp addEmp(EmpModel model) {
		// TODO Auto-generated method stub
		ResponseEmp res = new ResponseEmp();
		// String query="";
		// entityManager.createNativeQuery(query).getResultList();
		entityManager.persist(model);
		if (model.getEmpId() != 0) {
			res.setStatusCode(1);
			res.setEmpId(model.getEmpId());
			res.setStatusMessage("Emp Added Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp Added Failed!......");
		}
		return res;
	}

	@Override
	public ResponseEmp updateEmp(EmpModel model) {
		// TODO Auto-generated method stub

		ResponseEmp res = new ResponseEmp();
		String query = "update emp SET name='" + model.getName() + "',country='" + model.getCountry()
				+ "' WHERE emp_id=" + model.getEmpId() + " ";
		int i = entityManager.createNativeQuery(query).executeUpdate();

		if (i > 0) {
			res.setStatusCode(1);
			res.setEmpId(model.getEmpId());
			res.setStatusMessage("Emp Update Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp updation Faild !......");
		}
		return res;
	}

	@Override
	public ResponseEmp deleteEmp(int id) {
		// TODO Auto-generated method stub
		ResponseEmp res = new ResponseEmp();
		EmpModel model = new EmpModel();

		model.setEmpId(id);
		String query = "delete FROM emp where emp_id=" + id + "";

		int i = entityManager.createNativeQuery(query).executeUpdate();
		if (i > 0) {
			res.setStatusCode(1);
			res.setStatusMessage("Emp Deleted Succesfully!......");
		} else {
			res.setStatusCode(0);
			res.setStatusMessage("Emp Deletion Failed!......");
		}

		return res;
	}

	@Override
	public List<EmpDTO> getEmpData() {
		// TODO Auto-generated method stub
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		String query = "select * from emp";

		List<Object> listobj = entityManager.createNativeQuery(query).getResultList();
		Iterator itr = listobj.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			EmpDTO dto = new EmpDTO();
			dto.setEmpId(Integer.parseInt(String.valueOf(obj[0])));
			dto.setEmpName(String.valueOf(obj[2]));
			dto.setEmpCountry(String.valueOf(obj[1]));
			list.add(dto);
		}

		return list;
	}

	@Override
	public EmpDTO getEmpDataById(int id) {
		// TODO Auto-generated method stub
		EmpDTO dto = new EmpDTO();
		String query = "SELECT * FROM emp WHERE emp_id=" + id + "";
		List<Object> list = entityManager.createNativeQuery(query).getResultList();

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			dto = new EmpDTO();
			dto.setEmpId(Integer.parseInt(String.valueOf(obj[0])));
			dto.setEmpName(String.valueOf(obj[2]));
			dto.setEmpCountry(String.valueOf(obj[1]));
		}
		return dto;
	}

	@Override
	public ResponseEmp addEmpDp(UserImageUploadModel uploadModel) {
		// TODO Auto-generated method stub
		ResponseEmp userResponse = new ResponseEmp();

		try {

			entityManager.persist(uploadModel);
			if (uploadModel.getAttachmentId() != 0) {
				userResponse.setStatusCode(1);
				userResponse.setStatusMessage("User Image inserted Succesfully");
			} else {
				userResponse.setStatusCode(0);
				userResponse.setStatusMessage("User Image insertion Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			userResponse.setStatusCode(0);
			userResponse.setStatusMessage(e.getMessage());
		}
		return userResponse;
	}

}
