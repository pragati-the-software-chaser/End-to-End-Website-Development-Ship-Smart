package edu.msu.shipsmart.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_sign_up")
public class CustomerSignUp {
	
	@Id
	@Column(name = "customer_email", table= "customer_sign_up")
	private String customer_email;
	
	@Column(name = "customer_pass", table= "customer_sign_up")
	private String customer_pass;
	
	@Column(name = "first_name", table= "customer_sign_up")
	private String first_name;
	
	@Column(name = "last_name", table= "customer_sign_up")
	private String last_name;
	
	

	public CustomerSignUp() {
		super();
	
	}

	public CustomerSignUp(String customer_email, String customer_pass, String first_name, String last_name) {
		super();
		this.customer_email = customer_email;
		this.customer_pass = customer_pass;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_pass() {
		return customer_pass;
	}

	public void setCustomer_pass(String customer_pass) {
		this.customer_pass = customer_pass;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "CustomerSignUp [customer_email=" + customer_email + ", customer_pass=" + customer_pass + ", first_name="
				+ first_name + ", last_name=" + last_name + "]";
	}
	
	

}
