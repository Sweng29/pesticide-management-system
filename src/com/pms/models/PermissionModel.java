package com.pms.models;
import com.pms.models.*;
import java.util.HashSet;
import java.util.Set;

public class PermissionModel extends Model implements java.io.Serializable {

	private static final long serialVersionUID = 4126511969979071948L;

	private Integer permissionId;
	private String permissionName;
        private String screenName;
        
	
	// ############################### All associated objects (many-to-one) Go here #################################################
	private ModuleModel module;

	// ############################### All associated objects (one-to-one) Go here #################################################
	
	// ############################### All associated collections (one-to-many) go here #################################################

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

	
        private Set<RoleModel> roles = new HashSet<RoleModel> (0);
	

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Set<RoleModel> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public ModuleModel getModule() {
		return module;
	}

	public void setModule(ModuleModel module) {
		this.module = module;
	}

}
