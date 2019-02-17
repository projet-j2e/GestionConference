package com.mql.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mql.Service.UserService;
import com.mql.dao.AuthorRepository;
import com.mql.dao.ReviewRepository;
import com.mql.entities.Article;
import com.mql.entities.Author;
import com.mql.entities.Reviewer;
import com.mql.entities.Reviewer_Article;

@Controller
public class UserController {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@RequestMapping(value="/AuthorInscription",method=RequestMethod.POST)
	public String addReview(@Valid Author author) {
		Author a= authorRepository.findAuthorByNomAndPassword(author.getNom(), author.getPassword());
		
		if(a == null) {
		authorRepository.save(author);
		return "redirect:/login";
		}
		return "redirect:/register";
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		Author author=new Author();
		return new ModelAndView("registre","Author",author);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public RedirectView login(@Valid Author author,RedirectAttributes attributes) {
		
		Reviewer r = reviewRepository.findRByNomAndPassword(author.getNom(),  author.getPassword()); 
		Author a= authorRepository.findAuthorByNomAndPassword(author.getNom(), author.getPassword());
		if(a != null) {
			attributes.addAttribute("id",a.getIdAuthor());
		return  new RedirectView("/viewArticlelist");
		}
		else if(r !=null) {
			attributes.addAttribute("id",r.getId());
			return  new RedirectView("/getreview");
		}
		return  new RedirectView("/login");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		Author author=new Author();
		return new ModelAndView("login","Author",author);
	}
	
	
}
