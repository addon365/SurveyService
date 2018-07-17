package com.addon.survey.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class District {
	private Long id;
	private String name;
	private String code;
	private Polity polity;

	public District() {
		super();
	}

	public District(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public District(String name, String code, Polity polity) {
		super();
		this.name = name;
		this.code = code;
		this.polity = polity;
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

	@ManyToOne(targetEntity = Polity.class, fetch = FetchType.LAZY)
	public Polity getPolity() {
		return polity;
	}

	public void setPolity(Polity state) {
		this.polity = state;
	}

}
