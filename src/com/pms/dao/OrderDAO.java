/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.OrderModel;
import java.util.List;

/**
 *
 * @author farhan baloch
 */
public interface OrderDAO {
    public OrderModel getOrderWithId(Integer orderId);
    public List<OrderModel> getAllOrders();
    public Integer deleteOrder(OrderModel orderModel);
    public Integer updateOrder(OrderModel orderModel);  
    public Integer addOrder(OrderModel orderModel);
    public boolean checkOrderNo(int orderNo);
    public Integer getLastOrderId();
}
