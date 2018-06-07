/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.OrderDAO;
import com.pms.models.OrderModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhan baloch
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public OrderModel getOrderWithId(Integer orderId) {
     OrderModel orderModel= null;
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("select * from `order` where order_id=? and active=1");
         stmt.setInt(1, orderId);
         ResultSet set = stmt.executeQuery();
         if(set.next())
         {
          orderModel = new OrderModel();
          orderModel.setOrderId(set.getInt(1));
          orderModel.setOrderNo(set.getInt(2));
          orderModel.setCustomer(new CustomerDAOImpl().getCustomerWithId(set.getInt(3)));
          orderModel.setAmountPaid(set.getDouble(4));
          orderModel.setComment(set.getString(5));
          orderModel.setTime(set.getTimestamp(6));
          orderModel.setCommision(set.getDouble(7));
          orderModel.setCommisionType(new CommisionDAOImpl().getCommisionTypeWithId(set.getInt(8)));
          orderModel.setDiscount(set.getDouble(9));
//  orderModel.setCreatedBy(set.getInt(6));
        //  orderModel.setCreatedDate(set.getTimestamp(7));
        //  orderModel.setModifiedBy(set.getInt(8));
        //  orderModel.setModifiedDate(set.getTimestamp(9));
          orderModel.setActive(set.getBoolean(14));
          
          
         }
     }
    catch(Exception e)
    {
      e.getMessage();
        
    }
     return orderModel;
        
    }

    @Override
    public List<OrderModel> getAllOrders() {
        OrderModel orderModel= null;
     List<OrderModel> orderModelList = new ArrayList<>();
     try
     {
       Connection con = DBConnection.getConnection();
       PreparedStatement  stmt = con.prepareStatement("select * from `order` where active = 1");
       ResultSet set = stmt.executeQuery();
       while(set.next())
       {
         orderModel = new OrderModel();
          orderModel.setOrderId(set.getInt(1));
          orderModel.setOrderNo(set.getInt(2));
          orderModel.setCustomer(new CustomerDAOImpl().getCustomerWithId(set.getInt(3)));
          
          orderModel.setAmountPaid(set.getDouble(4));
          orderModel.setComment(set.getString(5));
          orderModel.setTime(set.getTimestamp(6));
          orderModel.setCommision(set.getDouble(7));
          orderModel.setCommisionType(new CommisionDAOImpl().getCommisionTypeWithId(set.getInt(8))); 
          orderModel.setDiscount(set.getDouble(9));
          orderModel.setCreatedBy(new UserDAOImpl().getUserWithId(set.getInt(10)));
          orderModel.setCreatedDate(set.getTimestamp(11));
          orderModel.setModifiedBy(new UserDAOImpl().getUserWithId(set.getInt(12)));
          orderModel.setModifiedDate(set.getTimestamp(13));
          orderModel.setActive(set.getBoolean(14));
           
          orderModelList.add(orderModel);
       }
     }
   catch(Exception e)
   {
    e.getMessage();
       
   }
     return orderModelList;
    }

    @Override
    public Integer deleteOrder(OrderModel orderModel) {
    int row=0;
    
    try
    {
      Connection con = DBConnection.getConnection();
      PreparedStatement stmt = con.prepareStatement("UPDATE order SET order.`active`=0 WHERE order.`order_id`=?" );
      stmt.setInt(1,orderModel.getOrderId());
      row=stmt.executeUpdate();
   
    }
   catch(Exception e)
   {
       e.printStackTrace();
   }
  return row;
        
    }

    @Override
    public Integer updateOrder(OrderModel orderModel) {
     
    int row=0;
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("update order set customer_id=?,amount_paid=?,COMMENT=?,TIME=?,created_by=?,created_date=?,modified_by=?,modified_date=?,active=? where order_id=?");
     //    stmt.setInt(1, orderModel.getCustomerId());
         stmt.setDouble(2, orderModel.getAmountPaid());
         stmt.setString(3,orderModel.getComment());
         stmt.setTimestamp(4, orderModel.getTime());
   //      stmt.setInt(5,orderModel.getCreatedBy());
         stmt.setTimestamp(6,orderModel.getCreatedDate());
    //     stmt.setInt(7,orderModel.getModifiedBy());
         stmt.setTimestamp(8,orderModel.getModifiedDate());
         stmt.setBoolean(9,orderModel.getActive());
         stmt.setInt(10,orderModel.getOrderId() );
    row =stmt.executeUpdate();
         
         
     }
     catch(Exception e)
     {
      e.getMessage();
     }    
     return row;    
    }
   
    public boolean checkOrderNo(int orderNo){
       
       try{
           PreparedStatement ps = DBConnection.getConnection().prepareStatement("Select * from `order` where order_no = ?");
           ps.setInt(1, orderNo);
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()){
               return true;
           }
       }
       catch(Exception E){
           E.printStackTrace();
       }
       
       
       return false;
   }

    @Override
    public Integer addOrder(OrderModel orderModel) {
        CommisionDAOImpl obj = new CommisionDAOImpl();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Insert into `order`(order_no,customer_id,amount_paid,comment,date,comission,comission_id,discount,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, orderModel.getOrderNo());
            ps.setInt(2,orderModel.getCustomer().getCustomerId());
            ps.setDouble(3, orderModel.getAmountPaid());
            ps.setString(4, orderModel.getComment());
            ps.setTimestamp(5, orderModel.getTime());
            ps.setDouble(6, orderModel.getCommision());
            ps.setInt(7,obj.getCommisionIdWithType(orderModel.getCommisionType().getCommisionType()));
            ps.setDouble(8, orderModel.getDiscount());
            ps.setInt(9, orderModel.getCreatedBy().getUserId());
            ps.setTimestamp(10, orderModel.getCreatedDate());
            ps.setInt(11, orderModel.getModifiedBy().getUserId());
            ps.setTimestamp(12, orderModel.getModifiedDate());
            ps.setInt(13, 1);
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public Integer getLastOrderId() {
        
       try{
           PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM `order` ORDER BY order_id DESC LIMIT 1");
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()){
               return rs.getInt(1);
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return -1;
   }
    
    
    

}
