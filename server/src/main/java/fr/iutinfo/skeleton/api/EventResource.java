package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {
    private static EventDao dao = getDbi().open(EventDao.class);
    
    public EventResource() throws SQLException {
        if (!tableExist("event")) {
            dao.createUserTable();
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            dao.insert(new Event(0, "Football au complex Lafayette", timestamp,10,5));
        }
    }
    
    @POST
    public EventDto createEvent(EventDto dto) {
        Event event = new Event();
        event.initFromDto(dto);
        int id = dao.insert(event);
        dto.setId(id);
        return dto;
    }
    
    @GET
    public List<EventDto> getAll(){
    	List<Event> events = dao.getAll();
    	return events.stream().map(Event::convertToDto).collect(Collectors.toList());
    }

}
