package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CustomerData;
import com.bcaf.project.model.UserRoleCabang;

@Repository
public interface UserRoleCabangRepo extends JpaRepository<UserRoleCabang, Long>{
	List<UserRoleCabangRepo> findByCabangId(Long cabangId);
}
