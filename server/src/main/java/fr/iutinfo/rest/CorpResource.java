package fr.iutinfo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/corp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CorpResource {
    
    final static Logger logger = LoggerFactory.getLogger(TempoResource.class);
	
    @Context
    public UriInfo uriInfo;

    public CorpResource() {}
    
    @POST
    public CorpDto createCorp(CorpDto dto) {
    	Corp corp = new Corp();
    	corp.initDto(dto);
    	
    	CorpDAO dao = BDDFactory.getDbi().open(CorpDAO.class);
		// Si l'entreprise existe déjà, renvoyer 409
    	
		if (dao.getByName(corp.getNom()) != null) {
			throw new ConflictException(null); 
		} else {
			dao.insert(corp.getNom(),corp.getDomain());
			return corp.convertToDto();
		}
    	
    }
    
    @GET
    @Path("{name}")
    public CorpDto getCorpByName(@PathParam("name") String name) {
    	CorpDAO dao = BDDFactory.getDbi().open(CorpDAO.class);
    	
    	Corp corp = dao.getByName(name);
    	
    	if(corp == null) {
    		throw new NotFoundException();
    	}else {
    		return corp.convertToDto();
    	}
    }

}
