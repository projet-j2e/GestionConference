package com.mql.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mql.entities.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
	

}
