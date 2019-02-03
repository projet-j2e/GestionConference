package com.mql;

import com.mql.dao.ArticleRepositoy;
import com.mql.dao.AuthorRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mql.entities.Article;
import com.mql.entities.Author;

@SpringBootApplication
public class GestionConferenceApplication implements CommandLineRunner {

	@Autowired
	private AuthorRepository atr;
	@Autowired
	private ArticleRepositoy articleRepositoy;
	public static void main(String[] args) {
	SpringApplication.run(GestionConferenceApplication.class, args);
   
   
   
		
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author a1=atr.save(new Author("fadwa"));
		//Author a2=authorRepository.save(new Author("imane"));
	
		
		Article ar1=articleRepositoy.save(new Article("titre", "resume", "acceptee", new Date(), 10L, true, a1));
	}
	

}

