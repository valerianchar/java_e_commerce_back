package com.doranco.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "categorie")
@NamedQueries({
@NamedQuery(name = "Categorie:FindById", query = "FROM Categorie ca WHERE ca.id = :id"),
@NamedQuery(name = "Categorie:findAll", query = "FROM Categorie ca")
})
public class Categorie {

	public Categorie() {
	}

	public Categorie(@NotEmpty String nom, @NotEmpty int remise, @NotEmpty boolean isRemiseCumulable,
			@NotEmpty String photo, List<Article> articles) {
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photo = photo;
		this.articles = articles;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "nom", length = 30,  nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "remise", nullable = false)
	private int remise;
	
	@NotEmpty
	@Column(name = "isRemiseCumulable", nullable = false)
	private boolean isRemiseCumulable;
	
	@NotEmpty
	@Column(name = "photo", nullable = false)
	private String photo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	@JsonIgnore
	private List<Article> articles;

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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
