package fr.iutinfo.events;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface EventDao {

	@SqlUpdate("create table event (eno integer primary key autoincrement,"
			+ " label varchar(1000)"
			+ " date timestamp,"
			+ " participants_needed integer,"
			+ " price integer)")
    void createUserTable();
	
	@SqlUpdate("drop table if exists event")
    void dropUserTable();
	
	@SqlUpdate("insert into event (label,date,participants_needed,price) "
			+ "values (:label,:date,:participants_needed,:price")
	@GetGeneratedKeys
	int insert(@BindBean Event event);
	
	@SqlQuery("select * from event")
	List<Event> getAll();
}
