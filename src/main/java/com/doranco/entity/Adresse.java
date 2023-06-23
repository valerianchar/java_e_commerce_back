package com.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "adresse")
@NamedQueries({ @NamedQuery(name = "Adresse:FindById", query = "FROM Adresse a WHERE a.id = :id"),
		@NamedQuery(name = "Adresse:findAll", query = "FROM Adresse a") })
public class Adresse {

	public Adresse() {
	}

	public Adresse(@NotEmpty String numero, @NotEmpty String rue, @NotEmpty String ville, @NotEmpty String codePostal,
			Utilisateur utilisateur) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@NotEmpty
	@Column(name = "numero", length = 30, nullable = false)
	private String numero;

	@NotEmpty
	@Column(name = "rue", length = 30, nullable = false)
	private String rue;

	@NotEmpty
	@Column(name = "ville", length = 30, nullable = false)
	private String ville;

	@NotEmpty
	@Column(name = "codePostal", length = 30, nullable = false)
	private String codePostal;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private Utilisateur utilisateur;

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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
