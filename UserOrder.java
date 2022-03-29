package edu.msu.shipsmart.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_order")
public class UserOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", table = "user_order")
	private Long orderId;
	
	 @Column(name = "user_id", table = "user_order")
	 private long userId;
	 
	 @Column(name = "tracking", table = "user_order")
	 private String tracking;
	 
	 @Column(name = "created_date", table = "user_order")
	 private Date createdDate;
	 
	 
	 @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private FormShipFrom formShipFrom; 
	 
	 @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private FormShipTo formShipTo; 
	 
	 @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private FormCheckout formCheckout; 
	 
	 @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private FormSchedulePickup formSchedulePickup;
	 
	 @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private FormPackage formPackage;
	 
	 

	public UserOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserOrder(Long orderId, long userId, FormShipFrom formShipFrom, FormShipTo formShipTo,
			FormCheckout formCheckout, FormSchedulePickup formSchedulePickup, FormPackage formPackage) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.formShipFrom = formShipFrom;
		this.formShipTo = formShipTo;
		this.formCheckout = formCheckout;
		this.formSchedulePickup = formSchedulePickup;
		this.formPackage = formPackage;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public FormShipFrom getFormShipFrom() {
		return formShipFrom;
	}

	public void setFormShipFrom(FormShipFrom formShipFrom) {
		this.formShipFrom = formShipFrom;
	}

	public FormShipTo getFormShipTo() {
		return formShipTo;
	}

	public void setFormShipTo(FormShipTo formShipTo) {
		this.formShipTo = formShipTo;
	}

	public FormCheckout getFormCheckout() {
		return formCheckout;
	}

	public void setFormCheckout(FormCheckout formCheckout) {
		this.formCheckout = formCheckout;
	}

	public FormSchedulePickup getFormSchedulePickup() {
		return formSchedulePickup;
	}

	public void setFormSchedulePickup(FormSchedulePickup formSchedulePickup) {
		this.formSchedulePickup = formSchedulePickup;
	}

	public FormPackage getFormPackage() {
		return formPackage;
	}

	public void setFormPackage(FormPackage formPackage) {
		this.formPackage = formPackage;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	 
	 

}
