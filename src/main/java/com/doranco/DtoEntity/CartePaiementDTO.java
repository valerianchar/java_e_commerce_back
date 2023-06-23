package com.doranco.DtoEntity;

import java.util.Date;



public class CartePaiementDTO {

	public CartePaiementDTO() {
	}

	public CartePaiementDTO( String nomPorprietaire,  String prenomPorprietaire,
			 Date dateValidite,  String numero,  String chryptogramme, UtilisateurDTO utilisateur) {
		this.nomPorprietaire = nomPorprietaire;
		this.prenomPorprietaire = prenomPorprietaire;
		this.dateValidite = dateValidite;
		this.numero = numero;
		this.chryptogramme = chryptogramme;
		this.utilisateur = utilisateur;
	}

	private int id;
	
	private String nomPorprietaire;	
	
	private String prenomPorprietaire;
	
	private Date dateValidite;
	
	private String numero;
	
	private String chryptogramme;
	
	private UtilisateurDTO utilisateur;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getChryptogramme() {
		return chryptogramme;
	}

	public void setChryptogramme(String chryptogramme) {
		this.chryptogramme = chryptogramme;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
