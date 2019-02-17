package com.mql.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mql.dao.IArticleRepositoy;
import com.mql.dao.ReviewRepository;
import com.mql.dao.viewRepo;
import com.mql.entities.Article;
import com.mql.entities.Reviewer;
import com.mql.entities.Reviewer_Article;
import com.mql.metier.IArticleMetier;
import com.mql.metier.IReviewMetier;

@Controller
public class ReviewController {
	private Long idR=(long) 0;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private IArticleMetier artm;
	@Autowired
	private viewRepo v;
	@Autowired
	private IArticleRepositoy iArticleRepositoy;
	
	@RequestMapping("/review")
	public RedirectView GetReview(Model model,Long reviewId ) {
	
		Reviewer reviewer = reviewRepository.findOne((long) 1);
		//Reviewer r=reviewRepository.findOne(reviewId);
		Collection<Article> articles=reviewer.getArticle();
		Article article=artm.getArticle((long) 3);
		
		articles.add(article);
		reviewer.setArticle(articles);
		reviewRepository.save(reviewer);
		//System.out.println(reviewer.getName());
		return new RedirectView("/getreview");
	}
	
	@RequestMapping("/getreview")
	public ModelAndView Review(@PathParam("id") Long id) {
		this.idR=id;
		Reviewer reviewer = reviewRepository.findOne(id);
		Collection<Article> list=reviewer.getArticle();
		for (Article Article : list) {
			Reviewer_Article a = v.GetArticle(Article.getIdArticle(), id);
			if(a.isVote()) {
				list.remove(Article);
			}
		}
		return new ModelAndView("reviewInterface","list",list);
	}

	@RequestMapping("accept")
	public RedirectView addReview(@RequestParam("idArticle") Long idArticle) {
		//Reviewer reviewer = reviewRepository.findOne((long) 1);
		Article article=artm.getArticle((long) idArticle);
		
		//Collection<Article> articles=reviewer.getArticle();
		//articles.add(article);
		//reviewer.setArticle(articles);
		//reviewRepository.save(reviewer);
		Reviewer_Article a = v.GetArticle(idArticle, this.idR);
		//--------------------------
		if(a.getReview() == 1) {
			article.setStatut("accepter");
			iArticleRepositoy.save(article);
		}
		//------------------------
		a.setReview(a.getReview()+1);
		a.setVote(true);
		v.save(a);
		
		return new RedirectView("/getreview");
	}
	
	@RequestMapping("refuse")
	public RedirectView addReview2(@RequestParam("idArticle") Long idArticle,RedirectAttributes attributes) {
		//Reviewer reviewer = reviewRepository.findOne((long) 1);
	    Article article=artm.getArticle((long) idArticle);
		//Collection<Article> articles=reviewer.getArticle();
		//articles.add(article);
		//reviewer.setArticle(articles);
		//reviewRepository.save(reviewer);
		Reviewer_Article a = v.GetArticle(idArticle, this.idR);
		if(a.getReview() == -1) {
			article.setStatut("refuser");
			iArticleRepositoy.save(article);
		}
		a.setReview(a.getReview()-1);
		a.setVote(true);
		v.save(a);
		
		return new RedirectView("/getreview");
	}
}
