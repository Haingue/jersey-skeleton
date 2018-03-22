package fr.iutinfo.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.BadRequestException;
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
}
