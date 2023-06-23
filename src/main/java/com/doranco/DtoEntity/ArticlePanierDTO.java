package com.doranco.DtoEntity;



public class ArticlePanierDTO {

	public ArticlePanierDTO() {
	}

	public ArticlePanierDTO(ArticleDTO article, int quantite, UtilisateurDTO utilisateur) {
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	private int id;
	
	private ArticleDTO article;
	
	private int quantite;
	
	private UtilisateurDTO utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
