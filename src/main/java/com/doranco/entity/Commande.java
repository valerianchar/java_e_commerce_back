package com.doranco.entity;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "commande")
@NamedQueries({
@NamedQuery(name = "Commande:FindById", query = "FROM Commande c WHERE c.id = :id"),
@NamedQuery(name = "Commande:findAll", query = "FROM Commande c")
})
public class Commande {
	
	public Commande() {
	}


	public Commande(@NotEmpty String numero, @NotEmpty Date dateCreation, @NotEmpty Date dateLivraison,
			@NotEmpty int totalRemise, @NotEmpty int fraisExpedition, @NotEmpty int totalGeneral,
			Adresse adresseFacturation, Adresse adresseLivraison, CartePaiement cartePaiementDefaut,
			Utilisateur utilisateur, Set<LigneDeCommande> lignesCommandes) {
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


	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "numero", length = 30,  nullable = false)
	private String numero;
	
	@NotEmpty
	@Column(name="dateCreation", nullable = false)
	private Date dateCreation;
	
	@NotEmpty
	@Column(name="dateLivraison", nullable = false)
	private Date dateLivraison;
	
	@NotEmpty
	@Column(name = "totalRemise", nullable = false)
	private int totalRemise;
	
	@NotEmpty
	@Column(name = "fraisExpedition", nullable = false)
	private int fraisExpedition;
	
	@NotEmpty
	@Column(name = "totalGeneral", nullable = false)
	private int totalGeneral;
	
	@OneToOne
	private Adresse adresseFacturation;
	
	@OneToOne
	private Adresse adresseLivraison;
	
	@OneToOne
	private CartePaiement cartePaiementDefaut;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
	private Utilisateur utilisateur;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
	private Set<LigneDeCommande> lignesCommandes;


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


	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}


	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}


	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}


	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}


	public CartePaiement getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}


	public void setCartePaiementDefaut(CartePaiement cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Set<LigneDeCommande> getLignesCommandes() {
		return lignesCommandes;
	}


	public void setLignesCommandes(Set<LigneDeCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}
	
	

}
