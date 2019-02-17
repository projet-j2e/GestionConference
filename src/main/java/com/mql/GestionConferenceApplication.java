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

	}
	

}

