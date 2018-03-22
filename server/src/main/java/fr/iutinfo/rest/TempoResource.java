package fr.iutinfo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDTO2;

@Path("/tempo")
public class TempoResource {

    final static Logger logger = LoggerFactory.getLogger(TempoResource.class);
	
	@GET
	@Path("/user")
	public UserDTO2 secureWhoAmI(@Context SecurityContext context) {
		User user = new User(15, "toto@auchan.com", "titi", "Tartanpion", "toto", "cadre",
				new Corp(18, "Auchan", "auchan.com"));
		logger.debug(user.toString());
		return user.convertToDto();
	}

}
