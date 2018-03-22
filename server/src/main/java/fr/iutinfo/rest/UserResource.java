package fr.iutinfo.rest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Context
	public UriInfo uriInfo;

	public UserResource() {
	}

	@POST
	@Path("auth")
	public UserDto authUser(UserDto userDto) {
		User user = new User();
		user.initFromDto(userDto);
		UserDAO dao = BDDFactory.getDbi().open(UserDAO.class);
		User authUser = dao.checkUser(user.getLogin(), user.getPass());

		if (authUser == null) {
			throw new NotFoundException();
		} else {
			return authUser.convertToDto();
		}

	}

	@POST
	@Path("register")
	public UserDto createUser(UserDto userDto) {
		User user = new User();
		user.initFromDto(userDto);
		UserDAO dao = BDDFactory.getDbi().open(UserDAO.class);
		// Si l'utilisateur existe déjà, renvoyer 409
		if (dao.findByLogin(user.getLogin()) != null) {
			throw new ConflictException(null); 
		}
		Corp corp;
		if ((corp = validLogin(user.getLogin())) != null) {
			throw new BadRequestException();
		} else {
			user.setCorp(corp);
			dao.insert(user);
			return user.convertToDto();
		}

	}
	
	private Corp validLogin(String login) {
		String[] s = login.split("@");
		if(s.length > 2)
			return null;
		String domain = s[1];
		CorpDAO dao = BDDFactory.getDbi().open(CorpDAO.class);
		
		Corp corp = dao.getByDomain(domain);
		
		return corp;
	}

}
