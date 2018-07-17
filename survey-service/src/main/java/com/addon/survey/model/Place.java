package com.addon.survey.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Place {
	private Long id;
	private String name;
	private String code;
	private Taluk taluk;
	private boolean isCity;
	private boolean isParent;
	

	public Place() {
		super();
	}

	public Place(String name, String code, Taluk taluk, boolean isCity, boolean isParent) {
		super();
		this.name = name;
		this.code = code;
		this.taluk = taluk;
		this.isCity = isCity;
		this.isParent = isParent;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public boolean isCity() {
		return isCity;
	}

	public void setCity(boolean isCity) {
		this.isCity = isCity;
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

	@ManyToOne(targetEntity = Taluk.class, fetch = FetchType.EAGER)
	public Taluk getTaluk() {
		return taluk;
	}

	public void setTaluk(Taluk taluk) {
		this.taluk = taluk;
	}

}
