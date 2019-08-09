package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bcaf.project.model.ViewCustomerSplit;

public interface ViewCustomerSplitRepo extends JpaRepository<ViewCustomerSplit, Long> {
	@Query("SELECT c FROM ViewCustomerSplit c")
	public List<ViewCustomerSplit> findAllByCabangName();
}
