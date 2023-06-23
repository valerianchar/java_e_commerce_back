package com.doranco.entity;

import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "article")
@NamedQueries({
@NamedQuery(name = "Article:FindById", query = "FROM Article a WHERE a.id = :id"),
@NamedQuery(name = "Article:findAll", query = "FROM Article a")
})
public class Article {

	public Article() {
	}

	public Article(@NotEmpty String nom, @NotEmpty String description, int prix, int remise,
			int stock, boolean isVendable, @NotEmpty String photo, @NotEmpty String video,
			Set<Commentaire> commentaires, Categorie categorie) {
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

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "nom", length = 30,  nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "description", length = 30,  nullable = false)
	private String description;
	
	@Column(name = "prix", nullable = false)
	private int prix;
	
	@Column(name = "remise", nullable = false)
	private int remise;
	
	@Column(name = "stock", nullable = false)
	private int stock;
	
	@Column(name = "isVendable", nullable = false)
	private boolean isVendable;
	
	@NotEmpty
	@Column(name = "photo", nullable = false)
	private String photo;
	
	@NotEmpty
	@Column(name = "video", nullable = false)
	private String video;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
	private Set<Commentaire> commentaires;

	@ManyToOne
	@JoinColumn(name = "categorie_id", referencedColumnName = "id", nullable = false)
	private Categorie categorie;

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

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
