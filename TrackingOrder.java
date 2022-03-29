package edu.msu.shipsmart.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tracking_order")
public class TrackingOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tracking_order_id", table = "tracking_order")
	private long tracking_order_id;
    
	@Column(name = "tracking") 
	private String tracking;
	
	@Column(name = "order_id") 
	private long orderId;
	
	@Column(name = "ship_date") 
	private Date ship_date;
	
	@Column(name = "from_city") 
	private String from_city;
	
	@Column(name = "to_city") 
	private String to_city;
	
	@Column(name = "status") 
	private String status;
	
	@Column(name = "delivery_date") 
	private Date delivery_date;
	
	@Column(name = "comments") 
	private String comments;
	
	@Transient
	private String action;
	
	@Column(nullable = false,name = "is_completed", columnDefinition = "TINYINT(1)")
	boolean is_completed;

	public long getTracking_order_id() {
		return tracking_order_id;
	}

	public void setTracking_order_id(long tracking_order_id) {
		this.tracking_order_id = tracking_order_id;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public Date getShip_date() {
		return ship_date;
	}

	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}

	public String getFrom_city() {
		return from_city;
	}

	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}

	public String getTo_city() {
		return to_city;
	}

	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isIs_completed() {
		return is_completed;
	}

	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	
	

}
