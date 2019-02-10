package com.mql;

//import com.mql.dao.ArticleRepositoy;
import com.mql.dao.AuthorRepository;
import com.mql.dao.IArticleRepositoy;
import com.mql.metier.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mql.entities.Article;
import com.mql.entities.Author;
import com.mql.metier.ArticleMetierImpl;

@SpringBootApplication
public class GestionConferenceApplication implements CommandLineRunner {

	@Autowired
	private AuthorRepository atr;
	@Autowired
	private IArticleRepositoy articleRepositoy;
	@Autowired 
 	private ArticleMetierImpl artt;
	public static void main(String[] args) {
	SpringApplication.run(GestionConferenceApplication.class, args);
   
   
   
		
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author a1=atr.save(new Author("fadwa"));
		Author a2=atr.save(new Author("fadwa"));
		//Author a2=authorRepository.save(new Author("imane"));
	
		
	//Article ar1=articleRepositoy.save(new Article("titre", "resume", "acceptee", new Date(), 10L, true, a1));
	System.out.println("hahoi");
	artt.listarticles();
	System.out.println("insertiooonnnnnnnnnnnnn");
	//articleMetierImpl.ajouterArticlesansuser(new Article("ff", "resume", "", new Date(), 5L, false, a2));
//	artt.ajouterarticle(new Article("titre3", "res55ume3", "acceptee", new Date(), 155L, true, a2));
	//artt.updateArticle(2L, new Article("titreUP", "reGFF", "", new Date(), 155L, true, a2));
	}
	

}

