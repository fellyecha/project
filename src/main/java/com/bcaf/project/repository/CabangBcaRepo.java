package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CabangBca;

@Repository
public interface CabangBcaRepo extends JpaRepository<CabangBca, Long>{
	public List<CabangBca> findByIdCabangKkbBca(Long idCabangKkbBca);
	@Query("select b, (select k.cabangKkb from CabangKkbBca k where b.idCabangKkbBca = k.id) as namaCabangKkb from CabangBca b where b.idCabangKkbBca.idCabangKkbBca = idCabangKkbBca")
	List<CabangBca> findIdCabangKkbBca(@Param("idCabangKkbBca") Long idCabangKkbBca);
}
