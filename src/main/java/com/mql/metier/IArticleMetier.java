package com.mql.metier;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mql.entities.Article;
import com.mql.entities.Author;
import com.mql.entities.Reviewer;

//@Transactional
@Aspect
@Configuration
public interface IArticleMetier  {
	
	public Article getArticle(Long ida);
	public List<Reviewer> listRev();
	public List<Article> listarticles();
	public void updateArticle(Long id,Article ar);
	public void deleteArticle(Long idArticle);
	public Article ajouterarticle(Article a);
	public List<Article> chercherArticle(String mc);
//	@After("com.mql.web.PaiementController.pay()")
	public void facture(Article article) ;
	
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
