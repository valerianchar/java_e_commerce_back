package com.doranco.service;

import java.util.List;

import com.doranco.Dao.CategorieDAO;
import com.doranco.entity.Categorie;

public class CategorieMetier {

	private final CategorieDAO categorieDAO = new CategorieDAO();
	
	public List<Categorie> getCategories() throws Exception {
		return categorieDAO.getAll();
	}

}
