package com.addon.survey.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Street {
	private Long id;
	private String name;
	private String code;
	private Area area;
	private Set<Building> buildings;
	private Set<Shop> shops;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Shop> getShops() {
		return shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
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

	@ManyToOne(targetEntity = Area.class, fetch = FetchType.EAGER)
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
