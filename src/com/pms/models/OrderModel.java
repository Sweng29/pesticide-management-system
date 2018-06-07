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
public class OrderModel  extends Model implements java.io.Serializable{
    
    private Integer orderId;
    private Integer orderNo;
    private Double amountPaid;
    private String comment;
    private Timestamp time;
    private double commision;
    private CommisionTypeModel commisionType;
    private double discount;
    private CustomerModel customer;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
    
    
    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public CommisionTypeModel getCommisionType() {
        return commisionType;
    }

    public void setCommisionType(CommisionTypeModel commisionType) {
        this.commisionType = commisionType;
    }
  

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

        



}
