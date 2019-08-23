package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.ViewCustomerData;

public interface ViewCustomerDataRepo extends JpaRepository<ViewCustomerData, Long>{
	public List<ViewCustomerData> findAll();

}
