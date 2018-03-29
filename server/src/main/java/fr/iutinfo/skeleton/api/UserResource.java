package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

/**
 * Classe qui defini comment le serveur doit manipuler des User.
 * @author haingue
 *
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static UserDao dao = getDbi().open(UserDao.class);

    public UserResource() throws SQLException {
        if (!tableExist("users")) {
            logger.debug("Crate table users");
            dao.createUserTable();
            dao.insert(new User(0, "Margaret Thatcher"));
        }
    }

    @POST
    public UserDto createUser(UserDto dto) {
        User user = new User();
        user.initFromDto(dto);
        user.resetPasswordHash();
        int id = dao.insert(user);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{id}")
    public UserDto getUser(@PathParam("id") int id) {
        User user = dao.findById(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }
    
    @GET
    @Path("/login/{login}")
    public UserDto getUserByLogin(@PathParam("login") String login) {
        User user = dao.findByLogin(login);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }

    @GET
    @RolesAllowed("user")
    public List<UserDto> getAllUsers(@QueryParam("q") String query) {
        List<User> users;
        if (query == null) {
            users = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            users = dao.search("%" + query + "%");
        }
        return users.stream().map(User::convertToDto).collect(Collectors.toList());
    }
    
    @GET
    @Path("/search/{name}")
    public List<UserDto> findUsersByName(@PathParam("name") String name){
    	List<User> users;
    	users = dao.search("%" + name + "%");
    	return users.stream().map(User::convertToDto).collect(Collectors.toList());
    }
    


    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }

}
