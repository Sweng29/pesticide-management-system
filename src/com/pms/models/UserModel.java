package com.pms.models;

import com.pms.models.EmployeeModel;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;



public class UserModel extends Model implements java.io.Serializable {

	private static final long serialVersionUID = -2408663793837527615L;

	private Integer userId;
        private RoleModel role;
	private String name;
	private String password;
	private Boolean activated;
	private Boolean authenticationFeature;
	private Timestamp passwordModifiedDate;
	private Timestamp blockedTill;
	private Integer noOfTries;
	private String location;
	private Boolean verifier;
        private EmployeeModel employee;
	
	
	// ############################### All associated objects (many-to-one) Go here #################################################
	
	
	


	// ############################### All associated objects (one-to-one) Go here #################################################
	
	
	// ############################### All associated collections (one-to-many) go here #################################################
	
	private Set<UserModel> users = new HashSet<UserModel>(0);

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String userPassword) {
		this.password = userPassword;
	}

	public Set<UserModel> getUsers() {
		return this.users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}

	

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public Timestamp getPasswordModifiedDate() {
		return passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Timestamp passwordModifiedDate) {
		this.passwordModifiedDate = passwordModifiedDate;
	}

	public Boolean getAuthenticationFeature() {
		return authenticationFeature;
	}

	public void setAuthenticationFeature(Boolean authenticationFeature) {
		this.authenticationFeature = authenticationFeature;
	}

	public Timestamp getBlockedTill() {
		return blockedTill;
	}

	public void setBlockedTill(Timestamp blockedTill) {
		this.blockedTill = blockedTill;
	}

	public Integer getNoOfTries() {
		return noOfTries;
	}

	public void setNoOfTries(Integer noOfTries) {
		this.noOfTries = noOfTries;
	}

	public Boolean getVerifier() {
		return verifier;
	}

	public void setVerifier(Boolean verifier) {
		this.verifier = verifier;
	}
        public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
