package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_cabang_ds")
public class CabangDs {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_cabang_ds_index")
	@TableGenerator(name = "tbl_cabang_ds_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)

	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "wilayah_cabang_ds", nullable = false, length = 100)
	private String wilayahCabang;

	@Column(name = "cabang_ds", nullable = false, length = 100)
	private String cabangName;

	public CabangDs() {

	}

	public CabangDs(String name) {
		this.cabangName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWilayahCabang() {
		return wilayahCabang;
	}

	public void setWilayahCabang(String wilayahCabang) {
		this.wilayahCabang = wilayahCabang;
	}

	public String getCabangName() {
		return cabangName;
	}

	public void setCabangName(String cabangName) {
		this.cabangName = cabangName;
	}

}
