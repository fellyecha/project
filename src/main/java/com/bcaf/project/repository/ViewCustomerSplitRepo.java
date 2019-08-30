package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bcaf.project.model.ViewCustomerSplit;

public interface ViewCustomerSplitRepo extends JpaRepository<ViewCustomerSplit, Long> {
	@Query("SELECT c FROM ViewCustomerSplit c")
	public List<ViewCustomerSplit> findAllByCabangName();

//	@Query("select a from CustomerData a \r\n" + 
//	"join CabangDs c \r\n" + 
//	"on a.cabangName = c.cabangName \r\n" + 
//	"JOIN UserRoleCabang r \r\n" + 
//	"on c.id = r.cabangId")
//	public List<ViewCustomerSplit> findAllByCabangName(String cabangName);

	public List<ViewCustomerSplit> findAll();
}