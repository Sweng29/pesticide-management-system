/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.OrderDetailsModel;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface OrderDetailsDAO {
    
    public List<OrderDetailsModel> getOrderDetailsWithId(Integer orderDetailId);
    public List<OrderDetailsModel> getAllOrderDetails();
    public Integer deleteOrderDetail(OrderDetailsModel orderDetailModel);
    public Integer updateOrderDetail(OrderDetailsModel orderDetailModel);
    public Integer addOrderDetail(OrderDetailsModel orderDetailModel);
    public Integer getCommisionMonths(Integer orderId);
}
