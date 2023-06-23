package com.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "commentaire")
@NamedQueries({
@NamedQuery(name = "Commentaire:FindById", query = "FROM Commentaire com WHERE com.id = :id"),
@NamedQuery(name = "Commentaire:findAll", query = "FROM Commentaire com")
})
public class Commentaire {

	
	public Commentaire() {
	}

	public Commentaire(@NotEmpty String texte, @NotEmpty int note, Article article, Utilisateur utilisateur) {
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "texte", length = 30,  nullable = false)
	private String texte;
	
	@Column(name = "note", nullable = false)
	private int note;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private Utilisateur utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilsateur() {
		return utilisateur;
	}

	public void setUtilsateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
