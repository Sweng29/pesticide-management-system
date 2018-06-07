
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.DealerDao;
import com.pms.models.DealerModel;
import com.pms.models.Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DealerDaoImpl implements DealerDao {

    @Override
    public DealerModel getDealerModelWithId(Integer dealerId) {
  DealerModel dealerModel = null;
        try{
    
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("SELECT * FROM customer WHERE TYPE = 'Dealer'");
        ResultSet resultSet = preparedStatement.executeQuery();
       while(resultSet.next()){
           String name = resultSet.getString("name");
           String contact = resultSet.getString("contact");
           dealerModel = new DealerModel(name,contact);
       
       
       } 
    }catch(Exception e){
    e.printStackTrace();
    }   
    return dealerModel;
    }
    

    @Override
    public List<DealerModel> getDealerDetails() {
    List<DealerModel> dealers = new ArrayList<>();
    System.out.println("asif");
    try{
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Select * from customer where type = 'Dealer' and active = 1 ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        DealerModel dealerModel = new DealerModel();
        dealerModel.setCustomerId(Integer.parseInt(resultSet.getString("customer_id")));
        dealerModel.setDealerName(resultSet.getString("name"));
        dealerModel.setContact(resultSet.getString("contact"));
       dealerModel.setCreatedBy(new UserDAOImpl().getUserWithId(resultSet.getInt("created_by")));
        dealerModel.setModifiedBy(new UserDAOImpl().getUserWithId(resultSet.getInt("modified_by")));
        dealerModel.setCreatedDate(Timestamp.valueOf(resultSet.getString("created_date")));
        dealerModel.setModifiedDate(Timestamp.valueOf(resultSet.getString("modified_date")));
        
        
        dealers.add(dealerModel);
        }
        
    }catch(Exception e){
    e.printStackTrace();
    }
    
    return dealers;
    }

    @Override
    public int addDealer(DealerModel dealerModel) {
    int row = 0;
        try{
String query = "INSERT INTO customer (customer.`type`,customer.`name`,contact , `created_by`,`created_date`,`modified_by`,`modified_date`,active) VALUES (?,?,?,?,?,?,?,?)";
  PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
  preparedStatement.setString(1,"Dealer");
  preparedStatement.setString(2, dealerModel.getDealerName());
  preparedStatement.setString(3, dealerModel.getContact());
  preparedStatement.setInt(4, dealerModel.getCreatedBy().getUserId());
  preparedStatement.setTimestamp(5, dealerModel.getCreatedDate());
  preparedStatement.setInt(6, dealerModel.getModifiedBy().getUserId());
  preparedStatement.setTimestamp(7, dealerModel.getModifiedDate());
  preparedStatement.setBoolean(8, dealerModel.getActive());
  
    row = preparedStatement.executeUpdate();
}catch(Exception e){
e.printStackTrace();
}
        
        return row;
   
    }
    
        
        
    

    @Override
    public int updateDealer(DealerModel dealerModel) {
           int row = 0;
        try{
        String query = "UPDATE  customer SET customer.`name` = ? , customer.`contact` = ? , customer.`modified_by` = ? , customer.`modified_date` = ? WHERE customer_id = ?";
       PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
       preparedStatement.setString(1, dealerModel.getDealerName());
       preparedStatement.setString(2, dealerModel.getContact());
       preparedStatement.setInt(3, dealerModel.getModifiedBy().getUserId());
       preparedStatement.setTimestamp(4, dealerModel.getModifiedDate());
       preparedStatement.setInt(5, dealerModel.getCustomerId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e){
        e.printStackTrace();
        }
        
        return row;    
  
    }

    @Override
    public int deleteDealer(DealerModel dealerModel) {
     int row = 0;
try{
String query = "UPDATE customer SET customer.`active` = ? WHERE customer_id = ?";
PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
preparedStatement.setBoolean(1, dealerModel.getActive());
preparedStatement.setInt(2, dealerModel.getCustomerId());
    row = preparedStatement.executeUpdate();
}catch(Exception e){
e.printStackTrace();
}
return row;
    }

    @Override
    public int getDealerIdWithName(String name) {
        int dealerId = 0;
        try{
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("SELECT customer_id FROM customer WHERE TYPE = 'Dealer' AND NAME = ? ");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        dealerId = Integer.parseInt(resultSet.getString(1));
        }
        }catch(Exception e){
        e.printStackTrace();
        }
return dealerId;
    }
}
    

