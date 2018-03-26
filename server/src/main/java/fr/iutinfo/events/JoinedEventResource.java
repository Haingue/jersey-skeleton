package fr.iutinfo.events;

import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.POST;

import fr.iutinfo.skeleton.api.BDDFactory;

public class JoinedEventResource {
	
	private static JoinedEventDao dao = BDDFactory.getDbi().open(JoinedEventDao.class);
	
	public JoinedEventResource() throws SQLException {
		if(!BDDFactory.tableExist("joined_events")) {
			dao.createTable();
		}
	}
	
	@POST
	@RolesAllowed("user")
	public JoinedEventDto joinEvent(JoinedEventDto dto) {
		// TODO
		return null;
	}
	

}
