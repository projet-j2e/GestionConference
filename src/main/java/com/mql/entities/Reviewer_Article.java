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
	
	
}
