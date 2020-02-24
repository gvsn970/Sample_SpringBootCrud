package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController{

	private static final String path="/error";
	@Override
	public String getErrorPath() {

		return path;
	}
	@RequestMapping(path)
	public String error() {
		return "No Mapping Availabe in spring boot application";
	}

}
