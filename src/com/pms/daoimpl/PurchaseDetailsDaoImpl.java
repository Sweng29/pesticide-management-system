
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.PurchaseDetaisDao;
import com.pms.models.ProductModel;
import com.pms.models.PurchaseDetailsModel;
import com.pms.models.PurchaseModel;
import com.pms.models.UnitModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class PurchaseDetailsDaoImpl implements PurchaseDetaisDao {

    @Override
    public int insertPurchaseDetailsInfo(PurchaseDetailsModel purchaseDetailsModel) {
    int row=0;
        try{
String query = "INSERT INTO `purchase_detail` (`purchase_id`,`product_id`,`quantity`,rate,`unit_id`,`created_by`,`created_date`,`modified_by`,`modified_date`,active) VALUES (?,?,?,?,?,?,?,?,?,?)";        
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, purchaseDetailsModel.getPurchaseModel().getPurchaseId());
        System.out.println(purchaseDetailsModel.getPurchaseModel().getPurchaseId());
        preparedStatement.setInt(2, purchaseDetailsModel.getProductModel().getProductId());
        preparedStatement.setInt(3, purchaseDetailsModel.getQuantity());
        preparedStatement.setDouble(4, purchaseDetailsModel.getRate());
        preparedStatement.setInt(5, purchaseDetailsModel.getUnitModel().getUnitId());
        preparedStatement.setInt(6, purchaseDetailsModel.getCreatedBy().getUserId());
        preparedStatement.setTimestamp(7, purchaseDetailsModel.getCreatedDate());
        preparedStatement.setInt(8, purchaseDetailsModel.getModifiedBy().getUserId());
        preparedStatement.setTimestamp(9, purchaseDetailsModel.getModifiedDate());
        preparedStatement.setBoolean(10, purchaseDetailsModel.getActive());
    
         row = preparedStatement.executeUpdate();
    }catch(Exception e){
    e.printStackTrace();
    } 
    return row;
    }

    @Override
    public List<PurchaseDetailsModel> getAllPurchaseInfo(Integer orderNo) {
    List<PurchaseDetailsModel> detailsModels = new ArrayList<>();
        try{
    String query = "SELECT `purchase_detail`.`purchase_detail_id` , purchase_detail.`purchase_id` , product.`name` , `purchase_detail`.`quantity` , `purchase_detail`.`rate`, unit.`name` FROM `purchase_detail` JOIN `product` ON(product.`product_id` = `purchase_detail`.`product_id`) JOIN unit ON(unit.`unit_id` = `purchase_detail`.`unit_id`) JOIN purchase ON(purchase.`purchase_id` = `purchase_detail`.`purchase_id`) WHERE purchase.`purchase_no` = ?";
   PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
   preparedStatement.setInt(1, orderNo);
   ResultSet resultSet = preparedStatement.executeQuery();
   while(resultSet.next()){
   PurchaseDetailsModel purchaseDetailsModel = new PurchaseDetailsModel();
   ProductModel productModel = new ProductModel();
   productModel.setProductName(resultSet.getString("name"));
   purchaseDetailsModel.setProductModel(productModel);
  purchaseDetailsModel.setProductDetailId(Integer.parseInt(resultSet.getString(1)));
  PurchaseModel purchaseModel = new PurchaseModel();
  purchaseModel.setPurchaseId(Integer.parseInt(resultSet.getString(2)));
  purchaseDetailsModel.setPurchaseModel(purchaseModel);
  purchaseDetailsModel.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
  purchaseDetailsModel.setRate(resultSet.getDouble("rate"));
  UnitModel unitModel = new UnitModel();
  unitModel.setUnitName(resultSet.getString(6));
  purchaseDetailsModel.setUnitModel(unitModel);
       detailsModels.add(purchaseDetailsModel);
   }
        }catch(Exception e){
    e.printStackTrace();
    }
    
    return detailsModels;
    }

    @Override
    public Integer getCommisionMonths(Integer purchaseId) {
       Integer months = 0;
        try{
         PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT TIMESTAMPDIFF(MONTH,`date`,?) FROM `purchase` where purchase_id = ?");
         ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
         ps.setInt(2, purchaseId);
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
    

