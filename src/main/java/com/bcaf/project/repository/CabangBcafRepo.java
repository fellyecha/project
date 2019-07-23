package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CabangBcaf;

@Repository
public interface CabangBcafRepo extends JpaRepository<CabangBcaf, Long>{
	public List<CabangBcaf> findByIdCabangDs(Long idCabangDs);
	@Query("select b from CabangBcaf b where b.idCabangDs.idCabangDs = idCabangDs")
	List<CabangBcaf> findIdCabangDs(@Param("idCabangDs") Long idCabangDs);
}
