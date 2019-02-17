package com.mql.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mql.dao.AuthorRepository;
import com.mql.dao.ReviewRepository;
import com.mql.entities.Author;
import com.mql.entities.Reviewer;

public class UserService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public Integer userExist(String username , String password) {
		Author a= authorRepository.findAuthorByNomAndPassword(username, password);
		if(a != null) {
			return 1;
		}
		
		Reviewer r = reviewRepository.findRByNomAndPassword(username, password);
		if(r != null) {
			return 2;
		}
		
		
		return 3;
		
	}
	

}
