package com.mql.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Author implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAuthor;
	
	private String nom;
	@OneToMany(mappedBy="author",fetch=FetchType.LAZY)
	private 	Collection <Article>  articles;
	

	
	
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(String nom) {
		super();
		this.nom = nom;
	}
	public Long getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Collection<Article> getArticles() {
		return articles;
	}
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	
	

	
	
}
