/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.ProductDAO;
import com.pms.models.CompanyModel;
import com.pms.models.ProductModel;
import com.pms.models.RecieptModel;

import com.pms.models.UnitModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhan baloch
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public ProductModel getProductWithId(Integer prodcutId) {
      ProductModel productModel = null;
      try
      {
          Connection con = DBConnection.getConnection();
          PreparedStatement stmt = con.prepareStatement("select * from product where product_id=? and active=1");
          stmt.setInt(1, prodcutId);
          ResultSet set = stmt.executeQuery();
          while(set.next())
          {
           productModel = new ProductModel();
           productModel.setProductId(set.getInt(1));
      CompanyDAOImpl company = new CompanyDAOImpl();

           CompanyModel company2 = company.getCompanyWithId(Integer.parseInt(set.getString(2)));
       productModel.setCompanyModel(company2);
     
           productModel.setProductName(set.getString(3));
      
           productModel.setCost(set.getDouble(4));
           productModel.setPrice(set.getDouble(5));
           productModel.setQuantity(set.getInt(6));
        UnitDAOImpl unitDAOImpl = new UnitDAOImpl();
          UnitModel unitModel = unitDAOImpl.getUnitWithId(Integer.parseInt(set.getString(7)));
          productModel.setUnitModel(unitModel);
          productModel.setNumber(set.getInt(8));
           productModel.setExpiryDate(Timestamp.valueOf(set.getString(9)));
           productModel.setCreatedBy(new UserDAOImpl().getUserWithId(set.getInt(10)));
           productModel.setCreatedDate(set.getTimestamp(11));
           productModel.setModifiedBy(new UserDAOImpl().getUserWithId(set.getInt(12)));
           productModel.setModifiedDate(set.getTimestamp(13));
           productModel.setActive(set.getBoolean(14));
           
          }
      }
    catch(Exception e)
    {
        e.getMessage();
    }
    return productModel;  
    }

    @Override
    public List<ProductModel> getAllProduct() {
     List<ProductModel> productModelList = new ArrayList<>();
     try
     {
       Connection con = DBConnection.getConnection();
       PreparedStatement stmt = con.prepareStatement("select * from product where active = 1");
       ResultSet set = stmt.executeQuery();
       Integer count = 0;
       
       while(set.next())
       {
        ProductModel productModel = new ProductModel();
        productModel.setProductId(set.getInt(1));
        CompanyModel companyModel = new CompanyDAOImpl().getCompanyWithId(set.getInt(2));
        productModel.setCompanyModel(companyModel);
        productModel.setProductName(set.getString(3));
        productModel.setCost(set.getDouble(4));
        productModel.setPrice(set.getDouble(5));
        productModel.setQuantity(set.getInt(6));
        UnitModel unitModel = new UnitDAOImpl().getUnitWithId(Integer.parseInt(set.getString(7)));
        productModel.setUnitModel(unitModel);
        productModel.setNumber(set.getInt(8));
        productModel.setExpiryDate(Timestamp.valueOf(set.getString(9)));
        productModel.setCreatedBy(new UserDAOImpl().getUserWithId(set.getInt(10)));
        productModel.setCreatedDate(set.getTimestamp(11));
        productModel.setModifiedBy(new UserDAOImpl().getUserWithId(set.getInt(12)));
        productModel.setModifiedDate(set.getTimestamp(13));
        productModelList.add(productModel);  
        
       }
       
     }
   catch(Exception e)
   {
     e.getMessage();
   }
    return productModelList; 
    }

    @Override
    public Integer deleteProduct(ProductModel productModel) {
    int row=0;
    
    try
    {
      Connection con = DBConnection.getConnection();
      PreparedStatement stmt = con.prepareStatement("UPDATE product SET product.`active`=? WHERE product.`product_id`=?" );
      stmt.setBoolean(1, productModel.getActive());
      stmt.setInt(2, productModel.getProductId());
      
      row=stmt.executeUpdate();
   
    }
   catch(Exception e)
   {
       e.printStackTrace();
   }
    return row;    
    }

    @Override
    public Integer updateProduct(ProductModel productModel) {
     int row=0;
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("update product set product.`name`=?,product.`company_id`=?,product.`cost`=?,product.`price`=?,product.`quantity`=?,product.`unit_id`=?,product.`number`=?,expiry_date=?,modified_by=?,modified_date=?,active=? where product_id=?");
         stmt.setString(1, productModel.getProductName());
         CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
         stmt.setInt(2, companyDAOImpl.getCompanyId(productModel.getCompanyModel().getName()));
         stmt.setDouble(3, productModel.getCost());
         stmt.setDouble(4,productModel.getPrice());
         stmt.setInt(5, productModel.getQuantity());
         UnitDAOImpl unitDAOImpl = new UnitDAOImpl();
         stmt.setInt(6, unitDAOImpl.getUnitId(productModel.getUnitModel().getUnitName()));
         stmt.setInt(7, productModel.getNumber());
         stmt.setTimestamp(8, productModel.getExpiryDate());
         stmt.setInt(9,productModel.getModifiedBy().getUserId());
         stmt.setTimestamp(10,productModel.getModifiedDate());
         stmt.setBoolean(11,productModel.getActive());
         stmt.setInt(12,productModel.getProductId());
         row =stmt.executeUpdate();
         
         
     }
     catch(Exception e)
     {
      e.printStackTrace();
     }    
     return row;   
    }
    @Override
 public Integer addProduct(ProductModel productModel)
 {
   int row=0;
   try
   {
     Connection con = DBConnection.getConnection();
     PreparedStatement stmt = con.prepareStatement("insert into product(company_id,name,cost,price,quantity,unit_id,number,expiry_date,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
     CompanyDAOImpl companyDAOImpl = new CompanyDAOImpl();
     stmt.setInt(1,companyDAOImpl.getCompanyId(productModel.getCompanyModel().getName()) );
     stmt.setString(2, productModel.getProductName());
     System.out.println(companyDAOImpl.getCompanyId(productModel.getCompanyModel().getName()) );
     stmt.setDouble(3, productModel.getCost());
     stmt.setDouble(4, productModel.getPrice());
     stmt.setInt(5, productModel.getQuantity());
     UnitDAOImpl unitDAOImpl = new UnitDAOImpl();
     stmt.setInt(6,unitDAOImpl.getUnitId(productModel.getUnitModel().getUnitName()));
     stmt.setInt(7, productModel.getNumber());
     stmt.setTimestamp(8,productModel.getExpiryDate());
     stmt.setInt(9, productModel.getCreatedBy().getUserId());
     stmt.setTimestamp(10, productModel.getCreatedDate());
     stmt.setInt(11, productModel.getModifiedBy().getUserId());
     stmt.setTimestamp(12, productModel.getModifiedDate());
     stmt.setInt(13, 1);
     row=stmt.executeUpdate();
   }    
 catch(Exception e)
 {
     e.printStackTrace();
 }
 return row;    
 }  

    @Override

    
    public int getProductId(String productName) {
       int productId = 0;
        try{
        String query = "select product_id from product where name = ?";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, productName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        productId = Integer.parseInt(resultSet.getString(1));
        }
        }catch(Exception e){
        e.printStackTrace();
        }
return productId;
    }

    @Override
    public int updateProductQuantity(ProductModel productModel) {
    int row = 0;
    try{
    
        String query = "UPDATE product SET quantity = ? WHERE `product_id`=? ";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, productModel.getQuantity());
        preparedStatement.setInt(2,productModel.getProductId());
        row = preparedStatement.executeUpdate();
        
    }catch(Exception e){
    e.printStackTrace();
    }
        
    return row;
    }
      @Override
    public void updateProductsStock(List<RecieptModel> list) {
         
      
      for(RecieptModel recieptList:list){
          PreparedStatement ps;
          try {
              ps = DBConnection.getConnection().prepareStatement("Update product set quantity = quantity - "+recieptList.getQuantity()+" where name = ? AND active = 1");
              
              ps.setString(1, recieptList.getProduct());
              ps.executeUpdate();
          } catch (Exception ex) {
             // Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
          }   
        } 
    }
     
    }
 

   

