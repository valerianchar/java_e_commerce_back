package com.doranco.DtoEntity;

import java.util.List;


public class CategorieDTO {

	public CategorieDTO() {
	}

	public CategorieDTO( String nom,  int remise,  boolean isRemiseCumulable,
			 String photo, List<ArticleDTO> articles) {
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photo = photo;
		this.articles = articles;
	}

	private int id;
	
	private String nom;
	
	private int remise;
	
	private boolean isRemiseCumulable;
	
	private String photo;
	
	private List<ArticleDTO> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public boolean isRemiseCumulable() {
		return isRemiseCumulable;
	}

	public void setRemiseCumulable(boolean isRemiseCumulable) {
		this.isRemiseCumulable = isRemiseCumulable;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<ArticleDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleDTO> articles) {
		this.articles = articles;
	}
	
}
