package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Position;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long>{

}
