package com.pms.models;

import com.pms.models.UserModel;
import java.util.HashSet;
import java.util.Set;

public class RoleModel extends Model implements java.io.Serializable {

	private static final long serialVersionUID = 1197454446922369010L;

	private Integer roleId;
	private String roleName;
	private String description;


	// ############################### All associated objects (many-to-one) Go here #################################################

	// ############################### All associated objects (one-to-one) Go here #################################################

	// ############################### All associated collections (one-to-many) go here #################################################

	private Set<PermissionModel> permissions = new HashSet<PermissionModel>(0);
	private Set<UserModel> users = new HashSet<UserModel>(0);
	private Set<ModuleModel> modules = new HashSet<ModuleModel>(0);

	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	public Set<PermissionModel> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Set<PermissionModel> permissions) {
		this.permissions = permissions;
	}

	public Set<UserModel> getUsers() {
		return this.users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ModuleModel> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleModel> modules) {
		this.modules = modules;
	}

}
