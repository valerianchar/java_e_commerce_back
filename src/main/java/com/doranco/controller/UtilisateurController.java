package com.doranco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.doranco.DtoEntity.UtilisateurDTO;
import com.doranco.dtoService.DTOSercice;
import com.doranco.entity.ResponseModel;
import com.doranco.entity.UserPassword;
import com.doranco.entity.Utilisateur;
import com.doranco.service.UtilisateurMetier;


@Path("/utilisat")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class UtilisateurController {

	private final static String CHARSET = ";charset=UTF-8";
	
	private final UtilisateurMetier _metier = new UtilisateurMetier();
	
	@GET
	@PermitAll
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response GetAllUtilisat() throws Exception {
		List<Utilisateur> list = _metier.getAllUtilisat();
		List<UtilisateurDTO> listDTO = new ArrayList<UtilisateurDTO>();
		for (Utilisateur utilisat : list) {
			UtilisateurDTO dto = DTOSercice.convertToUtilisateurDTO(utilisat);
			listDTO.add(dto);
		}
		
		ResponseModel<List<UtilisateurDTO>> resp = new ResponseModel<>(
				listDTO,
				""
				);
		return Response.ok().entity(resp).build();
	}
	
	@PermitAll
	@POST
	@Path("/add")
//	@RolesAllowed("ADMIN")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response addUtilisat(UtilisateurDTO dto) throws Exception {
		
		Utilisateur utilisat = DTOSercice.convertToUtilisateur(dto);
		
		_metier.addUtilisat(utilisat);
		
		return Response.ok().build();
	}
	
	@PermitAll
	@POST
	@Path("/auth")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response Authentification(UserPassword userPassword) throws Exception {
		
		UtilisateurDTO utilisat = _metier.Authentification(userPassword.getEmail(), userPassword.getPassword());
		ResponseModel<UtilisateurDTO> resp = new ResponseModel<>(
				utilisat,
				""
				);
		return Response.ok().entity(resp).build();
	}
	
}
