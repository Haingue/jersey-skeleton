package fr.iutinfo.events;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

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
	
	@SqlUpdate("delete from event where eno = :eno")
	void delete(@Bind("eno") int eno);
	
	@SqlUpdate("update event "
			+ "set label = :label date = :date participants_needed = :participants_needed price = :price"
			+ "where eno = :eno")
	void update(@BindBean Event event);
	
	@SqlQuery("select * from event")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Event> getAll();
	
	@SqlQuery("select * from event where eno = :eno")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Event getById(@Bind("eno") int eno);
}
