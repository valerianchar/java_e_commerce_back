package com.doranco.filter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_SCHEME = "Bearer";

	private Response getAccessDeniedResponse() {
		return Response.status(Response.Status.UNAUTHORIZED)
				.entity("Vous n'avez pas le droit d'acc�s � cette ressource").build();
	}

	private Response getAccessForbiddenResponse() {
		return Response.status(Response.Status.FORBIDDEN).entity("Accès bloqué à tous les utilisateurs !!").build();
	}

	@Override
	public void filter(ContainerRequestContext requestContext) {

		Method method = resourceInfo.getResourceMethod();

		int nbAnnotations = 0;

		if (method.isAnnotationPresent(PermitAll.class))
			nbAnnotations++;

		if (method.isAnnotationPresent(DenyAll.class))
			nbAnnotations++;

		if (method.isAnnotationPresent(RolesAllowed.class))
			nbAnnotations++;

		if (nbAnnotations > 1) {
			throw new IllegalStateException(
					"La méthode ne peut avoir qu'une seule annotation des trois annotations suivantes : "
							+ "@PermitAll, @DenyAll, @RolesAllowed");
		}

		if (nbAnnotations == 0) {
			throw new IllegalStateException(
					"La méthode doit avoir une annotation parmi l'une des trois annotations suivantes : "
							+ "@PermitAll, @DenyAll, @RolesAllowed");
		}

		if (method.isAnnotationPresent(PermitAll.class)) {
			return;
		}
		if (method.isAnnotationPresent(DenyAll.class)) {
			requestContext.abortWith(getAccessForbiddenResponse());
			return;
		}

		// Get request headers
		final MultivaluedMap<String, String> headers = requestContext.getHeaders();

		// Fetch authorization header
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

		// If no authorization information present; block access
		if (authorization == null || authorization.isEmpty()) {
			requestContext.abortWith(getAccessDeniedResponse());
			return;
		}

		final String profilEncoded = authorization.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");

		String profil = new String(Base64.getDecoder().decode(profilEncoded.getBytes()));

//		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
//		final String username;
//		final String password;
//		try {
//			username = tokenizer.nextToken();
//			password = tokenizer.nextToken();
//		} catch (NoSuchElementException ex) {
//			Response resp = Response.status(Response.Status.BAD_REQUEST)
//					.entity("Le format des login/password est incorrect").build();
//			requestContext.abortWith(resp);
//			return;
//		}

		System.out.println("username : " + profil);
//		System.out.println("password : " + password);

		RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
		Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

		if (!isProfilAllowed(profil, rolesSet)) {
			requestContext.abortWith(getAccessDeniedResponse());
			return;
		}
	}
	
	private boolean isProfilAllowed(final String profil, final Set<String> rolesSet) {

		switch (profil) {
			case "Client":
				if (rolesSet.contains(profil)) {
					return true;
				}
				break;
			case "Magasinier":
				if (rolesSet.contains(profil)) {
					return true;
				}
				break;
			case "Admin":
				if (rolesSet.contains(profil)) {
					return true;
				}
				break;
			default:
				break;
		}
		return false;
	}
	
}
