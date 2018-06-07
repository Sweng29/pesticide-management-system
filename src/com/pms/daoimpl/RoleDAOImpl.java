/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.RoleDAO;
import com.pms.models.RoleModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farhan baloch
 */
public class RoleDAOImpl implements RoleDAO  {

    @Override
    public RoleModel getRoleWithId(Integer roleId) {
        RoleModel roleModel = null;
        try
        {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from role where role_id=? and active=1");
            stmt.setInt(1, roleId);
            ResultSet set = stmt.executeQuery();
            if(set.next())
            {
              roleModel = new RoleModel();
              roleModel.setRoleId(set.getInt(1));
              roleModel.setRoleName(set.getString(2));
              roleModel.setDescription(set.getString(3));
              int createdBy = set.getInt(4);
              if(!set.wasNull()){
                  roleModel.setCreatedBy(new UserDAOImpl().getUserWithId(createdBy));
              }
              else{
                  roleModel.setCreatedBy(null);
              }
              
              roleModel.setCreatedDate(set.getTimestamp(5));
              int modifiedBy = set.getInt(6);
              if(!set.wasNull()){
                  roleModel.setModifiedBy(new UserDAOImpl().getUserWithId(modifiedBy));
              }
              else{
                  roleModel.setModifiedBy(null);
              }
              
              roleModel.setModifiedDate(set.getTimestamp(7));
              roleModel.setActive(set.getBoolean(8));
            }  
                    
            
            
        }
       catch(Exception e)
       {
           e.getMessage();
       }


    return roleModel;
    }

    @Override
    public List<RoleModel> getAllRoles() {
        List<RoleModel> allRoles = new ArrayList<>();
         try
        {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareCall("select * from role where active=1");
            ResultSet set = stmt.executeQuery();
            while(set.next())
            {
              RoleModel roleModel = new RoleModel();
              roleModel.setRoleName(set.getString("role_name"));
              allRoles.add(roleModel);
            }  
            
        }
       catch(Exception e)
       {
           e.getMessage();
       }
        return allRoles;
    }

    @Override
    public Integer deleteRole(RoleModel roleModel) {
     int row=0;
    
    try
    {
      Connection con = DBConnection.getConnection();
      PreparedStatement stmt = con.prepareStatement("UPDATE role SET role.`active`=0 WHERE role.`role_id`=?" );
      stmt.setInt(1,roleModel.getRoleId());
      row=stmt.executeUpdate();
   
    }
   catch(Exception e)
   {
       e.printStackTrace();
   }
   return row;
    }

    @Override
    public Integer updateRole(RoleModel roleModel) {
        int row=0;
     try
     {
         Connection con = DBConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("update role set role_name=?,description=?,created_by=?,created_date=?,modified_by=?,modified_date=?,active=? where role_id=?");
         stmt.setString(1, roleModel.getRoleName());
         stmt.setString(2, roleModel.getDescription());
     //    stmt.setInt(3,roleModel.getCreatedBy());
         stmt.setTimestamp(4,roleModel.getCreatedDate());
      //   stmt.setInt(5,roleModel.getModifiedBy());
         stmt.setTimestamp(6,roleModel.getModifiedDate());
         stmt.setBoolean(7,roleModel.getActive());
         stmt.setInt(8, roleModel.getRoleId());
    row =stmt.executeUpdate();
         
         
     }
     catch(Exception e)
     {
      e.getMessage();
     }    
     return row;
    }

    @Override
    public RoleModel getRoleModelWithRole(String role) {
        RoleModel roleModel = null;
        try
        {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from role where role_name=? and active=1");
            stmt.setString(1, role);
            ResultSet set = stmt.executeQuery();
            if(set.next())
            {
              roleModel = new RoleModel();
              roleModel.setRoleId(set.getInt(1));
              roleModel.setRoleName(set.getString(2));
              roleModel.setDescription(set.getString(3));
              int createdBy = set.getInt(4);
              if(!set.wasNull()){
                  roleModel.setCreatedBy(new UserDAOImpl().getUserWithId(createdBy));
              }
              else{
                  roleModel.setCreatedBy(null);
              }
              
              roleModel.setCreatedDate(set.getTimestamp(5));
              int modifiedBy = set.getInt(6);
              if(!set.wasNull()){
                  roleModel.setModifiedBy(new UserDAOImpl().getUserWithId(modifiedBy));
              }
              else{
                  roleModel.setModifiedBy(null);
              }
              
              roleModel.setModifiedDate(set.getTimestamp(7));
              roleModel.setActive(set.getBoolean(8));
            }  
                    
            
            
        }
       catch(Exception e)
       {
           e.getMessage();
       }


    return roleModel;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
