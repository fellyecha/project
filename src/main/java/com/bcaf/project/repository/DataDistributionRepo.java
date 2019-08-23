package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.DataDistribution;

@Repository
public interface DataDistributionRepo extends JpaRepository<DataDistribution, Long>{
	public List<DataDistribution> findAll();
	
//	@Query("select a from DataDistribution a \r\n" + 
//	"join CabangDs c \r\n" + 
//	"on a.cabangName = c.cabangName \r\n" + 
//	"JOIN UserRoleCabang r \r\n" + 
//	"on c.id = r.cabangId")
//	public List<DataDistribution> find_by_cabang_ds_id();
}
