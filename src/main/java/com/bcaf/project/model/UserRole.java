package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_urole_index")
	@TableGenerator(name = "tbl_urole_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_id", nullable = false, length = 64)
	private Long userId;
	
	@Column(name = "role_id", nullable = false, length = 100)
	private Long roleId;
	
	public UserRole() {
	}
	
	public UserRole(Long userId, Long roleId ) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}