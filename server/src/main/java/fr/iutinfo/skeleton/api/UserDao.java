package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

/**
 * Cette Classe permet de manipuler des utilisateur a partir de la base de
 * donnees, elle utilise JDBI pour communiquer avec la base SQLite.
 * 
 * @author equipe3
 *
 */
public interface UserDao {

	/**
	 * Permet de creer la table Users.
	 */
	@SqlUpdate("create table users (id integer primary key autoincrement," + " name varchar(100),"
			+ " surname varchar(100)," + " login varchar(100)," + " passwdHash varchar(64)," + " salt varchar(64),"
			+ " profilUrl varchar(1024)," + " search varchar(1024))")
	void createUserTable();

	/**
	 * Permet d'ajouter un utlilisateur a la BDD a partir d'une instance User.
	 * 
	 * @param user
	 * @return
	 */
	@SqlUpdate("insert into users (name,surname,login, passwdHash, salt, profilUrl, search) "
			+ "values (:name, :surname, :login, :passwdHash, :salt, :profilUrl, :search)")
	@GetGeneratedKeys
	int insert(@BindBean() User user);

	/**
	 * Permet de recuperer un utilisateur a partir de son nom.
	 * 
	 * @param name
	 * @return
	 */
	@SqlQuery("select * from users where name = :name")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findByName(@Bind("name") String name);

	/**
	 * Permet de recuperer un utilisateur a partir de son login.
	 * 
	 * @param login
	 * @return
	 */
	@SqlQuery("select * from users where login = :login")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findByLogin(@Bind("login") String login);

	/**
	 * Permet de rechercher un utilisateur a partir de son nom, elle renvoit une
	 * liste de User
	 * 
	 * @param name
	 * @return
	 */
	@SqlQuery("select * from users where search like :name")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> search(@Bind("name") String name);

	/**
	 * Permet de supprimer la table users.
	 */
	@SqlUpdate("drop table if exists users")
	void dropUserTable();

	/**
	 * Permet de supprimer un utilisateur a partir de son id.
	 * @param id
	 */
	@SqlUpdate("delete from users where id = :id")
	void delete(@Bind("id") int id);

	/**
	 * Renvoie la liste de touts les utilisateurs.
	 * @return
	 */
	@SqlQuery("select * from users order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> all();

	/**
	 * Permet de trouver un utilisateur a partir de son id.
	 * @param id
	 * @return
	 */
	@SqlQuery("select * from users where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findById(@Bind("id") int id);

	void close();
}
