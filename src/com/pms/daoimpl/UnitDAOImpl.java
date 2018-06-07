/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.UnitDAO;
import com.pms.models.UnitModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class UnitDAOImpl implements UnitDAO{

    @Override
    public UnitModel getUnitWithId(Integer unitId) {
       
       UnitModel unitModel = null;
       
       try{
           PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from unit where unit_id = ? AND active = 1");
           ps.setInt(1, unitId);
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()){
               unitModel = new UnitModel();             
               unitModel.setUnitId(rs.getInt(1));
               unitModel.setUnitName(rs.getString(2));    
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return unitModel;
    }

    @Override
    public List<UnitModel> getAllUnit() {
       ArrayList<UnitModel> list = new ArrayList<>();
       UnitModel unitModel = null;
       
       try{
           PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from unit where active = 1");
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               unitModel = new UnitModel();
               
               unitModel.setUnitId(rs.getInt(1));
               unitModel.setUnitName(rs.getString(2));
               unitModel.setCreatedBy(new UserDAOImpl().getUserWithId(rs.getInt(3)));
               unitModel.setCreatedDate(rs.getTimestamp(4));
               unitModel.setModifiedBy(new UserDAOImpl().getUserWithId(rs.getInt(5)));
               unitModel.setModifiedDate(rs.getTimestamp(6));
               
               list.add(unitModel);
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return list;
    }

    @Override
    public Integer deleteUnit(Integer unitId) {
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("update unit set active = ? where unit_Id = ?");
            ps.setInt(1, 0);
            ps.setInt(2, unitId);
            return ps.executeUpdate();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer updateUnit(UnitModel unitModel) {
       try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("update unit set name = ?,modified_by = ?,modified_date = ? where unit_Id = ?");
            ps.setString(1, unitModel.getUnitName());
           // System.out.println(unitModel.getModifiedBy().getUserId());
            ps.setInt(2, unitModel.getModifiedBy().getUserId());
            ps.setTimestamp(3, unitModel.getModifiedDate());
            ps.setInt(4, unitModel.getUnitId());
            return ps.executeUpdate();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer addUnit(UnitModel unitModel) {
      try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Insert Into unit(name,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,?,?)");
            ps.setString(1, unitModel.getUnitName());
            ps.setInt(2, unitModel.getCreatedBy().getUserId());
            ps.setTimestamp(3, unitModel.getCreatedDate());
            ps.setInt(4, unitModel.getModifiedBy().getUserId());
            ps.setTimestamp(5, unitModel.getModifiedDate());
            ps.setInt(6, 1);
            return ps.executeUpdate();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
        return 0;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      @Override
    public int getUnitId(String unitName) {
    int unitId = 0;
        try{
        String query = "SELECT `unit_id` FROM unit WHERE unit.`name` = ?";
        PreparedStatement preparedStatement =  DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, unitName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        unitId = Integer.parseInt(resultSet.getString(1));
        }
    }catch(Exception e){
    e.printStackTrace();
    }    
    return unitId;    
    
    }
    
   
}
