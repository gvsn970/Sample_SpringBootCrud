package com.nexiilabs.employee.springbootcrudwithhibernate.employeeexample;

public class InvalidCustomException extends RuntimeException{
	
	InvalidCustomException(String str){
		super(str);
	}
	
}
