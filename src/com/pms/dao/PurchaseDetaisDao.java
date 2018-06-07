/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.PurchaseDetailsModel;
import java.util.List;

/**
 *
 * @author Asif Ali
 */
public interface PurchaseDetaisDao {
 
    public int insertPurchaseDetailsInfo(PurchaseDetailsModel purchaseDetailsModel);
    public List<PurchaseDetailsModel> getAllPurchaseInfo(Integer orderNo);
    public Integer getCommisionMonths(Integer orderId);
    
}
