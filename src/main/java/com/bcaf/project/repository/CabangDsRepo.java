package com.bcaf.project.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CabangDs;

@Repository
public interface CabangDsRepo extends JpaRepository<CabangDs, Long>{
	public CabangDs findByCabangName(String cabangName);
}
