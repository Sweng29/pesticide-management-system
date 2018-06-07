/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.UnitModel;
import java.util.List;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface UnitDAO {
    public UnitModel getUnitWithId(Integer unitId);
    public List<UnitModel> getAllUnit();
    public Integer deleteUnit(Integer unitId);
    public Integer updateUnit(UnitModel unitModel);
    public Integer addUnit(UnitModel unitModel);
    public int getUnitId(String unitName);
}
