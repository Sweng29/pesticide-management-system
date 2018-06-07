/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.models;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class CommisionTypeModel extends Model implements java.io.Serializable{
    private Integer commisionId;
    private String commisionType;

    public Integer getCommisionId() {
        return commisionId;
    }

    public void setCommisionId(Integer commisionId) {
        this.commisionId = commisionId;
    }

    public String getCommisionType() {
        return commisionType;
    }

    public void setCommisionType(String commisionType) {
        this.commisionType = commisionType;
    }
    
    
}
