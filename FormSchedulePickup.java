package edu.msu.shipsmart.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "form_schedule_pickup")
public class FormSchedulePickup {
	
	@Id
    @Column(name = "order_id") 
    private Long orderId;

	@Column(name = "pickup_date")
	private Date pickupDate;

	@Column(name = "pickup_time")
	private String pickupTime;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "driver_instruction")
	private String driverInstruction;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "order_id")
	private UserOrder userOrder;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDriverInstruction() {
		return driverInstruction;
	}

	public void setDriverInstruction(String driverInstruction) {
		this.driverInstruction = driverInstruction;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	
	
}