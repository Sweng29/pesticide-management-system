/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.CommisionDAO;
import com.pms.models.CommisionTypeModel;
import com.pms.models.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class CommisionDAOImpl implements CommisionDAO{

    @Override
    public CommisionTypeModel getCommisionTypeWithId(Integer commisionTypeId) {
        CommisionTypeModel commisionTypeModel = null; 
        try{
             PreparedStatement ps = DBConnection.getConnection().prepareStatement("Select * from commision where active = 1 AND commision_id = ?");
             ps.setInt(1, commisionTypeId);
             ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 commisionTypeModel = new CommisionTypeModel();
                 commisionTypeModel.setCommisionId(rs.getInt(1));
                 commisionTypeModel.setCommisionType(rs.getString(2));
                 
             }
         }
         catch(Exception e){
             
         }
        
        return commisionTypeModel;
    }

    @Override
    public List<CommisionTypeModel> getAllCommisionType() {
            List<CommisionTypeModel> commisionModelList = new ArrayList<>();
     try
     {
       Connection con = DBConnection.getConnection();
       PreparedStatement stmt = con.prepareStatement("select * from commision where active =1");
       ResultSet set = stmt.executeQuery();
       while(set.next())
       {
        CommisionTypeModel commisionModel = new CommisionTypeModel();
        commisionModel.setCommisionId(set.getInt(1));
        commisionModel.setCommisionType(set.getString(2));
        commisionModelList.add(commisionModel);
           
       }
     }
   catch(Exception e)
   {
     e.getMessage();
   }
    return commisionModelList; 
    }

    @Override
    public Integer deleteCommisionType(CommisionTypeModel CommisionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateCommisionType(CommisionTypeModel CommisionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addCommisionType(CommisionTypeModel CommisionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getCommisionIdWithType(String commisionType){
        PreparedStatement ps;
        Integer commisionId = 0;
        try {
            ps = DBConnection.getConnection().prepareStatement("Select commision_id from commision where commision_type = ?");
            ps.setString(1, commisionType);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                commisionId = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommisionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return commisionId;
        
    }
    
}
