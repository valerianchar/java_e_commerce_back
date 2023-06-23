package com.doranco.dtoService;

import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.doranco.Dao.ParamsDAO;
import com.doranco.DtoEntity.CartePaiementDTO;
import com.doranco.DtoEntity.UtilisateurDTO;
import com.doranco.ModelRequest.ArticleModelRequest;
import com.doranco.ModelRequest.CommentModelRequest;
import com.doranco.chiffrage.CryptageAlgo;
import com.doranco.chiffrage.CryptageEnum;
import com.doranco.entity.Article;
import com.doranco.entity.CartePaiement;
import com.doranco.entity.Categorie;
import com.doranco.entity.Commentaire;
import com.doranco.entity.Utilisateur;

public final class DTOSercice {
	
	
	public static Utilisateur convertToUtilisateur(UtilisateurDTO dto) throws Exception {
		
		ParamsDAO params = new ParamsDAO();
		
		
		Utilisateur utilisat = new Utilisateur();
		utilisat.setNom(dto.getNom());
		utilisat.setPrenom(dto.getPrenom());
		utilisat.setDateDeNaissance(setDateDeNaissance(dto.getDateDeNaissance()));
		utilisat.setActif(dto.isActif());
		utilisat.setProfil(dto.getProfil());
		utilisat.setEmail(dto.getEmail());
		utilisat.setTelephone(dto.getTelephone());
		Key key = params.getCleDeChiffrageUtilisat();
		utilisat.setPassword(CryptageAlgo.encrypt(dto.getPassword(),key ,CryptageEnum.AES.getAlgorithme()));


		return utilisat;
	}
	

    public static Date setDateDeNaissance(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(date);
    }

    public static String getDateDeNaissance(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
	
		public static UtilisateurDTO convertToUtilisateurDTO(Utilisateur utilisat) throws Exception {
		
		ParamsDAO params = new ParamsDAO();
		
		
		UtilisateurDTO utilisatDTO = new UtilisateurDTO();
		utilisatDTO.setId(utilisat.getId());
		utilisatDTO.setNom(utilisat.getNom());
		utilisatDTO.setPrenom(utilisat.getPrenom());
		utilisatDTO.setDateDeNaissance(getDateDeNaissance(utilisat.getDateDeNaissance()));
		utilisatDTO.setActif(utilisat.isActif());
		utilisatDTO.setProfil(utilisat.getProfil());
		utilisatDTO.setEmail(utilisat.getEmail());
		utilisatDTO.setTelephone(utilisat.getTelephone());
		utilisatDTO.setPassword(CryptageAlgo.decrypt(utilisat.getPassword(), params.getCleDeChiffrageUtilisat(),CryptageEnum.AES.getAlgorithme()));


		return utilisatDTO;
	}


	public static CartePaiement convertToCartePaiement(CartePaiementDTO dto) throws Exception {

		ParamsDAO params = new ParamsDAO();
		
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setChryptogramme(CryptageAlgo.encrypt(dto.getChryptogramme(), params.getCleDeChiffrageCB(),CryptageEnum.AES.getAlgorithme()));
		cartePaiement.setNumero(CryptageAlgo.encrypt(dto.getNumero(), params.getCleDeChiffrageCB(),CryptageEnum.AES.getAlgorithme()));
		
		
		return cartePaiement;
	}


	public static Article convertToArticleWhitCategorie(ArticleModelRequest articleRequest, Categorie c) {
		
		Article a = new Article();
		
		a.setNom(articleRequest.getNom());
		a.setDescription(articleRequest.getDescription());
		a.setPrix(articleRequest.getPrix());
		a.setRemise(articleRequest.getRemise());
		a.setStock(articleRequest.getStock());
		a.setVendable(articleRequest.isVendable());
		a.setVideo(articleRequest.getVideo());
		a.setPhoto(articleRequest.getPhoto());
		a.setCategorie(c);
		
		return a;
		
	}


	public static Commentaire convertForAddComment(CommentModelRequest commentRequest, Article a, Utilisateur u) {

		Commentaire c = new Commentaire();
		c.setTexte(commentRequest.getTexte());
		c.setNote(commentRequest.getNote());
		c.setArticle(a);
		c.setUtilsateur(u);
		
		
		return c;
	}

	
	
	
	
	
	
}
