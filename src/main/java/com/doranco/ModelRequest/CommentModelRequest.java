package com.doranco.ModelRequest;

public class CommentModelRequest {
	public CommentModelRequest() {
	}

	public CommentModelRequest( String texte,  int note, int article, int utilisateur) {
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	private int id;
	
	private String texte;
	
	private int note;
	
	private int article;
	
	private int utilisateur;

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

	public int getArticle() {
		return article;
	}

	public void setArticle(int article) {
		this.article = article;
	}

	public int getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}
}
