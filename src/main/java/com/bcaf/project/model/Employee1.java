package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_employees1")
public class Employee1 {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_employee1_index")
	@TableGenerator(name = "tbl_employee1_index", table = "tbl_index", pkColumnName = "index_id", valueColumnName = "index_value", allocationSize = 1, initialValue = 0)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "position_id", nullable = false)
	private Long positionId;
	
	@Column(name = "cabang", nullable = false, length = 100)
	private String cabang;
	
	@Column(name = "cabang_2", nullable = false, length = 100)
	private String cabang2;
	
	@Column(name = "marketing", nullable = false, length = 35)
	private String marketing;
	
	@Column(name = "regional", nullable = false, length = 35)
	private String regional;
	
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
	
	@ManyToOne
	@JoinColumn(name = "position_id", foreignKey = @ForeignKey(name = "fk_employee_position_id"), insertable = false, updatable = false)
	private Position position;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "tbl_employee_role",
			joinColumns = @JoinColumn(
					name = "employee_nip",
					referencedColumnName = "nip",
					foreignKey = @ForeignKey(name = "fe_emprole_user_id")
					),
			inverseJoinColumns = @JoinColumn(
					name = "role_id",
					referencedColumnName = "id",
					foreignKey = @ForeignKey(name = "fk_emprole_role_id")
					),
			foreignKey = @ForeignKey(
					name = "fk_emprole_user_id"),
			inverseForeignKey = @ForeignKey(name = "fk_emprole_role_id")
	)
	private List<Role> listRole = new ArrayList<Role>();
	
	public Employee1() {

	}

	public Employee1(String name) {
		this.nama = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	
	
}
