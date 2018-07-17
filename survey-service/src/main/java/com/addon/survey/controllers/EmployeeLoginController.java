package com.addon.survey.controllers;

import java.util.List;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.addon.survey.errors.CustomError;
import com.addon.survey.helper.Password;
import com.addon.survey.model.EmployeeLogin;
import com.addon.survey.repositories.EmployeeLoginRepository;

@RestController
public class EmployeeLoginController {

	@Autowired
	EmployeeLoginRepository empLoginRepository;

	@GetMapping("/users")
	public List<EmployeeLogin> findAll() {
		return empLoginRepository.findAll();
	}

	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestParam String userId, @RequestParam String password) {
		EmployeeLogin empLoginInfo = empLoginRepository.findByUserId(userId);
		if (empLoginInfo == null)
			return new ResponseEntity<CustomError>(new CustomError("User Not found"), HttpStatus.NOT_FOUND);
		String strSaltValue = empLoginInfo.getConfirmPassword();
		String strHashedPassword = empLoginInfo.getPassword();
		char[] arrPassword = password.toCharArray();
		byte[] saltValue = Base64.getDecoder().decode(strSaltValue);
		byte[] hashedPassword = Base64.getDecoder().decode(strHashedPassword);
		boolean isValid = Password.isExpectedPassword(arrPassword, saltValue, hashedPassword);
		if (isValid)
			return new ResponseEntity<EmployeeLogin>(empLoginInfo, HttpStatus.OK);
		else
			return new ResponseEntity<CustomError>(new CustomError("User Not found"), HttpStatus.NOT_FOUND);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> add(@RequestBody EmployeeLogin loginInfo) {
		EmployeeLogin empLoginInfo = empLoginRepository.findByUserId(loginInfo.getUserId());
		if (empLoginInfo != null)
			return new ResponseEntity<CustomError>(new CustomError("Login Already Exists"), HttpStatus.CONFLICT);
		char[] arrPassword = loginInfo.getPassword().toCharArray();
		byte[] saltValue = Password.getNextSalt();
		byte[] hashedPassword = Password.hash(arrPassword, saltValue);
		loginInfo.setPassword(Base64.getEncoder().encodeToString(hashedPassword));
		loginInfo.setConfirmPassword(Base64.getEncoder().encodeToString(saltValue));
		return new ResponseEntity<EmployeeLogin>(empLoginRepository.save(loginInfo), HttpStatus.CREATED);
	}

	@GetMapping("/login/{userId}")
	public ResponseEntity<?> findAll(@PathVariable String userId) {
		EmployeeLogin login = empLoginRepository.findByUserId(userId);
		if (login == null)
			return new ResponseEntity<CustomError>(new CustomError("User not found"), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<EmployeeLogin>(login, HttpStatus.FOUND);
	}

}
