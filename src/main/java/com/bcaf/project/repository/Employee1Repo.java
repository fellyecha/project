package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Employee1;

@Repository
public interface Employee1Repo extends JpaRepository<Employee1, Long>{
	public Employee1 findByNip(String nip);
}
