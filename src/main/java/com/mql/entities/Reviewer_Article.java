package com.mql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Reviewer_Article {
	@Id 
	private int id;
	@Column(name="review", nullable = false)
	@org.hibernate.annotations.ColumnDefault("0")
	private int review= 0;
	private Long article_id_article;
	private Long reviewer_id;
	private boolean vote;
	
	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public Reviewer_Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reviewer_Article(int review) {
		super();
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public Long getArticle_id_article() {
		return article_id_article;
	}

	public void setArticle_id_article(Long article_id_article) {
		this.article_id_article = article_id_article;
	}

	public Long getReviewer_id() {
		return reviewer_id;
	}

	public void setReviewer_id(Long reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	
	
	
}
