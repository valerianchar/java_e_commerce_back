package com.doranco.service;

import com.doranco.Dao.CommentaireDAO;
import com.doranco.ModelRequest.CommentModelRequest;
import com.doranco.dtoService.DTOSercice;
import com.doranco.entity.Article;
import com.doranco.entity.Categorie;
import com.doranco.entity.Commentaire;
import com.doranco.entity.Utilisateur;

import java.util.List;

import com.doranco.Dao.ArticleDAO;
import com.doranco.Dao.UtilisateurDAO;

public class CommentaireMetier {
	
	private final CommentaireDAO commentDao = new CommentaireDAO();
	private final ArticleDAO articleDao = new ArticleDAO();

	private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
	
	public List<Commentaire> getAllUtilisat() throws Exception{
		
		return commentDao.getAll();
		
	}

	public List<Utilisateur> GetListCommentByIdArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addComment(CommentModelRequest commentRequest) {
		Utilisateur u = null;
		Article a = null;
		Commentaire c = null;
		try {
			if(commentRequest.getArticle() > 0) {
				a = articleDao.getById(commentRequest.getArticle());
			}
			if(commentRequest.getUtilisateur() > 0) {
				u = utilisateurDAO.getById(commentRequest.getUtilisateur());
			}
			if(commentRequest != null || a != null || u != null) {
				c = DTOSercice.convertForAddComment(commentRequest, a, u);
				commentDao.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c.getId();
	}

}
