/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.CommisionTypeModel;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface CommisionDAO{
    public CommisionTypeModel getCommisionTypeWithId(Integer commisionTypeId);
    public List<CommisionTypeModel> getAllCommisionType();
    public Integer deleteCommisionType(CommisionTypeModel CommisionModel);
    public Integer updateCommisionType(CommisionTypeModel CommisionModel);
    public Integer addCommisionType(CommisionTypeModel CommisionModel);
}
