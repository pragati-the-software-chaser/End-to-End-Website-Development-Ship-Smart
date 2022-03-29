package edu.msu.shipsmart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "form_ship_from")
public class FormShipFrom {
	
	@Id
    @Column(name = "order_id") 
    private Long orderId;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "country")
	private String country;

	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "additional_details")
	private String additionalDetails;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "order_id")
	private UserOrder userOrder;
	
	

	public FormShipFrom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormShipFrom(Long orderId, String fullName, String country, String streetAddress, String city, String state,
			String zipCode, String additionalDetails, UserOrder userOrder) {
		super();
		this.orderId = orderId;
		this.fullName = fullName;
		this.country = country;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.additionalDetails = additionalDetails;
		this.userOrder = userOrder;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	
	
}