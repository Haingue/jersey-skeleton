package fr.iutinfo.rest;

import javax.ws.rs.Path;
import javax.ws.rs.POST;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.core.Context;

import java.net.URI;

import java.util.*;

@Path("register")
public class UserCreate {
	
    @Context
    public UriInfo uriInfo;
	
    public UserCreate() {
    }
 
    @POST
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
    
}
