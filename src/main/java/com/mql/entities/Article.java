package com.mql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Article {
	@Id @GeneratedValue
	private long ID_ARTICLE;
	private String TITRE;
	@Column(length = 65535, columnDefinition = "text")
	private String RESUME;
	private String STATUTREV ;
	private String NOTECHAIR ;
	private boolean PAYER ;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String tITRE, String rESUME, String sTATUTREV, String nOTECHAIR, boolean pAYER) {
		super();
		TITRE = tITRE;
		RESUME = rESUME;
		STATUTREV = sTATUTREV;
		NOTECHAIR = nOTECHAIR;
		PAYER = pAYER;
	}
	public long getID_ARTICLE() {
		return ID_ARTICLE;
	}
	public String getTITRE() {
		return TITRE;
	}
	public String getRESUME() {
		return RESUME;
	}
	public String getSTATUTREV() {
		return STATUTREV;
	}
	public String getNOTECHAIR() {
		return NOTECHAIR;
	}
	public boolean isPAYER() {
		return PAYER;
	}
	public void setID_ARTICLE(long iD_ARTICLE) {
		ID_ARTICLE = iD_ARTICLE;
	}
	public void setTITRE(String tITRE) {
		TITRE = tITRE;
	}
	public void setRESUME(String rESUME) {
		RESUME = rESUME;
	}
	public void setSTATUTREV(String sTATUTREV) {
		STATUTREV = sTATUTREV;
	}
	public void setNOTECHAIR(String nOTECHAIR) {
		NOTECHAIR = nOTECHAIR;
	}
	public void setPAYER(boolean pAYER) {
		PAYER = pAYER;
	}
	
	
	
	

}
