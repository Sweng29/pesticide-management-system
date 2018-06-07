/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.OrderDetailsDAO;
import com.pms.models.OrderDetailsModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class OrderDetailDAOImpl implements OrderDetailsDAO{

    @Override
    public List<OrderDetailsModel> getOrderDetailsWithId(Integer orderDetailId) {
        ArrayList<OrderDetailsModel> list = new ArrayList<>();
        OrderDetailsModel detailModel = null;
        try{
             PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM order_details WHERE order_id = ? AND active = ?");
             ps.setInt(1, orderDetailId);
             ps.setInt(2, 1);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 detailModel = new OrderDetailsModel();
                 detailModel.setDetialId(rs.getInt(1));
                 detailModel.setOrderModel(new OrderDAOImpl().getOrderWithId(rs.getInt(2)));
                 detailModel.setProductModel(new ProductDAOImpl().getProductWithId(rs.getInt(3)));
                 detailModel.setQuantity(rs.getInt(4));
                 
                 list.add(detailModel);
             }
         }
         catch(Exception e){
             
         }
        
        return list;
    }

    @Override
    public List<OrderDetailsModel> getAllOrderDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteOrderDetail(OrderDetailsModel orderDetailModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateOrderDetail(OrderDetailsModel orderDetailModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addOrderDetail(OrderDetailsModel orderDetailModel) {
         try{
           PreparedStatement ps = DBConnection.getConnection().prepareStatement("Insert into order_details(order_id,product_id,quantity,comment,active) values(?,?,?,?,?)");
           ps.setInt(1, orderDetailModel.getOrderModel().getOrderId());
           ps.setInt(2, orderDetailModel.getProductModel().getProductId());
           ps.setInt(3, orderDetailModel.getQuantity());
           ps.setString(4, "No Comment");
           ps.setInt(5, 1);
           
          return ps.executeUpdate();
       }
       catch(Exception e){
           e.printStackTrace();
       }
         return 0;
    }

    @Override
    public Integer getCommisionMonths(Integer orderId) {
      Integer months = 0;
        try{
         PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT TIMESTAMPDIFF(MONTH,`date`,?) FROM `order` where order_id = ?");
         ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
         ps.setInt(2, orderId);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()){
             months = rs.getInt(1);
         }
      }
      catch(Exception e){
          e.printStackTrace();
      }
        
        return months;
    }
    
    
}
