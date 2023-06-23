package com.doranco.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "user")
@NamedQueries({
@NamedQuery(name = "Utilisateur:findByEmail", query = "FROM Utilisateur u WHERE u.email = :email"),
@NamedQuery(name = "Utilisateur:findByID", query = "FROM Utilisateur u WHERE u.id = :id"),
@NamedQuery(name = "Utilisateur:findAll", query = "FROM Utilisateur u")
})
public class Utilisateur {

	public Utilisateur(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty Date dateDeNaissance,
			@NotEmpty boolean isActif, @NotEmpty String profil, @NotEmpty String email,
			@NotEmpty String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.telephone = telephone;
	}

	public Utilisateur() {
	}

	public Utilisateur(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty Date dateDeNaissance,
			@NotEmpty boolean isActif, @NotEmpty String profil, @NotEmpty String email, @NotNull byte[] password,
			@NotEmpty String telephone, Set<Adresse> adresse, Set<Commande> commandes,
			Set<CartePaiement> cartesPaiement, Set<Commentaire> commentaires, List<ArticlePanier> panier) {
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

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name = "nom", length = 30,  nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;
	
	@Column(name="dateNaissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	
	@Column(name="isActif", nullable=false)
	private boolean isActif;
	
	@NotEmpty
	@Column(name="profil", nullable=false)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", length = 30, nullable = false, unique = true, updatable = false)
	private String email;
	
	@NotNull
	@Column(name = "password", nullable = false, columnDefinition = "TINYBLOB")
	@Lob
	private byte[] password; //à Crypter
	
	@NotEmpty
	@Column(name="telephone", length=15 ,nullable=false)
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<Adresse> adresse;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<CartePaiement> cartesPaiement;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private List<ArticlePanier> panier;

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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Adresse> getAdresse() {
		return adresse;
	}

	public void setAdresse(Set<Adresse> adresse) {
		this.adresse = adresse;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}

	public void setCartesPaiement(Set<CartePaiement> cartesPaiement) {
		this.cartesPaiement = cartesPaiement;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	public void setPanier(List<ArticlePanier> panier) {
		this.panier = panier;
	}

	
}
