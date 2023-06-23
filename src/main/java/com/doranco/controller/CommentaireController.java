package com.doranco.controller;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doranco.ModelRequest.CommentModelRequest;
import com.doranco.service.CommentaireMetier;

@Path("/comment")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class CommentaireController {

	private final static String CHARSET = ";charset=UTF-8";
	
	private final CommentaireMetier _metier = new CommentaireMetier();;
	
	@POST
	@Path("/add")
	@PermitAll
//	@RolesAllowed("ADMIN")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public int addComment(CommentModelRequest commentRequest) throws Exception {
		System.out.println(commentRequest);
		int id = _metier.addComment(commentRequest);
		
		return id;
	}
}
