package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.ViewPosition;

@Repository
public interface ViewPositionRepo  extends JpaRepository<ViewPosition, Long> {
	@Query("SELECT a FROM ViewPosition a")
	public List<ViewPosition> findAllByParent();
}
