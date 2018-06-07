
package com.pms.dao;

import com.pms.models.DealerModel;
import java.util.List;

public interface DealerDao {

public DealerModel getDealerModelWithId(Integer dealerId);
public int getDealerIdWithName(String name);
public List<DealerModel> getDealerDetails();
public int addDealer(DealerModel dealerModel);
public int updateDealer(DealerModel dealerModel);
public int deleteDealer(DealerModel dealerModel);

    
}
