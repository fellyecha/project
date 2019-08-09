package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_user_role_cabang")
public class UserRoleCabang {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_urolecab_index")
	@TableGenerator(name = "tbl_urolecab_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username", nullable = false, length = 64)
	private Long username;
	
	@Column(name = "cabang_id", nullable = false, length = 64)
	private Long cabangId;
	
	public UserRoleCabang() {
		
	}
	
	public UserRoleCabang(Long username, Long cabangId) {
		this.username = username;
		this.cabangId = cabangId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsername() {
		return username;
	}

	public void setUsername(Long username) {
		this.username = username;
	}

	public Long getCabangId() {
		return cabangId;
	}

	public void setCabangId(Long cabangId) {
		this.cabangId = cabangId;
	}
		
}
