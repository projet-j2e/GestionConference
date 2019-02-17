package com.mql.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mql.entities.Reviewer_Article;

public interface viewRepo extends JpaRepository<Reviewer_Article, Integer> {

	@Query("select o from Reviewer_Article o where o.article_id_article=:x and o.reviewer_id=:y")
	public Reviewer_Article GetArticle(@Param("x") Long idarticle,@Param("y") Long idreviewer);
	
}
