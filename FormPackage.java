package edu.msu.shipsmart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "form_package")
public class FormPackage {
	
	@Id
    @Column(name = "order_id") 
    private Long orderId;

	@Column(name = "package_type")
	private String packageType;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "length")
	private Double length;

	@Column(name = "width")
	private Double width;
	
	@Column(name = "height")
	private Double height;
	
	@Column(name = "declared_value")
	private String declaredValue;
	
	@Column(nullable = false,name = "signature", columnDefinition = "TINYINT(1)")
	private boolean signature;
	
	@Column(nullable = false,name = "email_notifications", columnDefinition = "TINYINT(1)")
	private boolean email_notifications;
	
	@Column(nullable = false,name = "phone_notifications", columnDefinition = "TINYINT(1)")
	private boolean phone_notifications;
	
	  
	

	
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



	public String getPackageType() {
		return packageType;
	}



	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}



	public Double getWeight() {
		return weight;
	}



	public void setWeight(Double weight) {
		this.weight = weight;
	}



	public Double getLength() {
		return length;
	}



	public void setLength(Double length) {
		this.length = length;
	}



	public Double getWidth() {
		return width;
	}



	public void setWidth(Double width) {
		this.width = width;
	}



	public Double getHeight() {
		return height;
	}



	public void setHeight(Double height) {
		this.height = height;
	}



	public String getDeclaredValue() {
		return declaredValue;
	}



	public void setDeclaredValue(String declaredValue) {
		this.declaredValue = declaredValue;
	}





	public boolean isSignature() {
		return signature;
	}



	public void setSignature(boolean signature) {
		this.signature = signature;
	}



	public boolean isEmail_notifications() {
		return email_notifications;
	}



	public void setEmail_notifications(boolean email_notifications) {
		this.email_notifications = email_notifications;
	}



	public boolean isPhone_notifications() {
		return phone_notifications;
	}



	public void setPhone_notifications(boolean phone_notifications) {
		this.phone_notifications = phone_notifications;
	}



	public UserOrder getUserOrder() {
		return userOrder;
	}



	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	
	

}