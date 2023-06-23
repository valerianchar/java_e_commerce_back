package com.doranco.DtoEntity;

public class LigneDeCommandeDTO {
	
	public LigneDeCommandeDTO() {
	}

	public LigneDeCommandeDTO( int quantite,  int prixUnitaire,  int remiseArticle,
			CommandeDTO commande, ArticleDTO article) {
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	private int id;
	
	private int quantite;
	
	private int prixUnitaire;
	
	private int remiseArticle;
	
	private CommandeDTO commande;
	
	private ArticleDTO article;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(int remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public CommandeDTO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDTO commande) {
		this.commande = commande;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}
	

}
