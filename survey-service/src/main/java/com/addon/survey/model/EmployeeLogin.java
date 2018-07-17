package com.addon.survey.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EmployeeLogin {
	private Long id;
	private String userName;
	private String userId;
	private String password;
	private String confirmPassword;

	private Set<EmpRole> userRoles;
	private boolean isActive;

	public EmployeeLogin() {
		super();
	}

	public EmployeeLogin(String userName, String userId, String password, String confirmPassword) {
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable
	public Set<EmpRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<EmpRole> userRoles) {
		this.userRoles = userRoles;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
