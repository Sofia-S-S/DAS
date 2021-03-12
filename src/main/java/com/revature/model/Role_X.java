/**
 * 
 */
package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jinwei Xiong
 *
 */
@Entity(name="Role")
@Table(name="app_role")

public class Role {
	@Id
	@Column(name="roleId")
	private Integer roleId;
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private USERROLE role;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Integer roleId, USERROLE role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public USERROLE getRole() {
		return role;
	}
	public void setRole(USERROLE role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role != other.role)
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
}
