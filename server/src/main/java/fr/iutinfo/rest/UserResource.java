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
import javax.ws.rs.core.MediaType;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	/*@Context
	public UriInfo uriInfo;
	
	public UserResource() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Path("auth")
	public User authUser(User user) {
		UserDAO dao = new UserDAO();
		User authUser = dao.checkUser(user);
		
		if(authUser == null) {
			throw new NotFoundException();
		}else {
			return authUser;
		}
		
	}
	
	 @POST
	 @Path("register")
	    public Response createUser(User user) {
	    	UserDAO dao = new UserDAO();
	    	// Si l'utilisateur existe déjà, renvoyer 409
	        if ( dao.getUserByLogin(user.getLogin()) == null ) {
	            return Response.status(Response.Status.CONFLICT).build();
	        }
	        if(dao.addUser(user) == null) {
	        	return Response.status(Response.Status.BAD_REQUEST).build();
	        }else {
	        	return Response.ok().build();
	        }
	    
	    }
*/
}
