package fr.iutinfo.rest;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import fr.ulille.iut.Pizza;

import javax.ws.rs.core.Context;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.*;
import java.io.*;

@Path("create")
public class UserCreate {

    private static Map<String, Utilisateur> users = new HashMap<>();
	
    @Context
    public UriInfo uriInfo;
	
    public UserCreate() {
    }
 
    @POST
    public Response createUser(Utilisateur user) {
    
    	// Si l'utilisateur existe déjà, renvoyer 409
        if ( users.containsKey(users.getUno()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
        	users.put(user.getUno(), user);

            // On renvoie 201 et l'instance de la ressource dans le Header HTTP 'Location'
            URI instanceURI = uriInfo.getAbsolutePathBuilder().path(user.getUno()).build();
            return Response.created(instanceURI).build();
        }
    
    }
    
}
