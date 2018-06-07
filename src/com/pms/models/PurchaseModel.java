package com.pms.models;

import java.sql.Timestamp;

public class PurchaseModel extends Model implements java.io.Serializable {

    private Integer purchaseId;
    private CompanyModel companyModel;
    private double Commisson;

    public Integer getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(Integer purchaseNo) {
        this.purchaseNo = purchaseNo;
    }
    private String comment;
    private Timestamp purchaseDate;
    private Integer purchaseNumber;
    private double discount;
    private Integer purchaseNo;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    private Double total;

    public CommisionTypeModel getComissonModel() {
        return comissonModel;
    }

    public void setComissonModel(CommisionTypeModel comissonModel) {
        this.comissonModel = comissonModel;
    }
    private double amountPaid;
    private DealerModel dealorModel;
    private CommisionTypeModel comissonModel;
    //private ComissonModel

    public DealerModel getDealorModel() {
        return dealorModel;
    }

    public void setDealorModel(DealerModel dealorModel) {
        this.dealorModel = dealorModel;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public double getCommisson() {
        return Commisson;
    }

    public void setCommisson(double Commisson) {
        this.Commisson = Commisson;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
