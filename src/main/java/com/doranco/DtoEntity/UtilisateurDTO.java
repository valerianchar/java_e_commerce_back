package com.doranco.DtoEntity;

import java.util.Date;
import java.util.List;
import java.util.Set;


public class UtilisateurDTO {

	public UtilisateurDTO() {
	}

	public UtilisateurDTO( String nom,  String prenom,  String dateDeNaissance,
			 boolean isActif,  String profil,  String email,  String password,
			 String telephone, Set<AdresseDTO> adresse, Set<CommandeDTO> commandes,
			Set<CartePaiementDTO> cartesPaiement, Set<CommentaireDTO> commentaires, List<ArticlePanierDTO> panier) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.commandes = commandes;
		this.cartesPaiement = cartesPaiement;
		this.commentaires = commentaires;
		this.panier = panier;
	}

	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String dateDeNaissance;
	
	private boolean isActif;
	
	private String profil;
	
	private String email;
	
	private String password;
	
	private String telephone;
	
	private Set<AdresseDTO> adresse;
	
	private Set<CommandeDTO> commandes;
	
	private Set<CartePaiementDTO> cartesPaiement;
	
	private Set<CommentaireDTO> commentaires;
	
	private List<ArticlePanierDTO> panier;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<AdresseDTO> getAdresse() {
		return adresse;
	}

	public void setAdresse(Set<AdresseDTO> adresse) {
		this.adresse = adresse;
	}

	public Set<CommandeDTO> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<CommandeDTO> commandes) {
		this.commandes = commandes;
	}

	public Set<CartePaiementDTO> getCartesPaiement() {
		return cartesPaiement;
	}

	public void setCartesPaiement(Set<CartePaiementDTO> cartesPaiement) {
		this.cartesPaiement = cartesPaiement;
	}

	public Set<CommentaireDTO> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public List<ArticlePanierDTO> getPanier() {
		return panier;
	}

	public void setPanier(List<ArticlePanierDTO> panier) {
		this.panier = panier;
	}

	
}
