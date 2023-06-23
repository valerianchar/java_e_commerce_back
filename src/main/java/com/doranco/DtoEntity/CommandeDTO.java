package com.doranco.DtoEntity;

import java.util.Date;
import java.util.Set;



public class CommandeDTO {
	
	public CommandeDTO() {
	}


	public CommandeDTO( String numero,  Date dateCreation,  Date dateLivraison,
			 int totalRemise,  int fraisExpedition,  int totalGeneral,
			 AdresseDTO adresseFacturation, AdresseDTO adresseLivraison, CartePaiementDTO cartePaiementDefaut,
			UtilisateurDTO utilisateur, Set<LigneDeCommandeDTO> lignesCommandes) {
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.cartePaiementDefaut = cartePaiementDefaut;
		this.utilisateur = utilisateur;
		this.lignesCommandes = lignesCommandes;
	}


	private int id;
	
	private String numero;
	
	private Date dateCreation;
	
	private Date dateLivraison;
	
	private int totalRemise;
	
	private int fraisExpedition;
	
	private int totalGeneral;
	
	private AdresseDTO adresseFacturation;
	
	private AdresseDTO adresseLivraison;
	
	private CartePaiementDTO cartePaiementDefaut;
	
	private UtilisateurDTO utilisateur;
	
	
	private Set<LigneDeCommandeDTO> lignesCommandes;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public int getTotalRemise() {
		return totalRemise;
	}


	public void setTotalRemise(int totalRemise) {
		this.totalRemise = totalRemise;
	}


	public int getFraisExpedition() {
		return fraisExpedition;
	}


	public void setFraisExpedition(int fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}


	public int getTotalGeneral() {
		return totalGeneral;
	}


	public void setTotalGeneral(int totalGeneral) {
		this.totalGeneral = totalGeneral;
	}


	public AdresseDTO getAdresseFacturation() {
		return adresseFacturation;
	}


	public void setAdresseFacturation(AdresseDTO adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}


	public AdresseDTO getAdresseLivraison() {
		return adresseLivraison;
	}


	public void setAdresseLivraison(AdresseDTO adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}


	public CartePaiementDTO getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}


	public void setCartePaiementDefaut(CartePaiementDTO cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}


	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Set<LigneDeCommandeDTO> getLignesCommandes() {
		return lignesCommandes;
	}


	public void setLignesCommandes(Set<LigneDeCommandeDTO> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}
	
	

}
