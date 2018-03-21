package fr.iutinfo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("auth")
public class UserAuth {
	
	@Context
	public UriInfo uriInfo;
	
	public UserAuth() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public User authUser(User user) {
		UserDAO dao = new UserDAO();
		User authUser = dao.checkUser(user);
		
		if(authUser == null) {
			throw new NotFoundException();
		}else {
			return authUser;
		}
		
	}

}
