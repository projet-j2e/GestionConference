package com.mql.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mql.dao.ReviewRepository;

import com.mql.entities.Reviewer;

public class ReviewMetierimpl implements IReviewMetier{
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Reviewer> listRev() {
		List<Reviewer> rev=new ArrayList<>();
		reviewRepository.findAll().forEach(rev::add);
		return rev;
	}



	

}
