package com.doranco.Dao.Interface;

import java.util.List;

import com.doranco.entity.Commentaire;

public interface IComment {
	List<Commentaire> getAll() throws Exception;
}
