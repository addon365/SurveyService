package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addon.survey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
