package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
