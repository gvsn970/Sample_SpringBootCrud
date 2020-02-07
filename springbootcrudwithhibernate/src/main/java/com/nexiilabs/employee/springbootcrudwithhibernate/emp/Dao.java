package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import java.util.List;

public interface Dao {

	ResponseEmp addEmp(EmpModel model);
	ResponseEmp updateEmp(EmpModel model);
	ResponseEmp deleteEmp(int id);
	List<EmpDTO> getEmpData();
	EmpDTO getEmpDataById(int id);
	ResponseEmp addEmpDp(UserImageUploadModel uploadModel);
}
