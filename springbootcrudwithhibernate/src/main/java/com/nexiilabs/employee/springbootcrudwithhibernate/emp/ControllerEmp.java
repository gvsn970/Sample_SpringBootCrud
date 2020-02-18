package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ControllerEmp {

	@Autowired
	private ServiceEmp serviceEmp;
	@Autowired
	Environment environment;

	@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add")
	public ResponseEmp addEmp(@RequestParam("file") MultipartFile uploadDp,@RequestParam String name,
			@RequestParam String country) {
		ResponseEmp res = new ResponseEmp();
		if (name.equals("")) {
			res.setStatusCode(0);
			res.setStatusMessage("Name Required...");
			return res;
		}

		if (country.equals("")) {
			res.setStatusCode(0);
			res.setStatusMessage("Country Required...");
			return res;
		}
		try {
			EmpModel model = new EmpModel();
			model.setName(name);
			model.setCountry(country);
			res = serviceEmp.addEmp(model);
			if (res.getEmpId() != 0) {
				if (uploadDp != null) {
					String UPLOADED_FOLDER = null;
					ResponseDTO responseFromCreateDir = new ResponseDTO();
					String USER_IMAGE_FOLDER = environment.getProperty("app.userimageuploaddir");
					String fileName = null;
					String filePath = null;
					USER_IMAGE_FOLDER = USER_IMAGE_FOLDER + "user";
					MultipartFile file = (MultipartFile) uploadDp;
					BufferedImage image = ImageIO.read(file.getInputStream());
					if ((file.getContentType().toLowerCase().equals("image/png"))
							|| file.getContentType().toLowerCase().equals("image/jpeg")
							|| file.getContentType().toLowerCase().equals("image/jpg")) {
						if (!(file.isEmpty() || file.getSize() == 0)) {
							if (image.getWidth() <= 600 && image.getHeight() <= 600) {
								responseFromCreateDir = serviceEmp.createDirectories(USER_IMAGE_FOLDER);
								UPLOADED_FOLDER = responseFromCreateDir.getUploadPath();
								MultipartFile file_object = uploadDp;
								if (!file_object.isEmpty()) {
									fileName = file_object.getOriginalFilename();
									Date date = new Date();
									int lastDot = fileName.lastIndexOf('.');
									fileName = fileName.substring(0, lastDot) + "_" + date.getTime()
											+ fileName.substring(lastDot);
									filePath = Paths.get(UPLOADED_FOLDER, fileName).toString();
									UserImageUploadModel uploadModel = null;

									uploadModel = new UserImageUploadModel();
									uploadModel.setFileName(fileName);
									uploadModel.setFileLocation(filePath);
									uploadModel.setCreatedBy(1);
									uploadModel.setUserId(res.getEmpId());
									uploadModel.setEmpId(res.getEmpId());
									uploadModel.setFileType(FilenameUtils.getExtension(fileName));
									uploadModel.setFileSize(file.getSize() + " byte");
									if (serviceEmp.saveFileToDisk(file_object, UPLOADED_FOLDER, fileName, filePath)) {
										res = serviceEmp.addEmpDp(uploadModel);

									} else {

										res.setStatusCode(0);
										res.setStatusMessage("User image Upload Failure");
									}
								}
							} else {
								res.setStatusCode(0);
								res.setStatusMessage("User Image should be 2x2 inches");
							}
						} else {
							res.setStatusCode(0);
							res.setStatusMessage("Image Required");
						}

					} else {
						res.setStatusCode(0);
						res.setStatusMessage("Image Should be png or jpeg or jpg");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@PutMapping(value = "/update")
	@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEmp updateEmp(@RequestParam int id, @RequestParam String name, @RequestParam String country) {

		ResponseEmp res = new ResponseEmp();
		EmpModel model = new EmpModel();
		model.setEmpId(id);
		model.setName(name);
		model.setCountry(country);
		res = serviceEmp.updateEmp(model);
		return res;
	}

	@DeleteMapping(value = "/delete")
	@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEmp deleteEmp(@RequestParam int id) {
		ResponseEmp res = new ResponseEmp();
		res = serviceEmp.deleteEmp(id);
		return res;
	}

	@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/getallemp")
	public List<EmpDTO> getEmpDtailes() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		list = serviceEmp.getEmpData();
		return list;
	}

	@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/getemp")
	public EmpDTO getEmpDtailesById(@RequestParam int id) {
		EmpDTO list = new EmpDTO();
		list = serviceEmp.getEmpDataById(id);
		return list;
	}
}
