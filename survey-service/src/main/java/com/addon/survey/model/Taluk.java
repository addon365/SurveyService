package com.addon.survey.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Taluk {

	private Long id;
	private String name;

	private String code;
	private District district;
	private boolean isParent;

	public boolean isParent() {
		return isParent;
	}

	public Taluk() {
		super();
	}

	public Taluk(String name, String code,District district, boolean isParent) {
		super();
		this.name = name;
		this.district = district;
		this.isParent = isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(targetEntity = District.class, fetch = FetchType.EAGER)
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}
