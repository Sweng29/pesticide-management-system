/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.CompanyDAO;
import com.pms.models.CompanyModel;
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
public class CompanyDAOImpl implements CompanyDAO{

    @Override
    public CompanyModel getCompanyWithId(Integer companyId) {
        CompanyModel companyModel = null;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from company where company_id = ? AND active = 1");
            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                companyModel = new CompanyModel();
                companyModel.setCompany_id(rs.getInt(1));
                companyModel.setName(rs.getString(2));
                companyModel.setAddress(rs.getString(3));
                companyModel.setContact(rs.getString(4));
               companyModel.setCreatedBy(new UserDAOImpl().getUserWithId(rs.getInt(5)));
                companyModel.setCreatedDate(rs.getTimestamp(6));
                companyModel.setModifiedBy(new UserDAOImpl().getUserWithId(rs.getInt(7)));
                companyModel.setModifiedDate(rs.getTimestamp(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return companyModel;
    }

    @Override
    public List<CompanyModel> getAllCompany() {
        CompanyModel companyModel = null;
        ArrayList<CompanyModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from company where active = ?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                companyModel = new CompanyModel();
                companyModel.setCompany_id(rs.getInt(1));
                companyModel.setName(rs.getString(2));
                companyModel.setAddress(rs.getString(3));
                companyModel.setContact(rs.getString(4));
                companyModel.setCreatedBy(new UserDAOImpl().getUserWithId(rs.getInt(5)));
                companyModel.setCreatedDate(rs.getTimestamp(6));
                companyModel.setModifiedBy(new UserDAOImpl().getUserWithId(rs.getInt(7)));
                companyModel.setModifiedDate(rs.getTimestamp(8));
                list.add(companyModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    public Integer deleteCompany(Integer companyId) {
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("update company set active = 0 where company_id = ?");
            ps.setInt(1, companyId);
            return ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateCompany(CompanyModel companyModel) {
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("update company set name = ?,Address = ?,contact = ?,modified_by=?,modified_date = ? where company_id = ?");
            ps.setString(1, companyModel.getName());
            ps.setString(2, companyModel.getAddress());
            ps.setString(3, companyModel.getContact());
            ps.setInt(4, companyModel.getModifiedBy().getUserId());
            ps.setTimestamp(5, companyModel.getModifiedDate());
            ps.setInt(6, companyModel.getCompany_id());
            return ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public Integer addCompany(CompanyModel companyModel) {
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Insert Into company(name,Address,contact,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, companyModel.getName());
            ps.setString(2, companyModel.getAddress());
            ps.setString(3, companyModel.getContact());
            ps.setInt(4, companyModel.getCreatedBy().getUserId());
            ps.setTimestamp(5, companyModel.getCreatedDate());
            ps.setInt(6, companyModel.getModifiedBy().getUserId());
            ps.setTimestamp(7, companyModel.getModifiedDate());
            ps.setInt(8, 1);
            
            return ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
    }
     @Override
    public Integer getCompanyId(String companyName) {
   int companyId = 0;
        try{
    
        String query = "SELECT company_id FROM company WHERE company.`name` = ?";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, companyName);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
        companyId = Integer.parseInt(rs.getString(1));
        }
        
    }catch(Exception e){
    e.printStackTrace();
    }   
    return companyId;
    }

  
 
    
}
