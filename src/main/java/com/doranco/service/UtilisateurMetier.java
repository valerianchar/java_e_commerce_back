package com.doranco.service;

import java.util.List;

import com.doranco.Dao.UtilisateurDAO;
import com.doranco.DtoEntity.UtilisateurDTO;
import com.doranco.entity.Utilisateur;

public class UtilisateurMetier {

	private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
	
	
	public List<Utilisateur> getAllUtilisat() throws Exception{
		
		return utilisateurDAO.getAll();
		
	}
	
	public void addUtilisat(Utilisateur u) throws Exception{
		try {
			if(u != null) {
				utilisateurDAO.add(u);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

	public UtilisateurDTO Authentification(String email, String password) {
		UtilisateurDTO uDTO = null;
		try {
			if((email != null || email != "") && (password != null || password != "")) {
				uDTO = utilisateurDAO.getByEmail(email);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		String UDtoEmail = uDTO.getEmail();
		String UDtoPassword = uDTO.getPassword();
		if(uDTO != null && UDtoEmail.equals(email) && UDtoPassword.equals(password)) {
			uDTO.setPassword("");
			return uDTO;
		}
		return null;
		
	}

	public void LogOut(int id) {
		
		
		
	}
	
	

	
	
}
