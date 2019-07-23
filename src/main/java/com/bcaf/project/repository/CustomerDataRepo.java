package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.CustomerData;

@Repository
public interface CustomerDataRepo extends JpaRepository<CustomerData, Long>{

}
