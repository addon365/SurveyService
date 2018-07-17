package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addon.survey.model.EmployeeLogin;

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin, Long> {
	EmployeeLogin findByUserId(String userId);
}
