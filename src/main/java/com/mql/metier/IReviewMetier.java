package com.mql.metier;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.mql.entities.Reviewer;
@Configuration
public interface IReviewMetier {
	public List<Reviewer> listRev();
}
