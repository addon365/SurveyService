package com.addon.survey.controllers;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.survey.errors.CustomError;
import com.addon.survey.helper.Password;
import com.addon.survey.model.Employee;
import com.addon.survey.model.EmployeeLogin;
import com.addon.survey.repositories.EmployeeLoginRepository;
import com.addon.survey.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeLoginRepository empLoginRepository;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public ResponseEntity<?> add(@RequestBody Employee employee) {
		EmployeeLogin loginInfo = empLoginRepository.findByUserId(employee.getEmployeeLogin().getUserId());
		if (loginInfo != null) {
			return new ResponseEntity<CustomError>(new CustomError("User Id already found"), HttpStatus.CONFLICT);
		} else {
			loginInfo = employee.getEmployeeLogin();
			char[] arrPassword = loginInfo.getPassword().toCharArray();
			byte[] saltValue = Password.getNextSalt();
			byte[] hashedPassword = Password.hash(arrPassword, saltValue);
			loginInfo.setPassword(Base64.getEncoder().encodeToString(hashedPassword));
			loginInfo.setConfirmPassword(Base64.getEncoder().encodeToString(saltValue));
			loginInfo = empLoginRepository.save(loginInfo);
			employee.setEmployeeLogin(loginInfo);
			return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.CREATED);
		}

	}

}
