/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.models;

/**
 *
 * @author farhan baloch
 */
public class OrderDetailsModel extends Model implements java.io.Serializable {
    
 private Integer detialId;
 private OrderModel orderModel;
 private  ProductModel productModel;
 private Integer quantity;
 private String comment;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
 
 
    public Integer getDetialId() {
        return detialId;
    }

    public void setDetialId(Integer detialId) {
        this.detialId = detialId;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel prductModel) {
        this.productModel = prductModel;
    }
 

    
}
