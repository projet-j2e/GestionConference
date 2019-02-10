package com.mql.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mql.entities.Article;
import com.mql.entities.Author;

public interface IArticleRepositoy  extends JpaRepository<Article, Long> {
 

	/*
	public List<Article> listarticles();

	public List<Article> articlsParMotCle(String mc);


	public Article getArticle(Long ida);

	public void supprimerArticle(Long ida);

	public void modifierArticle(Article p);

	public List<Author> listAuthors();
	
	public List<Article> rechercherArticle(Long idAuthor);

	public Author getAuthor(Long idAuthor);
	public Article ajouterArticlesansuser(Article a);

	Article ajouterArticle(Article a, Long idAuthor, Long idArticle);*/
	

}
