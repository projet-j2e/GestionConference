package com.mql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mql.entities.Article;

public interface ArticleRepositoy extends JpaRepository<Article,Long> {

}
