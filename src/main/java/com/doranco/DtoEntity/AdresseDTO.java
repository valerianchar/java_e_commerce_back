package com.doranco.DtoEntity;

public class AdresseDTO {


	public AdresseDTO() {
	}

	public AdresseDTO(String numero, String rue, String ville, String codePostal,
			UtilisateurDTO utilisateur) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
	}
	private int id;
	
	private String numero;
	
	private String rue;
	
	private String ville;
	
	private String codePostal;
	
	private UtilisateurDTO utilisateur;

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

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

	
}
