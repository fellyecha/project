package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.KabupatenKota;

@Repository
public interface KabupatenKotaRepo extends JpaRepository<KabupatenKota, Long>{
	public List<KabupatenKota> findByIdProvinsi(Long idProvinsi);
	@Query("select k from KabupatenKota k where k.idProvinsi = :idProvinsi")
	List<KabupatenKota> findIdProvinsi(@Param("idProvinsi") Long idProvinsi);
}
