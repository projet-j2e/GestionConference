package com.mql.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mql.dao.IArticleRepositoy;
import com.mql.dao.ReviewRepository;
import com.mql.dao.viewRepo;
import com.mql.entities.Article;
import com.mql.entities.Reviewer;
import com.mql.metier.IArticleMetier;
import com.mql.metier.IReviewMetier;

@Controller
public class AffectController {
	
	
	@Autowired
	private IArticleMetier artm;
	
	
	
	@RequestMapping("/affectList")
	public ModelAndView GetList(RedirectAttributes attributes) {
		
		Collection<Article> articles=artm.listarticles();
		
		Collection<Reviewer> reviewers=artm.listRev();
		
		Map<String, Collection<?>> list = new HashMap<String, Collection<?>>();
		list.put("article", articles);
		list.put("reviewers", reviewers);
		return new ModelAndView("affect","list",list);
	}

}
