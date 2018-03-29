package fr.iutinfo.events;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Classe qui defini comment le serveur peut manipuler des evenements.
 * 
 * @author equipe3
 *
 */

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {
	private static EventDao dao = getDbi().open(EventDao.class);

	public EventResource() throws SQLException {
		if (!tableExist("event")) {
			dao.createEventTable();

		}
	}

	/**
	 * Methode permettant de creer un evenement dans la BDD
	 * 
	 * @param dto
	 * @return
	 */
	@POST
	public EventDto createEvent(EventDto dto) {
		// on recupere un dto donc on peut initialiser un Event avec...
		Event event = new Event();
		event.initFromDto(dto);
		int id = dao.insert(event);
		dto.setId(id);
		return dto;
	}

	/**
	 * Permet de voir l'ensemble des evenements presant dans la BDD
	 * @return
	 */
	@GET
	public List<EventDto> getAll() {
		List<Event> events = dao.getAll();
		return events.stream().map(Event::convertToDto).collect(Collectors.toList());
	}

	/**
	 * Permet de recuperer un evenement a partir de son id
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	public EventDto getEventById(@PathParam("id") int id) {
		Event event = dao.getById(id);
		if (event == null)
			throw new WebApplicationException(404);
		return event.convertToDto();
	}

	/**
	 * Permet de supprimer un evenement a partir de son id
	 * 
	 * @param id
	 */
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.delete(id);
	}

	/**
	 * Permet de modifiers un evenement a partir de son id
	 * 
	 * @param id
	 * @param dto
	 */
	@PUT
	@Path("/{id}")
	public void update(@PathParam("id") int id, EventDto dto) {
		Event event = dao.getById(id);
		if (event == null)
			throw new WebApplicationException(404);
		event.initFromDto(dto);
		dao.update(event);
	}

}
