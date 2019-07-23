package com.bcaf.project.model;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_kecamatan")
public class Kecamatan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kecamatan_index")
	@TableGenerator(name = "tbl_kecamatan_index", table = "tbl_index",
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "id_kab_kota")
	private long idKabKota;
	
	@Column(name = "nama_kecamatan", nullable = false, length = 30)
	private String namaKecamatan;
	
	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name = "id_kab_kota", foreignKey = @ForeignKey(
			name = "fe_kecamatan_kab_kota_id"), insertable = false,
			updatable = false)
	private KabupatenKota kabupatenKota;
	
//	@OneToMany(mappedBy = "kecamatan")	
//	private List<Kelurahan> listKelurahan = new ArrayList<Kelurahan>();
	
	public Kecamatan() {
		
	}
	
	public Kecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdKabKota() {
		return idKabKota;
	}

	public void setIdKabKota(long idKabKota) {
		this.idKabKota = idKabKota;
	}

	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	public KabupatenKota getKabupatenKota() {
		return kabupatenKota;
	}

	public void setKabupatenKota(KabupatenKota kabupatenKota) {
		this.kabupatenKota = kabupatenKota;
	}

//	public List<Kelurahan> getListKelurahan() {
//		return listKelurahan;
//	}
//
//	public void setListKelurahan(List<Kelurahan> listKelurahan) {
//		this.listKelurahan = listKelurahan;
//	}
	
}
