package fr.iutinfo.rest;

import javax.ws.rs.Path;
import javax.ws.rs.POST;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.core.Context;

import java.net.URI;

import java.util.*;

@Path("create")
public class UserCreate {

    private static Map<Integer, User> users = new HashMap<>();
	
    @Context
    public UriInfo uriInfo;
	
    public UserCreate() {
    }
 
    @POST
    public Response createUser(User user) {
    
    	// Si l'utilisateur existe déjà, renvoyer 409
        if ( users.containsKey(user.getUno()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
        	users.put(user.getUno(), user);

            // On renvoie 201 et l'instance de la ressource dans le Header HTTP 'Location'
            URI instanceURI = uriInfo.getAbsolutePathBuilder().path( String.valueOf(user.getUno()) ).build();
            return Response.created(instanceURI).build();
        }
    
    }
    
}
