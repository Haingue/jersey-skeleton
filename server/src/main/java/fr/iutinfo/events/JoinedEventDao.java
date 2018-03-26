package fr.iutinfo.events;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import fr.iutinfo.skeleton.api.User;

public interface JoinedEventDao {
	
	@SqlUpdate("create table joined_events ("
			+ " user_id integer,"
			+ " event_id integer,"
			+ " constraint pk_joined_events primary key (user_id,event_id),"
			+ " constraint fk_user_id foreign key user_id references (users.id),"
			+ " constraint fk_event_id foreign key event_id references (event.eno)")
	void createTable();
	
	@SqlUpdate("drop table joined_events if exists")
	void dropTable();
	
	@SqlUpdate("insert into joined_events values(:user_id,:event_id)")
	int insert(@BindBean JoinedEvent event);
	
	@SqlQuery("select * from joined_events where user_id = :id")
	List<JoinedEvent> getUserEvents(@BindBean User user);
	
	@SqlQuery("select * from joined_events where event_id = :eno")
	List<JoinedEvent> getUserListFromEvent(@BindBean Event event);
	
	@SqlQuery("select * from joined_events where event_id = :eno and user_id = :id")
	JoinedEvent getJoinedEventById(@Bind("eno") int eno, @Bind("id") int id);

}
