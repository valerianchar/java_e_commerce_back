package com.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "ligneDeCommande")
@NamedQueries({
@NamedQuery(name = "LigneDeCommande:FindById", query = "FROM LigneDeCommande lc WHERE lc.id = :id"),
@NamedQuery(name = "LigneDeCommande:findAll", query = "FROM LigneDeCommande lc")
})
public class LigneDeCommande {
	
	public LigneDeCommande() {
	}

	public LigneDeCommande(@NotEmpty int quantite, @NotEmpty int prixUnitaire, @NotEmpty int remiseArticle,
			Commande commande, Article article) {
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "quantite", nullable = false)
	private int quantite;
	
	@NotEmpty
	@Column(name = "prixUnitaire", nullable = false)
	private int prixUnitaire;
	
	@NotEmpty
	@Column(name = "remiseArticle", nullable = false)
	private int remiseArticle;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id", nullable=false)
	private Commande commande;
	
	@OneToOne
	private Article article;

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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	

}
