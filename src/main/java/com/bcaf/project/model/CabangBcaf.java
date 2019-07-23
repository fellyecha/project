package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_cabang_bcaf")
public class CabangBcaf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_cabang_index")
	@TableGenerator(name="tbl_cabang_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="cabang_bcaf", nullable = false, length = 100)
	private String namaCabangBcaf;
	
	@Column(name="id_cabang_ds", nullable = false)
	private Long idCabangDs;
	
	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name = "id_cabang_ds", foreignKey = @ForeignKey(
			name = "fe_cabang_bcaf_cabang_ds_id"), insertable = false,
			updatable = false)
	private CabangDs cabangDs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public CabangBcaf() {
		
	}
	
	public CabangBcaf(String name) {
		this.namaCabangBcaf = name;
	}

	public String getNamaCabangBcaf() {
		return namaCabangBcaf;
	}

	public void setNamaCabangBcaf(String namaCabangBcaf) {
		this.namaCabangBcaf = namaCabangBcaf;
	}

	public Long getIdCabangDs() {
		return idCabangDs;
	}

	public void setIdCabangDs(Long idCabangDs) {
		this.idCabangDs = idCabangDs;
	}

	public CabangDs getCabangDs() {
		return cabangDs;
	}

	public void setCabangDs(CabangDs cabangDs) {
		this.cabangDs = cabangDs;
	}

}
