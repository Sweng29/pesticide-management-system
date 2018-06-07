/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.CompanyModel;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface CompanyDAO {
    public CompanyModel getCompanyWithId(Integer companyId);
    public List<CompanyModel> getAllCompany();
    public Integer deleteCompany(Integer companyId);
    public Integer updateCompany(CompanyModel companyModel);
    public Integer addCompany(CompanyModel companyModel);
    public Integer getCompanyId(String  companyName);
}
