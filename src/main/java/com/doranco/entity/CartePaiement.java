package com.doranco.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "cartePaiement")
@NamedQueries({
@NamedQuery(name = "CartePaiement:FindById", query = "FROM CartePaiement ca WHERE ca.id = :id"),
@NamedQuery(name = "CartePaiement:findAll", query = "FROM CartePaiement ca")
})
public class CartePaiement {

	public CartePaiement(@NotEmpty String nomPorprietaire, @NotEmpty String prenomPorprietaire,
			@NotEmpty Date dateValidite, Utilisateur utilisateur) {
		super();
		this.nomPorprietaire = nomPorprietaire;
		this.prenomPorprietaire = prenomPorprietaire;
		this.dateValidite = dateValidite;
		this.utilisateur = utilisateur;
	}

	public CartePaiement() {
	}

	public CartePaiement(@NotEmpty String nomPorprietaire, @NotEmpty String prenomPorprietaire,
			@NotEmpty Date dateValidite, @NotEmpty byte[] numero, @NotEmpty byte[] chryptogramme, Utilisateur utilisateur) {
		this.nomPorprietaire = nomPorprietaire;
		this.prenomPorprietaire = prenomPorprietaire;
		this.dateValidite = dateValidite;
		this.numero = numero;
		this.chryptogramme = chryptogramme;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "nomPorprietaire", length = 30,  nullable = false)
	private String nomPorprietaire;	
	
	@NotEmpty
	@Column(name = "prenomPorprietaire", length = 30,  nullable = false)
	private String prenomPorprietaire;
	
	@NotEmpty
	@Column(name="dateValidite", nullable = false)
	private Date dateValidite;
	
	@NotEmpty
	@Column(name = "numero", nullable = false, columnDefinition = "TINYBLOB")
	@Lob
	private byte[] numero;
	
	@NotEmpty
	@Column(name = "chryptogramme", nullable = false, columnDefinition = "TINYBLOB")
	@Lob
	private byte[] chryptogramme;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
	private Utilisateur utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPorprietaire() {
		return nomPorprietaire;
	}

	public void setNomPorprietaire(String nomPorprietaire) {
		this.nomPorprietaire = nomPorprietaire;
	}

	public String getPrenomPorprietaire() {
		return prenomPorprietaire;
	}

	public void setPrenomPorprietaire(String prenomPorprietaire) {
		this.prenomPorprietaire = prenomPorprietaire;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public byte[] getChryptogramme() {
		return chryptogramme;
	}

	public void setChryptogramme(byte[] chryptogramme) {
		this.chryptogramme = chryptogramme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
