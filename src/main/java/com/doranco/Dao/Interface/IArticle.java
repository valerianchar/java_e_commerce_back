package com.doranco.Dao.Interface;

import java.util.List;

import com.doranco.entity.Article;

public interface IArticle {
	
	List<Article> getArticles();
	int add(Article t) throws Exception;
	void update(Article t) throws Exception;
	void delete(int id) throws Exception;
	Article getById(int id) throws Exception;

}
