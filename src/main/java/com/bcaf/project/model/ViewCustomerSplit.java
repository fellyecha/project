package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="view_customer_split")
public class ViewCustomerSplit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "view_customer_split_index")
	@TableGenerator(name="view_customer_split_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="no_rek", nullable =  false, length = 10)
	private String noRek;
	
	@Column(name="no_pin", nullable = false, length = 3)
	private String noPin;
	
	@Column(name="customer_id", nullable = false, length = 10)
	private String customerId;
	
	@Column(name="customer_name", nullable = false, length = 255)
	private String customerName;
	
	@Column(name="gender", nullable = false, length = 10)
	private String gender;
	
	@Column(name="id_card_number", nullable = false, length = 20)
	private String idCardNumber;
	
	@Column(name="birth_date", nullable = false, length = 10)
	private String birthdate;
	
	@Column(name="home_phone_number", nullable = true, length = 20)
	private String homePhoneNumber;
	
	@Column(name="hp_number", nullable = false, length = 20)
	private String hpNumber;
	
	@Column(name="email_konsumen", nullable = true, length = 255)
	private String emailKonsumen;
	
	@Column(name="company_name", nullable = true, length = 255)
	private String companyName;
	
	@Column(name="job_title", length = 255)
	private String jobTitle;
	
	@Column(name="spouse_name", nullable = true, length = 255)
	private String spouseName;
	
	@Column(name="home_kabupaten", nullable = false, length = 255)
	private String homeKabupaten;
	
	@Column(name="branch_name", nullable = false, length = 255)
	private String branchName;
	
	@Column(name="sub_produk", nullable =  false, length = 255)
	private String subProduk;
	
	@Column(name="merk_name", nullable = false, length = 255)
	private String merkName;
	
	@Column(name="tipe", nullable = false, length = 255)
	private String tipe;
	
	@Column(name="tahun", nullable = false, length = 4)
	private String tahun;
	
	@Column(name="harga_barang", nullable = false, length = 255)
	private String hargaBarang;
	
	@Column(name="tenor", nullable = false, length = 2)
	private String tenor;
	
	@Column(name="bpkb_no", length = 15) //apakah bisa null?
	private String bpkbNo;
	
	@Column(name="body_no", length = 20) //apakah bisa null?
	private String bodyNo;
	
	@Column(name="realisasi_date", nullable = false, length = 10)
	private String realisasiDate;
	
	@Column(name="close_date", nullable = true, length = 10)
	private String closeDate;
	
	@Column(name="end_date", nullable = false, length = 10)
	private String endDate;
	
	@Column(name="period_berjalan", nullable = false, length = 2)
	private String periodBerjalan;
	
	@Column(name="angsuran_konsumen", nullable = true, length = 255)
	private String angsuranKonsumen;
	
	@Column(name="os_pokok_konsumen", nullable = true, length = 255)
	private String osPokokKonsumen;
	
	@Column(name="status_close_type", nullable = false, length = 10)
	private String statusCloseType;
	
	@Column(name="od_days_max", nullable = false, length = 5)
	private String odDaysMax;
	
	@Column(name="ovd_by_cust_id", nullable = false, length = 5)
	private String ovdByCustID;
	
	@Column(name="od_loan", nullable = false, length = 5)
	private String odLoan;
	
	@Column(name="bpkb_status", nullable = true, length = 100)
	private String bpkbStatus;
	
	@Column(name="bca_branch_status", nullable = true, length = 255)
	private String bcaBranchStatus;
	
	@Column(name="bca_branch_name", nullable = true, length = 255)
	private String bcaBranchName;
	
	@Column(name="bca_kcu_name", nullable = true, length = 255)
	private String bcaKcuName;
	
	@Column(name="sales_agent", nullable = true, length = 255)
	private String salesAgent;
	
	@Column(name="sales_agent_name", nullable = true, length = 255)
	private String salesAgentName;
	
	@Column(name="sisa_periode", length = 2)
	private String sisaPeriode;
	
	@Column(name="cabang_ds", length = 255)
	private String cabangName;
	
	@Column(name="source", length = 255)
	private String source;
	
	@Column(name="product", length = 50)
	private String product;
	
	public ViewCustomerSplit() {
		
	}
	
	public ViewCustomerSplit(String cabangName) {
		this.cabangName = cabangName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoRek() {
		return noRek;
	}

	public void setNoRek(String noRek) {
		this.noRek = noRek;
	}

	public String getNoPin() {
		return noPin;
	}

	public void setNoPin(String noPin) {
		this.noPin = noPin;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getHpNumber() {
		return hpNumber;
	}

	public void setHpNumber(String hpNumber) {
		this.hpNumber = hpNumber;
	}

	public String getEmailKonsumen() {
		return emailKonsumen;
	}

	public void setEmailKonsumen(String emailKonsumen) {
		this.emailKonsumen = emailKonsumen;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getHomeKabupaten() {
		return homeKabupaten;
	}

	public void setHomeKabupaten(String homeKabupaten) {
		this.homeKabupaten = homeKabupaten;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSubProduk() {
		return subProduk;
	}

	public void setSubProduk(String subProduk) {
		this.subProduk = subProduk;
	}

	public String getMerkName() {
		return merkName;
	}

	public void setMerkName(String merkName) {
		this.merkName = merkName;
	}


	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public String getHargaBarang() {
		return hargaBarang;
	}

	public void setHargaBarang(String hargaBarang) {
		this.hargaBarang = hargaBarang;
	}

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	public String getBpkbNo() {
		return bpkbNo;
	}

	public void setBpkbNo(String bpkbNo) {
		this.bpkbNo = bpkbNo;
	}

	public String getBodyNo() {
		return bodyNo;
	}

	public void setBodyNo(String bodyNo) {
		this.bodyNo = bodyNo;
	}

	public String getRealisasiDate() {
		return realisasiDate;
	}

	public void setRealisasiDate(String realisasiDate) {
		this.realisasiDate = realisasiDate;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPeriodBerjalan() {
		return periodBerjalan;
	}

	public void setPeriodBerjalan(String periodBerjalan) {
		this.periodBerjalan = periodBerjalan;
	}

	public String getAngsuranKonsumen() {
		return angsuranKonsumen;
	}

	public void setAngsuranKonsumen(String angsuranKonsumen) {
		this.angsuranKonsumen = angsuranKonsumen;
	}

	public String getOsPokokKonsumen() {
		return osPokokKonsumen;
	}

	public void setOsPokokKonsumen(String osPokokKonsumen) {
		this.osPokokKonsumen = osPokokKonsumen;
	}

	public String getStatusCloseType() {
		return statusCloseType;
	}

	public void setStatusCloseType(String statusCloseType) {
		this.statusCloseType = statusCloseType;
	}

	public String getOdDaysMax() {
		return odDaysMax;
	}

	public void setOdDaysMax(String odDaysMax) {
		this.odDaysMax = odDaysMax;
	}

	public String getOvdByCustID() {
		return ovdByCustID;
	}

	public void setOvdByCustID(String ovdByCustID) {
		this.ovdByCustID = ovdByCustID;
	}

	public String getOdLoan() {
		return odLoan;
	}

	public void setOdLoan(String odLoan) {
		this.odLoan = odLoan;
	}

	public String getBpkbStatus() {
		return bpkbStatus;
	}

	public void setBpkbStatus(String bpkbStatus) {
		this.bpkbStatus = bpkbStatus;
	}

	public String getBcaBranchStatus() {
		return bcaBranchStatus;
	}

	public void setBcaBranchStatus(String bcaBranchStatus) {
		this.bcaBranchStatus = bcaBranchStatus;
	}

	public String getBcaBranchName() {
		return bcaBranchName;
	}

	public void setBcaBranchName(String bcaBranchName) {
		this.bcaBranchName = bcaBranchName;
	}

	public String getBcaKcuName() {
		return bcaKcuName;
	}

	public void setBcaKcuName(String bcaKcuName) {
		this.bcaKcuName = bcaKcuName;
	}

	public String getSalesAgent() {
		return salesAgent;
	}

	public void setSalesAgent(String salesAgent) {
		this.salesAgent = salesAgent;
	}

	public String getSalesAgentName() {
		return salesAgentName;
	}

	public void setSalesAgentName(String salesAgentName) {
		this.salesAgentName = salesAgentName;
	}

	public String getSisaPeriode() {
		return sisaPeriode;
	}

	public void setSisaPeriode(String sisaPeriode) {
		this.sisaPeriode = sisaPeriode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCabangName() {
		return cabangName;
	}

	public void setCabangName(String cabangName) {
		this.cabangName = cabangName;
	}
}