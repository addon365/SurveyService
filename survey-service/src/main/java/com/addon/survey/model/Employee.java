package com.addon.survey.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	private Long id;
	private String employeeCode;
	private LocalDate joinedDate;
	private LocalDate releavedDate;
	private Set<Designation> designations;
	private boolean isActive;
	private Profile profile;
	private EmployeeLogin employeeLogin;

	public Employee() {
		super();
	}

	public Employee(String employeeCode, Designation designation, EmployeeLogin employeeLogin) {
		super();
		this.employeeCode = employeeCode;
		this.joinedDate = LocalDate.now();
		this.designations = new HashSet<Designation>();
		this.designations.add(designation);
		this.employeeLogin = employeeLogin;
	}

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable
	public Set<Designation> getDesignations() {
		return designations;
	}

	public void setDesignations(Set<Designation> designations) {
		this.designations = designations;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	public EmployeeLogin getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(EmployeeLogin employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	public LocalDate getReleavedDate() {
		return releavedDate;
	}

	public void setReleavedDate(LocalDate releavedDate) {
		this.releavedDate = releavedDate;
	}

}
