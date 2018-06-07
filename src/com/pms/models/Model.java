package com.pms.models;

import java.sql.Timestamp;

public class Model {
	private UserModel createdBy;
	private Timestamp createdDate;
	private UserModel modifiedBy;
	private Timestamp modifiedDate;
	private Boolean active;

	public Model() {
	}

	public UserModel getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserModel createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public UserModel getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserModel modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}