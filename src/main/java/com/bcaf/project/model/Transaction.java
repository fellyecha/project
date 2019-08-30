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
@Table(name = "tbl_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_transaction_index")
	@TableGenerator(name="tbl_transaction_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="id_cust_data")
	private Long idCustData;
	
	@Column(name="id_data_status")
	private Long idDataStatus;
	
	@Column(name="status_order")
	private Long statusOrder;
	
	@Column(name="data_description", length = 255)
	private String dataDescription;
	
	@Column(name="date_bm_received", length = 10)
	private String dateBmRecieved;
	
	@Column(name="user_id_bm", length = 10)
	private String userIdBm;
	
	@Column(name="date_cmo_received", length = 10)
	private String dateCmoRecieved;

	@Column(name="user_id_cmo", length = 10)
	private String userIdCmo;
	
	@ManyToOne
	@JoinColumn(name = "id_data_status", foreignKey = @ForeignKey(name = "fe_trans_status_data_id"), insertable = false, updatable = false)
	private StatusData statusData;
	
	@ManyToOne
	@JoinColumn(name = "id_cust_data", foreignKey = @ForeignKey(name = "fe_trans_cust_data_id"), insertable = false, updatable = false)
	private ViewCustomerData viewCustomerData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCustData() {
		return idCustData;
	}

	public void setIdCustData(Long idCustData) {
		this.idCustData = idCustData;
	}

	public Long getIdDataStatus() {
		return idDataStatus;
	}

	public void setIdDataStatus(Long idDataStatus) {
		this.idDataStatus = idDataStatus;
	}

	public Long getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(Long statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getDataDescription() {
		return dataDescription;
	}

	public void setDataDescription(String dataDescription) {
		this.dataDescription = dataDescription;
	}

	public String getDateBmRecieved() {
		return dateBmRecieved;
	}

	public void setDateBmRecieved(String dateBmRecieved) {
		this.dateBmRecieved = dateBmRecieved;
	}

	public String getUserIdBm() {
		return userIdBm;
	}

	public void setUserIdBm(String userIdBm) {
		this.userIdBm = userIdBm;
	}

	public String getDateCmoRecieved() {
		return dateCmoRecieved;
	}

	public void setDateCmoRecieved(String dateCmoRecieved) {
		this.dateCmoRecieved = dateCmoRecieved;
	}

	public String getUserIdCmo() {
		return userIdCmo;
	}

	public void setUserIdCmo(String userIdCmo) {
		this.userIdCmo = userIdCmo;
	}

	public StatusData getStatusData() {
		return statusData;
	}

	public void setStatusData(StatusData statusData) {
		this.statusData = statusData;
	}

	public ViewCustomerData getViewCustomerData() {
		return viewCustomerData;
	}

	public void setViewCustomerData(ViewCustomerData viewCustomerData) {
		this.viewCustomerData = viewCustomerData;
	}
}
