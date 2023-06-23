package com.doranco.entity;

import javax.persistence.CascadeType;
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
@Table(name = "articlePanier")
@NamedQueries({
@NamedQuery(name = "ArticlePanier:FindById", query = "FROM ArticlePanier artp WHERE artp.id = :id"),
@NamedQuery(name = "ArticlePanier:findAll", query = "FROM ArticlePanier artp")
})
public class ArticlePanier {

	public ArticlePanier() {
	}

	public ArticlePanier(Article article, @NotEmpty int quantite, Utilisateur utilisateur) {
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Article article;
	
	@NotEmpty
	@Column(name = "nom", nullable = false)
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id", nullable = false)
	private Utilisateur utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
