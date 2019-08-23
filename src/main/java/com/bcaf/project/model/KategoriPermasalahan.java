package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_kategori_permasalahan")
public class KategoriPermasalahan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kategori_permasalahan_index")
	@TableGenerator(name = "tbl_kategori_permasalahan_index", table = "tbl_index", 
				pkColumnName = "index_id", valueColumnName = "index_value", 
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "jenis_permasalahan", nullable = true)
	private String jenisPermasalahan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJenisPermasalahan() {
		return jenisPermasalahan;
	}

	public void setJenisPermasalahan(String jenisPermasalahan) {
		this.jenisPermasalahan = jenisPermasalahan;
	} 
	
	
}
