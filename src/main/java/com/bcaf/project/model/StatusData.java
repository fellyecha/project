package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_status_data")
public class StatusData {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_status_data_index")
	@TableGenerator(name="tbl_status_data_index", table = "tbl_index",
			pkColumnName = "index_id", valueColumnName = "index_value",
			allocationSize = 1, initialValue = 0)
	
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="status", nullable = false, length = 50)
	private String status;
	
	@Column(name="status_selling", nullable = false, length = 50)
	private String statusSelling;
	
	@Column(name="status_order", nullable = false)
	private Long statusOrder;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusSelling() {
		return statusSelling;
	}

	public void setStatusSelling(String statusSelling) {
		this.statusSelling = statusSelling;
	}

	public Long getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(Long statusOrder) {
		this.statusOrder = statusOrder;
	}
	
}
