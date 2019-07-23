package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_employee_index")
	@TableGenerator(name = "tbl_employee_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "directorat_divisi", nullable = false, length = 255)
	private String directoratDivisi;
	
	@Column(name = "department_unit", nullable = false, length = 255)
	private String departmentUnit;
	
	@Column(name = "cabang", nullable = false, length = 100)
	private String cabang;
	
	@Column(name = "cabang_2", nullable = false, length = 100)
	private String cabang2;
	
	@Column(name = "marketing", nullable = false, length = 35)
	private String marketing;
	
	@Column(name = "regional", nullable = false, length = 35)
	private String regional;
	
	@Column(name = "jabatan", nullable = false, length = 255)
	private String jabatan;
	
	@Column(name = "jabatan_2", nullable = false, length = 255)
	private String jabatan2;
	
	@Column(name = "nama", nullable = false, length = 100)
	private String nama;
	
	@Column(name = "status", nullable = false, length = 10)
	private String status;
	
	@Column(name = "status_2", nullable = false, length = 25)
	private String status2;
	
	@Column(name = "pendidikan", nullable = false, length = 10)
	private String pendidikan;
	
	@Column(name = "gender", nullable = false, length = 1)
	private String gender;
	
	@Column(name = "nip", nullable = false, length = 10)
	private String nip;
	
	@Column(name = "tgl_masuk", nullable = false, length = 20)
	private String tglMasuk;
	
	@Column(name = "initial_name", nullable = false, length = 5)
	private String initialName;
	
	@Column(name = "tgl_lahir", nullable = false, length = 20)
	private String tglLahir;
	
	@Column(name = "keterangan", nullable = false, length = 255)
	private String keterangan;
	
	@Column(name = "jabatan_rangkap_tugas", nullable = false, length = 255)
	private String jabatanRangkapTugas;
	
	@Column(name = "cabang_rangkap_tugas", nullable = false, length = 255)
	private String cabangRangkapTugas;
	
	@Column(name = "tgl_awal_tugas", nullable = false, length = 20)
	private String tglAwalTugas;
	
	@Column(name = "tgl_akhir_tugas", nullable = false, length = 20)
	private String tglAkhirTugas;
	
	public Employee() {

	}

	public Employee(String name) {
		this.nama = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirectoratDivisi() {
		return directoratDivisi;
	}

	public void setDirectoratDivisi(String directoraDivisi) {
		this.directoratDivisi = directoraDivisi;
	}

	public String getDepartmentUnit() {
		return departmentUnit;
	}

	public void setDepartmentUnit(String departmentUnit) {
		this.departmentUnit = departmentUnit;
	}

	public String getCabang() {
		return cabang;
	}

	public void setCabang(String cabang) {
		this.cabang = cabang;
	}

	public String getCabang2() {
		return cabang2;
	}

	public void setCabang2(String cabang2) {
		this.cabang2 = cabang2;
	}

	public String getMarketing() {
		return marketing;
	}

	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getJabatan2() {
		return jabatan2;
	}

	public void setJabatan2(String jabatan2) {
		this.jabatan2 = jabatan2;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getPendidikan() {
		return pendidikan;
	}

	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getTglMasuk() {
		return tglMasuk;
	}

	public void setTglMasuk(String tglMasuk) {
		this.tglMasuk = tglMasuk;
	}

	public String getInitialName() {
		return initialName;
	}

	public void setInitialName(String initialName) {
		this.initialName = initialName;
	}

	public String getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(String tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getJabatanRangkapTugas() {
		return jabatanRangkapTugas;
	}

	public void setJabatanRangkapTugas(String jabatanRangkapTugas) {
		this.jabatanRangkapTugas = jabatanRangkapTugas;
	}

	public String getCabangRangkapTugas() {
		return cabangRangkapTugas;
	}

	public void setCabangRangkapTugas(String cabangRangkapTugas) {
		this.cabangRangkapTugas = cabangRangkapTugas;
	}

	public String getTglAwalTugas() {
		return tglAwalTugas;
	}

	public void setTglAwalTugas(String tglAwalTugas) {
		this.tglAwalTugas = tglAwalTugas;
	}

	public String getTglAkhirTugas() {
		return tglAkhirTugas;
	}

	public void setTglAkhirTugas(String tglAkhirTugas) {
		this.tglAkhirTugas = tglAkhirTugas;
	}
	
	
}
