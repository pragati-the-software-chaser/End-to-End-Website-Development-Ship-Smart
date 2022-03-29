package edu.msu.shipsmart.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "signed_users")
public class SignedUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", table = "signed_users")
	private long userId;

	@Column(name = "first_name", table = "signed_users")
	private String firstName;

	@Column(name = "last_name", table = "signed_users")
	private String lastName;

	@Column(name = "email", table = "signed_users")
	private String email;

	@Column(name = "password", table = "signed_users")
	private String password;

	@Column(name = "is_admin", table = "signed_users")
	private String is_admin;

	@Transient
	private Long employeeId;
	
	@OneToOne(mappedBy = "signedUser", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AdminUserExtn admin;
	
	public SignedUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignedUser(long userId, String firstName, String lastName, String email, String password, String is_admin,
			AdminUserExtn admin,Long employeeId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.is_admin = is_admin;
		this.admin = admin;
		this.employeeId=employeeId;
	}

	public AdminUserExtn getAdmin() {
		return admin;
	}

	public void setAdmin(AdminUserExtn admin) {
		this.admin = admin;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "SignedUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", is_admin=" + is_admin + ", employeeId=" + employeeId
				+ ", admin=" + admin + "]";
	}



}
