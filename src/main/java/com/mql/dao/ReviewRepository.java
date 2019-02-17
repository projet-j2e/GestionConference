package com.mql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mql.entities.Author;
import com.mql.entities.Reviewer;

public interface ReviewRepository extends JpaRepository<Reviewer, Long>{
	
	@Query("select o from Reviewer o where o.name=:x and o.password=:y")
	public Reviewer findRByNomAndPassword(@Param("x") String nom,@Param("y") String password);

}
