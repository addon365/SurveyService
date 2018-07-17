package com.addon.survey.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Shop {
	private Long id;
	private String doorNo;
	private String name;
	private String ownerName;
	private String additionAddress;
	private String landmark;
	private Set<Contact> contacts;
	private double latitude;
	private double longitude;
	private String imageUrl;
	private BusinessScope businessScope;
	private int rating;
	private Set<Tag> tags;
	private Street street;
	private Building building;
	private LocalDate createdAt;
	private LocalDate updateAt;
	private EmployeeLogin createdBy;
	private EmployeeLogin updatedBy;
	
	

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	@OneToOne
	public EmployeeLogin getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(EmployeeLogin createdBy) {
		this.createdBy = createdBy;
	}

	@OneToOne
	public EmployeeLogin getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(EmployeeLogin updatedBy) {
		this.updatedBy = updatedBy;
	}

	@ManyToOne(targetEntity = Building.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id", nullable = true)
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@ManyToOne(targetEntity = Street.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "street_id", nullable = true)
	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAdditionAddress() {
		return additionAddress;
	}

	public void setAdditionAddress(String additionAddress) {
		this.additionAddress = additionAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Enumerated
	@Column(columnDefinition = "smallint")
	public BusinessScope getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(BusinessScope businessScope) {
		this.businessScope = businessScope;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
