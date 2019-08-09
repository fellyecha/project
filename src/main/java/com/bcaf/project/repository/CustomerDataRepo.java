package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CustomerData;
import com.bcaf.project.model.ViewPosition;

@Repository
public interface CustomerDataRepo extends JpaRepository<CustomerData, Long>{
	public List<CustomerData> findAll();
	
//	@Query("select a from CustomerData a \r\n" + 
//			"join CabangDs c \r\n" + 
//			"on a.cabangName = c.cabangName \r\n" + 
//			"JOIN UserRoleCabang r \r\n" + 
//			"on c.id = r.cabangId")
	public List<CustomerData> findByCabangName(String cabangName);
	
}
