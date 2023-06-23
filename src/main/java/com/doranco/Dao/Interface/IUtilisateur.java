package com.doranco.Dao.Interface;

import java.util.List;

import com.doranco.DtoEntity.UtilisateurDTO;
import com.doranco.entity.Utilisateur;

public interface IUtilisateur {

	List<Utilisateur> getAll() throws Exception;
	
	UtilisateurDTO getByEmail(String email) throws Exception;
	
}
