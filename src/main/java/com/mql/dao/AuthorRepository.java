package com.mql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mql.entities.Author;
import com.mql.entities.Reviewer_Article;


public interface AuthorRepository extends JpaRepository<Author, Long> {
	@Query("select o from Author o where o.nom=:x and o.password=:y")
	public Author findAuthorByNomAndPassword(@Param("x") String nom,@Param("y") String password);

}
