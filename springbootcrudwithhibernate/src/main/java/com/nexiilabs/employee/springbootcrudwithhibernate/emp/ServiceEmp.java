package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ServiceEmp {

	ResponseEmp addEmp(EmpModel model);

	ResponseEmp updateEmp(EmpModel model);

	ResponseEmp deleteEmp(int id);

	List<EmpDTO> getEmpData();
	
	EmpDTO getEmpDataById(int id);
	
	boolean saveFileToDisk(MultipartFile file_object, String UPLOADED_FOLDER, String fileName, String filePath);

	ResponseDTO createDirectories( String RELEASE_FOLDER);

	ResponseEmp addEmpDp(UserImageUploadModel uploadModel);

}
