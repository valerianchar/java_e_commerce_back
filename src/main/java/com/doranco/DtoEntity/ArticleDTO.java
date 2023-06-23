package com.doranco.DtoEntity;

import java.util.Set;

public class ArticleDTO {

	public ArticleDTO() {
	}

	public ArticleDTO( String nom,  String description,  int prix,  int remise,
			 int stock,  boolean isVendable,  String photo,  String video,
			 Set<CommentaireDTO> commentaires, CategorieDTO categorie) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.photo = photo;
		this.video = video;
		this.commentaires = commentaires;
		this.categorie = categorie;
	}

	private int id;
	
	private String nom;
	
	private String description;
	
	private int prix;
	
	private int remise;
	
	private int stock;
	
	private boolean isVendable;
	
	private String photo;
	
	private String video;
	
	private Set<CommentaireDTO> commentaires;

	private CategorieDTO categorie;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Set<CommentaireDTO> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public CategorieDTO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieDTO categorie) {
		this.categorie = categorie;
	}
	
}
