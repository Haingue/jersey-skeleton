package fr.iutinfo.events;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

/**
 * Cette Classe permet de manipuler des Event a partir de la base de donnees, elle
 * utilise JDBI pour communiquer avec la base SQLite.
 * 
 * @author equipe3
 *
 */
public interface EventDao {

	/**
	 * Permet de creer la table Event.
	 */
	@SqlUpdate("create table event (eno integer primary key autoincrement," + " label varchar(1000),"
			+ " dateEvent varchar(20)," + " participantsNeeded integer," + " price integer)")
	void createEventTable();

	/**
	 * Permet de suprimer la table Event.
	 */
	@SqlUpdate("drop table if exists event")
	void dropEventTable();

	/**
	 * Permet d'ajouter des Event à la tabler Event
	 * @param event
	 * @return
	 */
	@SqlUpdate("insert into event (label,dateEvent,participantsNeeded,price) "
			+ "values (:label,:dateEvent,:participantsNeeded,:price)")
	@GetGeneratedKeys
	int insert(@BindBean Event event);

	/**
	 * Permet de supprimer un Event a partir d'un numero d'Event
	 * @param eno
	 */
	@SqlUpdate("delete from event where eno = :eno")
	void delete(@Bind("eno") int eno);

	/**
	 * Permet de modifier un Event present dans la Table par l'Event en parametre.
	 * @param event
	 */
	@SqlUpdate("update event "
			+ "set label = :label dateEvent = :dateEvent participantsNeeded = :participantsNeeded price = :price"
			+ "where eno = :eno")
	void update(@BindBean Event event);

	/**
	 * Permet de recuperer la liste de tout le Event de la table Event
	 * @return
	 */
	@SqlQuery("select * from event")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Event> getAll();

	/**
	 * Permet de recuperer un Event a partir de son id.
	 * @param eno
	 * @return
	 */
	@SqlQuery("select * from event where eno = :eno")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Event getById(@Bind("eno") int eno);
}
