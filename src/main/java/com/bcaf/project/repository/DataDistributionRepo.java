package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.DataDistribution;

public interface DataDistributionRepo extends JpaRepository<DataDistribution, Long>{
	public List<DataDistribution> findAll();
}
