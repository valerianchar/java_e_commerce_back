package com.doranco.service;

import java.util.ArrayList;
import java.util.List;

import com.doranco.Dao.ArticleDAO;
import com.doranco.Dao.CategorieDAO;
import com.doranco.ModelRequest.ArticleModelRequest;
import com.doranco.entity.Article;
import com.doranco.entity.Categorie;
import com.doranco.entity.Commentaire;
import com.doranco.dtoService.DTOSercice;

public class ArticleMetier {

	private final ArticleDAO articleDAO = new ArticleDAO();
	private final CategorieDAO categorieDAO = new CategorieDAO();
	
	public List<Article> getAllArticle() {
		List<Article> list = null;
		try {
			list = articleDAO.getArticles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int addArticle(ArticleModelRequest articleRequest) {
		Categorie c = null;
		Article a = null;
		int id = 0;
		try {
			if(articleRequest.getCategorie() >= 0) {
				c = categorieDAO.getById(articleRequest.getCategorie());
			}
			if(articleRequest != null && c != null) {
				a = DTOSercice.convertToArticleWhitCategorie(articleRequest, c);
				id = articleDAO.add(a);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public Article GetListCommentByIdArticle(int id) {
		Article a = null;
		try {
			a = articleDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		
		
	}

	public void deleteAricle(int id) {
		try {
			articleDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
