package com.pms.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ModuleModel extends Model implements Serializable {

	private static final long serialVersionUID = 1909140235030267650L;
	private Integer moduleId;
	private String moduleName;
	private String description;
	
	// ############################### All associated objects (many-to-one) Go here #################################################

	// ############################### All associated objects (one-to-one) Go here #################################################
	
	// ############################### All associated collections (one-to-many) go here #################################################
/* multiple commment strt by me 
        
        
	private Set<RoleModel> roles = new HashSet<RoleModel>(0);
	private Set<PermissionModel> permissions = new HashSet<PermissionModel>(0); 
	
	public Integer getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public Set<PermissionModel> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionModel> permissions) {
		this.permissions = permissions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
           muptiple commment end ...	  */
}
