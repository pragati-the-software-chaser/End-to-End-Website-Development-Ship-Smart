package edu.msu.shipsmart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin_users_extn")
public class AdminUserExtn {

	@Column(name = "employee_id", table = "admin_users_extn")
	private long employeeId;
	
	@Id
    @Column(name = "user_id")
    private long userId;

	/*
	 * @OneToOne(mappedBy = "admin_users_extn") private SignedUser signedUser;
	 */

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private SignedUser signedUser;

	public AdminUserExtn() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AdminUserExtn(long employeeId, long userId, SignedUser signedUser) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.signedUser = signedUser;
	}


	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public SignedUser getSignedUser() {
		return signedUser;
	}

	public void setSignedUser(SignedUser signedUser) {
		this.signedUser = signedUser;
	}

	@Override
	public String toString() {
		return "AdminUserExtn [employeeId=" + employeeId + ", userId=" + userId + ", signedUser=" + signedUser + "]";
	}
	
	

}
