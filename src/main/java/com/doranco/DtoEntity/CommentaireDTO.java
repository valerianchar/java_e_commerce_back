package com.doranco.DtoEntity;

public class CommentaireDTO {

	
	public CommentaireDTO() {
	}

	public CommentaireDTO( String texte,  int note, ArticleDTO article, UtilisateurDTO utilisateur) {
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	private int id;
	
	private String texte;
	
	private int note;
	
	private ArticleDTO article;
	
	private UtilisateurDTO utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

	public UtilisateurDTO getUtilsateur() {
		return utilisateur;
	}

	public void setUtilsateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
