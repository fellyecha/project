package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.KategoriPermasalahan;

public interface KategoriPermasalahanRepo extends JpaRepository<KategoriPermasalahan, Long>{
	public List<KategoriPermasalahan> findAll();
}
