
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.PurchaseDao;
import com.pms.models.CommisionTypeModel;
import com.pms.models.CompanyModel;
import com.pms.models.DealerModel;
import com.pms.models.PurchaseModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class PurchaseDAOImpl implements PurchaseDao {

    
    public static int getPurchaseNo(){
    int purchaseNo = 0;
    try{
    String query = "SELECT purchase_no FROM purchase ORDER BY purchase_no DESC LIMIT 1";
    PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        
            purchaseNo = Integer.parseInt(resultSet.getString(1));
        }
        
    }catch(Exception e){
    e.printStackTrace();
    }
    if(purchaseNo==0){
    purchaseNo = 1000;
    }
    return purchaseNo;
    }

    @Override
    public int insertPurchaseData(PurchaseModel purchaseModel) {
        int row = 0;
    try{
    String query = "INSERT INTO purchase (purchase.`comission`,purchase.`comission_id`,purchase.`comment`,discount,purchase.`date`,purchase.`purchase_no`,purchase.`amount_paid`,purchase.`comapany_id`,purchase.`Dealer_id`,total,created_by,created_date,modified_by,modified_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
    preparedStatement.setDouble(1, purchaseModel.getCommisson());
    CommisionDAOImpl commisionDAOImpl = new CommisionDAOImpl();
    System.out.println(commisionDAOImpl.getCommisionIdWithType(purchaseModel.getComissonModel().getCommisionType() ));
    preparedStatement.setInt(2,commisionDAOImpl.getCommisionIdWithType(purchaseModel.getComissonModel().getCommisionType() ));
    preparedStatement.setString(3,purchaseModel.getComment());
    preparedStatement.setDouble(4, purchaseModel.getDiscount());
    preparedStatement.setTimestamp(5, purchaseModel.getPurchaseDate());
    preparedStatement.setInt(6, purchaseModel.getPurchaseNumber());
    preparedStatement.setDouble(7, purchaseModel.getAmountPaid());
    CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
    preparedStatement.setInt(8, companyDAOImpl.getCompanyId(purchaseModel.getCompanyModel().getName()));
    
    DealerDaoImpl dealerDaoImpl = new DealerDaoImpl();
    int dealerId = dealerDaoImpl.getDealerIdWithName(purchaseModel.getDealorModel().getDealerName());
    preparedStatement.setInt(9, dealerId);
    preparedStatement.setDouble(10, purchaseModel.getTotal());
   
   System.out.println(purchaseModel.getCreatedDate()+"The date is");
    preparedStatement.setInt(11, purchaseModel.getCreatedBy().getUserId());
    preparedStatement.setTimestamp(12, purchaseModel.getCreatedDate());
    preparedStatement.setInt(13, purchaseModel.getModifiedBy().getUserId());
    preparedStatement.setTimestamp(14, purchaseModel.getModifiedDate());
        row = preparedStatement.executeUpdate();
    }catch(Exception e){
    e.printStackTrace();
    }    
    return row;
    }

    @Override
    public int insertPurchaseDetailsData(PurchaseModel purchaseModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PurchaseModel> getPurchaseInfo() {
        List<PurchaseModel> purchaseList = new ArrayList<>();
        try{
    String query = "SELECT purchase_id , comission,purchase.`created_by`,purchase.`created_date`,purchase.`modified_by`,`purchase`.`modified_date` , commision.`commision_type` , purchase.`comment` , purchase.`discount` , purchase.date ,purchase.`purchase_no` , purchase.`amount_paid` ,company.`name` ,customer.`name` , purchase.`total`FROM purchase JOIN commision ON (purchase.`comission_id` = commision.`commision_id`) JOIN customer ON(purchase.`Dealer_id` = customer.`customer_id`)JOIN company ON(purchase.`comapany_id` = company.`company_id`) WHERE customer.`type` = 'Dealer'";    
    PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
    PurchaseModel purchaseModel = new PurchaseModel();
    purchaseModel.setPurchaseId(Integer.parseInt(resultSet.getString(1)));
    purchaseModel.setCommisson(resultSet.getDouble(2));
        CommisionTypeModel comissonModel = new CommisionTypeModel();
        purchaseModel.setCreatedBy(new UserDAOImpl().getUserWithId(resultSet.getInt(3)));
        purchaseModel.setCreatedDate(resultSet.getTimestamp(4));
        purchaseModel.setModifiedBy(new UserDAOImpl().getUserWithId(resultSet.getInt(5)));
        purchaseModel.setModifiedDate(resultSet.getTimestamp(6));
        comissonModel.setCommisionType(resultSet.getString(7));
        purchaseModel.setComissonModel(comissonModel);
        purchaseModel.setComment(resultSet.getString(8));
        purchaseModel.setDiscount(Double.parseDouble(resultSet.getString(9)));
        purchaseModel.setPurchaseDate(Timestamp.valueOf(resultSet.getString(10)));
        purchaseModel.setPurchaseNo(Integer.parseInt(resultSet.getString(11)));
        purchaseModel.setAmountPaid(resultSet.getDouble(12));
        CompanyModel companyModel = new CompanyModel();
        companyModel.setName(resultSet.getString(13));
        purchaseModel.setCompanyModel(companyModel);
        DealerModel dealorModel = new DealerModel();
        dealorModel.setDealerName(resultSet.getString(14));
        purchaseModel.setDealorModel(dealorModel);
        purchaseModel.setTotal(resultSet.getDouble(15));
        
        
    purchaseList.add(purchaseModel);
    
    }
            
            
        }catch(Exception e){
        e.printStackTrace();
        }
        
return purchaseList;
        
    }

    @Override
    public int getPurchaseId(Integer purchaseNo) {
        int purchaseId = 0;
        try{
        String query = "SELECT `purchase_id` FROM purchase WHERE `purchase_no` = ?";
         PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
         preparedStatement.setInt(1, purchaseNo);
         ResultSet resultSet = preparedStatement.executeQuery();
         while(resultSet.next()){
         purchaseId = Integer.parseInt(resultSet.getString(1));
         }
        }catch(Exception e){
        e.printStackTrace();
        }
return purchaseId;
    }

    
}
