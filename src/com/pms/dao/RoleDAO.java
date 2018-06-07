/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.RoleModel;
import java.util.List;

/**
 *
 * @author farhan baloch
 */
public interface RoleDAO {
    
  public RoleModel getRoleWithId(Integer roleId);
  public List<RoleModel> getAllRoles();
  public RoleModel getRoleModelWithRole(String role);
  public Integer deleteRole(RoleModel roleModel);
  public Integer updateRole(RoleModel roleModel);

}
