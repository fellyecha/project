package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CabangKkbBca;

@Repository
public interface CabangKkbBcaRepo extends JpaRepository<CabangKkbBca, Long>{
	public List<CabangKkbBca> findByCabangKkb(String cabangKkb);

}
