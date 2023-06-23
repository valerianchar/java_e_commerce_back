package com.doranco.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.doranco.ModelRequest.ArticleModelRequest;
import com.doranco.entity.Article;
import com.doranco.entity.ResponseModel;
import com.doranco.service.ArticleMetier;


@Path("/article")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class ArticleController {
	
	private final static String CHARSET = ";charset=UTF-8";
	
	private final ArticleMetier _metier = new ArticleMetier();
	
	@GET
	@PermitAll
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response GetAllArticle() throws Exception {
		List<Article> list = _metier.getAllArticle();
		
		ResponseModel<List<Article>> resp = new ResponseModel<>(
				list,
				""
				);
		
		return Response.ok().entity(resp).build();
	}
	
	@POST
	@Path("/add")
	@PermitAll
//	@RolesAllowed("ADMIN")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response addArticle(ArticleModelRequest article) throws Exception {
		
		int id = _metier.addArticle(article);
		
		return Response.ok().entity(id).build();
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response DeleteArticle(@PathParam("id") int id) {
		
		_metier.deleteAricle(id);
		
		return Response.ok().build();
	}
	
	
	
	@GET
	@PermitAll
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response GetAllArticle(@PathParam("id")int id) throws Exception {
		Article a = _metier.GetListCommentByIdArticle(id);
		
		ResponseModel<Article> resp = new ResponseModel<>(
				a,
				""
				);
		
		return Response.ok().entity(resp).build();
	}
}
