package com.mql.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mql.dao.IArticleRepositoy;
import com.mql.entities.Article;

@Service
@Transactional
public class ArticleMetierImpl implements IArticleMetier {
@Autowired
	private IArticleRepositoy art;

	 EntityManager em;
	public Article getArticle(Long ida) {
		// TODO Auto-generated method stub
		
		Article ar=art.findOne(ida);
	
		return ar;
	}
	
	/*public void setDao(IArticleRepositoy dao) {
		this.dao = dao;
	}

	private IArticleRepositoy dao;

	@Override
	public List<Article> listarticles() {
		// TODO Auto-generated method stub
		return dao.listarticles();
	}

	@Override
	public List<Article> articlsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.articlsParMotCle(mc);
	}

	@Override
	public Article getArticle(Long ida) {
		// TODO Auto-generated method stub
		return dao.getArticle(ida);
	}

	@Override
	public void supprimerArticle(Long ida) {
		// TODO Auto-generated method stub
		dao.supprimerArticle(ida);
	}

	@Override
	public void modifierArticle(Article p) {
		// TODO Auto-generated method stub
		dao.modifierArticle(p);
	}

	@Override
	public List<Author> listAuthors() {
		// TODO Auto-generated method stub
		return dao.listAuthors();
	}

	@Override
	public List<Article> rechercherArticle(Long idAuthor) {
		// TODO Auto-generated method stub
		return dao.rechercherArticle(idAuthor);
	}

	@Override
	public Author getAuthor(Long idAuthor) {
		// TODO Auto-generated method stub
		return dao.getAuthor(idAuthor);
	}

	@Override
	public Article ajouterArticlesansuser(Article a) {
		// TODO Auto-generated method stub
		return dao.ajouterArticlesansuser(a);
	}

	@Override
	public Article ajouterArticle(Article a, Long idAuthor, Long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public List<Article> listarticles() {
		List<Article> arts=new ArrayList<>();
		art.findAll().forEach(arts::add);
		return arts;
		
		
	}
	

	  public List<Article> chercherArticle(String mc) {
			Query req =em.createQuery("select a from Article a where a.titre like :x");
			req.setParameter("x",mc);
			return req.getResultList();
		}
		

	@Override
	public void updateArticle(Long id, Article ar) {
		// TODO Auto-generated method stub
		art.save(ar);
		
	}

	

	@Override
	public Article ajouterarticle(Article a) {
		// TODO Auto-generated method stub
		return art.save(a);
	}

	@Override
	public void deleteArticle(Long idArticle) {
		// TODO Auto-generated method stub
		art.delete(idArticle);
	}

}
