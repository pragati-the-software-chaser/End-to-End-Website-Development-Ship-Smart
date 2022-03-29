package edu.msu.shipsmart.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_promo_code")
public class FormPromoCode {
	
	@Id
    @Column(name = "promo_code") 
    private String promo_code;

	@Column(name = "discount")
	private String discount;
	
	@Column(name = "price_limit")
	private String price_limit;

	public String getPromo_code() {
		return promo_code;
	}

	public void setPromo_code(String promo_code) {
		this.promo_code = promo_code;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPrice_limit() {
		return price_limit;
	}

	public void setPrice_limit(String price_limit) {
		this.price_limit = price_limit;
	}

	@Override
	public String toString() {
		return "FormPromoCode [promo_code=" + promo_code + ", discount=" + discount + ", price_limit=" + price_limit
				+ "]";
	}
	
	

}
