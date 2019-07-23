package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_cabang_kkb_bca")
public class CabangKkbBca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_cabang_kkb_bca_index")
	@TableGenerator(name="tbl_cabang_kkb_bca_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="cabang_kkb", nullable = false, length = 255)
	private String cabangKkb;
	

	public CabangKkbBca() {
		
	}

	public CabangKkbBca(String name) {
		this.cabangKkb = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCabangKkb() {
		return cabangKkb;
	}

	public void setCabangKkb(String cabangKkb) {
		this.cabangKkb = cabangKkb;
	}



	
}
