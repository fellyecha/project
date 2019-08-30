package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcaf.project.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
