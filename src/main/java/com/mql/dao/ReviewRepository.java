package com.mql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mql.entities.Reviewer;

public interface ReviewRepository extends JpaRepository<Reviewer, Long>{

}
