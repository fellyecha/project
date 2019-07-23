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

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_kab_kota")
public class KabupatenKota {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kab_kota_index")
	@TableGenerator(name = "tbl_kab_kota_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)

	@Column(name = "id")
	private long id;

	@Column(name = "id_provinsi")
	private long idProvinsi;

	@Column(name = "nama_kab_kota", nullable = false, length = 30)
	private String namaKabKota;

	@ManyToOne
	@JoinColumn(name = "id_provinsi", foreignKey = @ForeignKey(name = "fe_kabkot_provinsi_id"), insertable = false, updatable = false)
//	@JsonManagedReference //ini buat menghandle infinity loop
	private Provinsi provinsi;

//	@OneToMany(mappedBy = "kabupatenKota")
//	@JsonBackReference
//	private List<Kecamatan> listKecamatan = new ArrayList<Kecamatan>();

	public KabupatenKota() {

	}

	public KabupatenKota(String namaKabKota, long idProvinsi) {
		this.namaKabKota = namaKabKota;
		this.idProvinsi = idProvinsi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdProvinsi() {
		return idProvinsi;
	}

	public void setIdProvinsi(long idProvinsi) {
		this.idProvinsi = idProvinsi;
	}

	public String getNamaKabKota() {
		return namaKabKota;
	}

	public void setNamaKabKota(String namaKabKota) {
		this.namaKabKota = namaKabKota;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}

//	public List<Kecamatan> getListKecamatan() {
//		return listKecamatan;
//	}
//
//	public void setListKecamatan(List<Kecamatan> listKecamatan) {
//		this.listKecamatan = listKecamatan;
//	}

}
