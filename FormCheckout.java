package edu.msu.shipsmart.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "form_checkout")
public class FormCheckout {
	
	@Id
    @Column(name = "order_id") 
    private Long orderId;
    
	@Column(name = "delivery_date") 
	private Date deliveryDate;
	
	@Column(name = "delivery_price") 
	private double deliveryPrice;
	
	@Column(name = "promo_code") 
	private String promoCode;
	
	@Column(name = "total_amount") 
	private double totalAmount;
	
	@Column(name = "credit_card") 
	private int creditCardFlag;
	
	@Column(name = "debit_card") 
	private int debitCardFlag;
	
	@Column(name = "paypal") 
	private int paypalFlag;
	
	@Column(name = "name_on_the_card") 
	private String nameOnTheCard;
	
	@Column(name = "card_number") 
	private String cardNumber;
	
	@Column(name = "exp_date") 
	private String expDate;
	
	@Column(name = "cvv") 
	private Long cvv;
	
	@Transient
	private String deliveryType;
	


	@Transient
	private String paymentType;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "order_id")
	private UserOrder userOrder;


	public String getPaymentType() {
		if( paymentType !=null) return this.paymentType;
		if(this.debitCardFlag==1) return "debit";
		
		return "credit";
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		if("credit".equals(paymentType))this.creditCardFlag=1;
		if("debit".equals(paymentType))this.debitCardFlag=1;
	}

	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public double getDeliveryPrice() {
		return deliveryPrice;
	}


	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}


	public String getPromoCode() {
		return promoCode;
	}


	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public int getCreditCardFlag() {
		return creditCardFlag;
	}


	public void setCreditCardFlag(int creditCardFlag) {
		this.creditCardFlag = creditCardFlag;
	}


	public int getDebitCardFlag() {
		return debitCardFlag;
	}


	public void setDebitCardFlag(int debitCardFlag) {
		this.debitCardFlag = debitCardFlag;
	}


	public int getPaypalFlag() {
		return paypalFlag;
	}


	public void setPaypalFlag(int paypalFlag) {
		this.paypalFlag = paypalFlag;
	}


	public String getNameOnTheCard() {
		return nameOnTheCard;
	}


	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExpDate() {
		return expDate;
	}


	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}


	public Long getCvv() {
		return cvv;
	}


	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}


	public String getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}


	public UserOrder getUserOrder() {
		return userOrder;
	}


	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	
	

	
}