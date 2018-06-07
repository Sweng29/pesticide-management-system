/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.CustomerModel;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface CustomerDAO {
    public CustomerModel getCustomerWithId(Integer customerId);
    public List<CustomerModel> getAllCustomer();
    public Integer deleteCustomer(CustomerModel customerModel);
    public Integer updateCustomer(CustomerModel customerModel);
    public Integer addCustomer(CustomerModel customerModel);
}
