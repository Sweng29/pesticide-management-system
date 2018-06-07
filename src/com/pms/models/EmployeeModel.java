package com.pms.models;

import com.pms.models.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class EmployeeModel extends Model implements Serializable{

	private static final long serialVersionUID = -4035907657454869541L;

	private Integer employeeId;
	private String officerName;
	private String cnic;
	//private Long personnelNumber;
	//private Timestamp appointmentDate;
	private Timestamp birthDate;
	//private Timestamp retirementDate;
	//private Timestamp regularAppointementDate;
	//private Timestamp presentPostingDate;
	//private Timestamp lastPromotionDate;
	//private Long seniorityNumber;
	
	//private String cadre;
	private String homeAddress;
	private String mobileNumber;
	private byte[] photo;
	//private String filePath;
	//private Timestamp fileUploadedDate;
        // my code start
        
        private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        
        
       
       

          //my code end
  
        
        
        
  
	// ############################### All associated objects (many-to-one) Go here #################################################
	
        // ############################### All associated objects (one-to-one) Go here #################################################

	// ############################### All associated collections (one-to-many) go here #################################################
	
        public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	/*public Long getPersonnelNumber() {
		return personnelNumber;
	}

	public void setPersonnelNumber(Long personnelNumber) {
		this.personnelNumber = personnelNumber;
	}

	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Timestamp appointmentDate) {
		this.appointmentDate = appointmentDate;
	} */

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

/*
	public String getCadre() {
		return cadre;
	}

	public void setCadre(String cadre) {
		this.cadre = cadre;
	}
  */
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

/*	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Timestamp getFileUploadedDate() {
		return fileUploadedDate;
	}

	public void setFileUploadedDate(Timestamp fileUploadedDate) {
		this.fileUploadedDate = fileUploadedDate;
	}

	public Timestamp getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Timestamp retirementDate) {
		this.retirementDate = retirementDate;
	}
	public Timestamp getRegularAppointementDate() {
		return regularAppointementDate;
	}

	public void setRegularAppointementDate(Timestamp regularAppointementDate) {
		this.regularAppointementDate = regularAppointementDate;
	}

	public Timestamp getLastPromotionDate() {
		return lastPromotionDate;
	}

	public void setLastPromotionDate(Timestamp lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}

	public Long getSeniorityNumber() {
		return seniorityNumber;
	}

	public void setSeniorityNumber(Long seniorityNumber) {
		this.seniorityNumber = seniorityNumber;
	}
        
        public Timestamp getPresentPostingDate() {
		return presentPostingDate;
	}

	public void setPresentPostingDate(Timestamp presentPostingDate) {
		this.presentPostingDate = presentPostingDate;
	}
              */

}
