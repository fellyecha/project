package com.bcaf.project.model;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_provinsi")
public class Provinsi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_provinsi_index")
	@TableGenerator(name = "tbl_provinsi_index", table = "tbl_index",
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	
	@Column(name = "id")
	private long id;
	
	@Column(name = "nama_provinsi", nullable = false, length = 30)
	private String namaProvinsi;
	
//	@OneToMany(mappedBy = "provinsi")
//	@JsonBackReference //ini buat menghandle infinity loop
//	private List<KabupatenKota> listKabKota = new ArrayList<KabupatenKota>();
	
	public Provinsi() {
		
	}
	
	public Provinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

//	public List<KabupatenKota> getListKabKota() {
//		return listKabKota;
//	}
//
//	public void setListKabKota(List<KabupatenKota> listKabKota) {
//		this.listKabKota = listKabKota;
//	}
	
}
