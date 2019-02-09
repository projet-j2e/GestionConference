package com.mql.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long IdArticle ; 
    @NotEmpty
	  private String Titre;
      @NotEmpty
   @Size(min=4,max=100)
	  private String Resume;
  //  @NotEmpty
  // @Column(columnDefinition = "varchar(20) default 'refusé'")
	  private String Statut;
   @Column(name = "datecreation", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String datecreation=new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    //@Column(name="Notechair",columnDefinition="Long default 0")
	  private Long Notechair=0L;
   // @NotEmpty
    private Boolean paye ;
  
    @ManyToOne
    @JoinColumn(name="idAuthor")
	private Author author;
    
    
	  public Article() {
			super();
			// TODO Auto-generated constructor stub
		}


	public Article( String titre, String resume, String statut, String datecreation, Long notechair,
			Boolean paye, Author author) {
		super();
	
		Titre = titre;
		Resume = resume;
		Statut = statut;
		this.datecreation = datecreation;
		Notechair = notechair;
		this.paye = paye;
		this.author = author;
		
	}


	public Long getIdArticle() {
		return IdArticle;
	}


	public void setIdArticle(Long idArticle) {
		IdArticle = idArticle;
	}


	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}


	public String getResume() {
		return Resume;
	}


	public void setResume(String resume) {
		Resume = resume;
	}


	public String getStatut() {
		return Statut;
	}


	public void setStatut(String statut) {
		Statut = statut;
	}


	public String getDatecreation() {
		return datecreation;
	}


	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}


	public Long getNotechair() {
		return Notechair;
	}


	public void setNotechair(Long notechair) {
		Notechair = notechair;
	}


	public Boolean getPaye() {
		return paye;
	}


	public void setPaye(Boolean paye) {
		this.paye = paye;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}
	  
	  
	  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
