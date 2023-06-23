package com.doranco.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.doranco.entity.Categorie;
import com.doranco.entity.ResponseModel;
import com.doranco.service.CategorieMetier;

@Path("/categorie")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class CategorieController {
	
	private final static String CHARSET = ";charset=UTF-8";
	
	private final CategorieMetier _metier = new CategorieMetier();
	
	@GET
	@PermitAll
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response GetAllUtilisat() throws Exception {
		List<Categorie> list = _metier.getCategories();
		
		ResponseModel<List<Categorie>> resp = new ResponseModel<>(
				list,
				""
				);
		
		return Response.ok().entity(resp).build();
	}

}
