package com.mql.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("REVIEWER")
public class Reviewer {
	
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String name;
	@OneToMany(fetch=FetchType.LAZY)
	private Collection<Article> article;
	
	public Reviewer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reviewer(String name, Collection<Article> article) {
		super();
		this.name = name;
		this.article = article;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Article> getArticle() {
		return article;
	}

	public void setArticle(Collection<Article> article) {
		this.article = article;
	}
	
	
	
	

	

	
	
}
