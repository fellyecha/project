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
@Table(name="tbl_cabang_bca")
public class CabangBca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_cabang_bca_index")
	@TableGenerator(name="tbl_cabang_bca_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="cabang_kcu", nullable = false, length = 255)
	private String cabangKcu;
	
	@Column(name="cabang_kcp", nullable = false, length = 255)
	private String cabangKcp;
	
	@Column(name="id_cabang_kkb_bca", nullable = false)
	private Long idCabangKkbBca;
	
	@ManyToOne
	@JoinColumn(name = "id_cabang_kkb_bca", foreignKey = @ForeignKey(name = "fe_cab_bca_kkb_bca_id"), insertable = false, updatable = false)
	public CabangKkbBca cabaKkbBca;
	
	public CabangBca() {

	}

	public CabangBca(String name) {
		this.cabangKcp = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCabangKcu() {
		return cabangKcu;
	}

	public void setCabangKcu(String cabangKcu) {
		this.cabangKcu = cabangKcu;
	}

	public String getCabangKcp() {
		return cabangKcp;
	}

	public void setCabangKcp(String cabangKcp) {
		this.cabangKcp = cabangKcp;
	}

	public Long getIdCabangKkbBca() {
		return idCabangKkbBca;
	}

	public void setIdCabangKkbBca(Long idCabangKkbBca) {
		this.idCabangKkbBca = idCabangKkbBca;
	}

}
