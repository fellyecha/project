package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kabkot_cabang")
public class KabKotCabang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kabkot_cabang_index")
	@TableGenerator(name="tbl_kabkot_cabang_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="kabkot", nullable = false, length = 100)
	private String kabkot;
	
	@Column(name="cabang_ds", nullable = false, length = 100)
	private String cabangDs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKabkot() {
		return kabkot;
	}

	public void setKabkot(String kabkot) {
		this.kabkot = kabkot;
	}

	public String getCabangDs() {
		return cabangDs;
	}

	public void setCabangDs(String cabangDs) {
		this.cabangDs = cabangDs;
	}


}
