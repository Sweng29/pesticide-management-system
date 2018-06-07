/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.models;

import java.sql.Timestamp;

/**
 *
 * @author farhan baloch
 */
import java.sql.Time;
import java.sql.Date;
public class ProductModel  extends Model implements java.io.Serializable {
private  Integer productId;
private CompanyModel companyModel;
private String productName;
private Double cost;
private Double price;
private Integer quantity;
private UnitModel unitModel;
private Integer number;
private Timestamp expiryDate;

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp timestamp) {
        this.expiryDate = timestamp;
        System.out.println (this.expiryDate);
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public UnitModel getUnitModel() {
        return unitModel;
    }

    public void setUnitModel(UnitModel unitModel) {
        this.unitModel = unitModel;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

  
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    





}
