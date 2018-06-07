
package com.pms.dao;

import com.pms.models.PurchaseModel;
import java.util.List;


public interface PurchaseDao {


    public int insertPurchaseData(PurchaseModel purchaseModel);
    public int insertPurchaseDetailsData(PurchaseModel purchaseModel);
    public List<PurchaseModel> getPurchaseInfo();
    public int getPurchaseId(Integer purchaseNo);

    
}
