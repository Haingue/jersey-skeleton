package fr.iutinfo.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("auth")
public class UserAuth {
	
	@Context
	public UriInfo uriInfo;
	
	@POST
	
	public Response authUser(Utilisateur user) {
		
	}

}
