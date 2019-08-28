package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.StatusData;

@Repository
public interface StatusDataRepo extends JpaRepository<StatusData, Long>{
	@Query("Select a From StatusData a where statusOrder = 1")
	public List<StatusData> findByStatusOrder1();
}
