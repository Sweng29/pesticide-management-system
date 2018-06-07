/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;
import com.pms.connection.DBConnection;
import com.pms.dao.*;
import com.pms.models.EmployeeModel;
import com.pms.models.RoleModel;
import com.pms.models.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User1
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public UserModel checkLogin(String username, String password) {
        UserModel userModel = null;
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from user where name = ? AND password = ? AND active = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, 1);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                userModel = new UserModel();
                userModel.setUserId(rs.getInt(1));
                userModel.setRole(new RoleDAOImpl().getRoleWithId(rs.getInt(2)));
                userModel.setName(rs.getString(4));
                userModel.setPassword(rs.getString(5));
                userModel.setPasswordModifiedDate(rs.getTimestamp(6));
                int createdBy = rs.getInt(7);
                if(!rs.wasNull()){
                  userModel.setCreatedBy(new UserDAOImpl().getUserWithId(createdBy));
              }
              else{
                  userModel.setCreatedBy(null);
              }
                
               userModel.setCreatedDate(rs.getTimestamp(8));
               
               int modifiedBy = rs.getInt(9);
              if(!rs.wasNull()){
                  userModel.setModifiedBy(new UserDAOImpl().getUserWithId(modifiedBy));
              }
              else{
                  userModel.setModifiedBy(null);
              }
              
              userModel.setModifiedDate(rs.getTimestamp(10));
              userModel.setActive(rs.getBoolean(11));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return userModel;
    }
    
    
    @Override
    public UserModel getUserWithId(Integer userId) {
     UserModel userModel=null;
     try{
          Connection con = DBConnection.getConnection();
          PreparedStatement stmt = con.prepareStatement("select * from user where user_id=? and active=1");
          stmt.setInt(1, userId);
          ResultSet rs = stmt.executeQuery();
          if(rs.next())
          {
             userModel = new UserModel();
                userModel.setUserId(rs.getInt(1));
                userModel.setRole(new RoleDAOImpl().getRoleWithId(rs.getInt(2)));
                userModel.setName(rs.getString(4));
                userModel.setPassword(rs.getString(5));
                userModel.setPasswordModifiedDate(rs.getTimestamp(6));
                int createdBy = rs.getInt(7);
                if(!rs.wasNull()){
                  userModel.setCreatedBy(new UserDAOImpl().getUserWithId(createdBy));
              }
              else{
                  userModel.setCreatedBy(null);
              }
                
               userModel.setCreatedDate(rs.getTimestamp(8));
               
               int modifiedBy = rs.getInt(9);
              if(!rs.wasNull()){
                  userModel.setModifiedBy(new UserDAOImpl().getUserWithId(modifiedBy));
              }
              else{
                  userModel.setModifiedBy(null);
              }
              
              userModel.setModifiedDate(rs.getTimestamp(10));
              userModel.setActive(rs.getBoolean(11));
            }
     
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return userModel;  
     }   

    

    
    @Override
    public List<UserModel> getAllUsers() {
      List<UserModel> userModelList = new ArrayList<>();
      UserModel userModel=null;
     try{
          Connection con = DBConnection.getConnection();
          PreparedStatement stmt = con.prepareStatement("select * from user where active = 1");
          
          ResultSet rs = stmt.executeQuery();
          while(rs.next())
          {
                userModel = new UserModel();
                userModel.setUserId(rs.getInt(1));
                userModel.setRole(new RoleDAOImpl().getRoleWithId(rs.getInt(2)));
                userModel.setName(rs.getString(4));
                userModel.setPassword(rs.getString(5));
                userModel.setPasswordModifiedDate(rs.getTimestamp(6));
                int createdBy = rs.getInt(7);
                if(!rs.wasNull()){
                  userModel.setCreatedBy(new UserDAOImpl().getUserWithId(createdBy));
              }
              else{
                  userModel.setCreatedBy(null);
              }
                
               userModel.setCreatedDate(rs.getTimestamp(8));
               
               int modifiedBy = rs.getInt(9);
              if(!rs.wasNull()){
                  userModel.setModifiedBy(new UserDAOImpl().getUserWithId(modifiedBy));
              }
              else{
                  userModel.setModifiedBy(null);
              }
              
              userModel.setModifiedDate(rs.getTimestamp(10));
              userModel.setActive(rs.getBoolean(11));
              
              userModelList.add(userModel);
            }
     
        }
        catch(Exception e){
            e.printStackTrace();
        }
         
    
    return userModelList;
    }

    @Override
    public Integer deleteUser(Integer userId) {
    try
    {
      Connection con = DBConnection.getConnection();
      PreparedStatement stmt = con.prepareStatement("UPDATE user SET user.`active`= 0 WHERE user.`user_id`= ?" );
      stmt.setInt(1,userId);
      return stmt.executeUpdate();
   
    }
   catch(Exception e)
   {
       e.printStackTrace();
   }
    return 0;   
        
    }

    @Override
    public Integer updateUser(UserModel userModel) {
        
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("update user set user.`role_id`=?,user.`name`=?,modified_by=?,modified_date=? where user_id=?");
         stmt.setInt(1,userModel.getRole().getRoleId());
         stmt.setString(2, userModel.getName());
         
         if(userModel.getModifiedBy() == null){
            stmt.setNull(3, Types.INTEGER);
         }else{
             stmt.setInt(3, userModel.getModifiedBy().getUserId());
         } 
         stmt.setTimestamp(4,userModel.getModifiedDate());
         stmt.setInt(5, userModel.getUserId());
         return stmt.executeUpdate();
     }
     catch(Exception e)
     {
      e.getMessage();
     }    
     return 0;    
    }

    @Override
    public Integer addUser(UserModel userModel) {     
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("Insert Into user(user.`role_id`,user.`name`,password,password_modified_date,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,?,?,?,?,?)");
         stmt.setInt(1,userModel.getRole().getRoleId());
         stmt.setString(2, userModel.getName());
         stmt.setString(3, userModel.getPassword());
         stmt.setTimestamp(4, userModel.getPasswordModifiedDate());
         stmt.setInt(5, userModel.getCreatedBy().getUserId());
         stmt.setTimestamp(6, userModel.getCreatedDate());
         stmt.setInt(7, userModel.getModifiedBy().getUserId());
         stmt.setTimestamp(8,userModel.getModifiedDate());
         stmt.setInt(9, 1);
         return stmt.executeUpdate();
     }
     catch(Exception e)
     {
      e.getMessage();
     }    
     return 0;
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer changePassword(UserModel userModel) {
    
         try
            {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("update user set password = ?,password_modified_date=? where user_id=?");
         stmt.setString(1, userModel.getPassword());
         stmt.setTimestamp(2, userModel.getPasswordModifiedDate());
         stmt.setInt(3, userModel.getUserId());
         return stmt.executeUpdate();
        }
     catch(Exception e)
     {
      e.getMessage();
     }    
     return 0;
        
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
