package com.mql.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mql.dao.IArticleRepositoy;
import com.mql.entities.Article;
import com.mql.metier.ArticleMetierImpl;
import com.mql.metier.IArticleMetier;

@Controller
public class ArticleController {
	@Autowired
	private IArticleMetier artm;
	@Autowired
	private IArticleRepositoy articleRepositoy;

	@RequestMapping(value = "/Addarticle", method = RequestMethod.GET)
	public String newArticle(ModelMap model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "Addarticle";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveArticle(@Valid Article article, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {
		artm.ajouterarticle(article);
		return "redirect:/viewArticlelist";
	}

	@GetMapping(value = "/editArticle")
	public String editArticle(Long idArticle, Model model) {

		Article article = articleRepositoy.getOne(idArticle);
		model.addAttribute("article", article);
		System.out.println("vv");
		return "editArticle";
	}

	@RequestMapping(value = "/updatearticle", method = RequestMethod.POST)
	public String editsave(@Valid Article et, BindingResult result) {
		articleRepositoy.save(et);
		return "redirect:viewArticlelist";
	}

	@RequestMapping(value = "/deletearticle", method = RequestMethod.GET)
	public String supprimer(Long idArticle) {
		artm.deleteArticle(idArticle);
		System.out.println("tmshaaat");
		return "redirect:/viewArticlelist";
	}

	@RequestMapping("/viewArticlelist")
	public ModelAndView getAll() {
		List<Article> list = artm.listarticles();
		return new ModelAndView("viewArticlelist", "list", list);
	}

	@RequestMapping("/chercherArticle")
	public String consulter(Model model, Long idArticle) {
		try {
			Article ar = artm.getArticle(idArticle);
			model.addAttribute("article", ar);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "chercherArticle";
	}
	/*
	 * @RequestMapping("/chercherArticlecode") public String consulter2(Model
	 * model,@RequestParam(name="motCle") ) {
	 * 
	 * try { Article ar=artm.getArticle(idArticle); model.addAttribute("article",
	 * ar); }catch(Exception e) { model.addAttribute("exception", e); }
	 * 
	 * //List<Article> list=artm.listarticles(); return "chercherArticle";
	 * 
	 * }
	 */

}
