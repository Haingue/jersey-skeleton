package fr.iutinfo.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/corp")
public class CorpResource {
    
    final static Logger logger = LoggerFactory.getLogger(TempoResource.class);
	
    @Context
    public UriInfo uriInfo;

    public CorpResource() {}
    
    @POST
    public Response createCorp(CorpDto dto) {
    	// Si le corp existe déjà, renvoyer 409
    	Corp corp = new Corp();
    	corp.initDto(dto);
    	
        if ( corps.containsKey(corp.getCno()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
        	corps.put(corp.getCno(), corp);

            // On renvoie 201 et l'instance de la ressource dans le Header HTTP 'Location'
            URI instanceURI = uriInfo.getAbsolutePathBuilder().path( String.valueOf(corp.getCno()) ).build();
            return Response.created(instanceURI).build();
        }
    	
    }
}
