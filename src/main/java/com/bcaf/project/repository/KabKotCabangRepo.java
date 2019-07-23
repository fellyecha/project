package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.KabKotCabang;

@Repository
public interface KabKotCabangRepo extends JpaRepository<KabKotCabang, Long>{

}
