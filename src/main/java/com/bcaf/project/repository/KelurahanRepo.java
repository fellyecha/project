package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Kelurahan;

@Repository
public interface KelurahanRepo extends JpaRepository<Kelurahan, Long>{
	public List<Kelurahan> findByIdKecamatan(Long idKecamatan);
}
