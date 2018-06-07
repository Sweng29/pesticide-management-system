/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.daoimpl;

import com.pms.connection.DBConnection;
import com.pms.dao.CustomerDAO;
import com.pms.models.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public CustomerModel getCustomerWithId(Integer customerId) {
        CustomerModel customerModel = null;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Select * from customer where type = ? AND customer_id = ? AND active = ?");
            ps.setString(1, "Customer");
            ps.setInt(2, customerId);
            ps.setInt(3, 1);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customerModel = new CustomerModel();
                customerModel.setCustomerId(rs.getInt(1));
                customerModel.setName(rs.getString("name"));

                customerModel.setContact(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerModel;
    }

    @Override
    public List<CustomerModel> getAllCustomer() {
        List<CustomerModel> customerModelList = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from customer where active =1 and type = 'Customer' ");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                CustomerModel customerModel = new CustomerModel();

                customerModel.setCustomerId(set.getInt("customer_id"));
                customerModel.setName(set.getString("name"));
                customerModel.setContact(set.getString("contact"));
                customerModel.setCreatedBy(new UserDAOImpl().getUserWithId(set.getInt("created_by")));
                customerModel.setCreatedDate(Timestamp.valueOf(set.getString("created_date")));
                customerModel.setModifiedBy(new UserDAOImpl().getUserWithId(set.getInt("modified_by")));
                customerModel.setModifiedDate(Timestamp.valueOf(set.getString("modified_date")));

                customerModelList.add(customerModel);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return customerModelList;
    }

    @Override
    public Integer deleteCustomer(CustomerModel customerModel) {
        int row = 0;
        try {
            String query = "UPDATE customer SET customer.`active` = ? WHERE customer_id = ?";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setBoolean(1, customerModel.getActive());
            preparedStatement.setInt(2, customerModel.getCustomerId());
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateCustomer(CustomerModel customerModel) {
        int row = 0;
        try {
            String query = "UPDATE  customer SET customer.`name` = ? , customer.`contact` = ? , customer.`modified_by` = ? , customer.`modified_date` = ? WHERE customer_id = ?";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareCall(query);
            preparedStatement.setString(1, customerModel.getName());
            preparedStatement.setString(2, customerModel.getContact());
            preparedStatement.setInt(3, customerModel.getModifiedBy().getUserId());
            preparedStatement.setTimestamp(4, customerModel.getModifiedDate());
            preparedStatement.setInt(5, customerModel.getCustomerId());
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public Integer addCustomer(CustomerModel customerModel) {
        int row = 0;
        try {
            String query = "INSERT INTO customer (customer.`type`,customer.`name`,contact , `created_by`,`created_date`,`modified_by`,`modified_date`,active) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, "Customer");
            preparedStatement.setString(2, customerModel.getName());
            preparedStatement.setString(3, customerModel.getContact());
            preparedStatement.setInt(4, customerModel.getCreatedBy().getUserId());
            preparedStatement.setTimestamp(5, customerModel.getCreatedDate());
            preparedStatement.setInt(6, customerModel.getModifiedBy().getUserId());
            preparedStatement.setTimestamp(7, customerModel.getModifiedDate());
            preparedStatement.setBoolean(8, customerModel.getActive());

            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;

    }

}
