package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Kecamatan;

@Repository
public interface KecamatanRepo extends JpaRepository<Kecamatan, Long>{
	public List<Kecamatan> findByIdKabKota(Long idKabKota);
}
