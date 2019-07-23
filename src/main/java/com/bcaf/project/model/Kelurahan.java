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
@Table(name = "tbl_kelurahan")
public class Kelurahan {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kelurahan_index")
	@TableGenerator(name = "tbl_kelurahan_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)

	@Column(name = "id")
	private long id;

	@Column(name = "id_kecamatan")
	private long idKecamatan;

	@Column(name = "nama_kelurahan", nullable = false, length = 30)
	private String namaKelurahan;

	@Column(name = "kode_pos", nullable = false, length = 5)
	private Integer kodePos;

	@ManyToOne
	@JoinColumn(name = "id_kecamatan", foreignKey = @ForeignKey(name = "fk_kelurahan_kecamatan_id"), insertable = false, updatable = false)
	private Kecamatan kecamatan;

	public Kelurahan() {

	}

	public Kelurahan(String namaKelurahan, Integer kodePos) {
		this.namaKelurahan = namaKelurahan;
		this.kodePos = kodePos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdKecamatan() {
		return idKecamatan;
	}

	public void setIdKecamatan(long idKecamatan) {
		this.idKecamatan = idKecamatan;
	}

	public String getNamaKelurahan() {
		return namaKelurahan;
	}

	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}

	public Integer getKodePos() {
		return kodePos;
	}

	public void setKodePos(Integer kodePos) {
		this.kodePos = kodePos;
	}

	public Kecamatan getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
}
