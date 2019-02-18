package com.mql.web;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mql.dao.IArticleRepositoy;
import com.mql.entities.Article;
import com.mql.metier.IArticleMetier;
@Aspect
@Configuration
@Controller
public class PaiementController {
	long c=0;
	@Autowired
	private IArticleMetier artm;
	@Autowired
	private IArticleRepositoy articleRepositoy;
	
	@RequestMapping("/payerP")
	@ResponseBody
    public RedirectView redirectWithUsingRedirectView(
      RedirectAttributes attributes,@RequestParam("idArticle") int idArticle) {
        attributes.addAttribute("upload", "1");
        attributes.addAttribute("return", "http://localhost:7777/payers");
        attributes.addAttribute("cmd", "_cart");
        attributes.addAttribute("business", "hamza16haddad@gmail.com");
        attributes.addAttribute("item_name_1", "participation au conference");
        attributes.addAttribute("amount_1", "100");
        attributes.addAttribute("item_name_2", "l’hébergement à l’hôtel");
        attributes.addAttribute("amount_2", "500");
        attributes.addAttribute("item_name_3", "une visite touristique");
        attributes.addAttribute("amount_3", "300");
        attributes.addAttribute("item_name_4", "une soirée Gala");
        attributes.addAttribute("amount_4", "200");
        attributes.addAttribute("rm", "2");
        c=idArticle;
        return new RedirectView("https://www.sandbox.paypal.com/cgi-bin/webscr");
	}
	
	@RequestMapping("/payers")
	public String pay() {
		Article article=articleRepositoy.getOne(c);
		article.setPaye(true);
		articleRepositoy.save(article);
		artm.facture(article);
		return "redirect:/viewArticlelist";
	}
	

}
