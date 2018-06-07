
package com.pms.models;


public class DealerModel extends Model implements java.io.Serializable {
    
    private Integer dealerId;
    private String dealerName;
    private String contact;
    

    public DealerModel(String name, String contact) {
this.dealerName = name;
this.contact=contact;
    }

    public DealerModel() {
      
    }
    

    public Integer getCustomerId() {
        return dealerId;
    }

    public void setCustomerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    
    
}
