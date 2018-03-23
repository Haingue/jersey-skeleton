package fr.iutinfo.rest;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDAO {
	/*
	 * @SqlUpdate("CREATE TABLE users\n" + "(\n" + "	uno SERIAL PRIMARY KEY,\n" +
	 * "	login VARCHAR(100) NOT NULL,\n" + "	password VARCHAR(50) NOT NULL,\n" +
	 * "	nom VARCHAR(50) NOT NULL,\n" + "	prenom VARCHAR(50) NOT NULL,\n" +
	 * "	fonction VARCHAR(100),\n" + "	cno INT NOT NULL,\n" + "\n" +
	 * "	CONSTRAINT fk_cno FOREIGN KEY (cno)\n" +
	 * "		REFERENCES corporate(cno),\n" + "\n" +
	 * "	CONSTRAINT uniq_login UNIQUE (login)\n" + ")") void createUserTable();
	 * 
	 * @SqlUpdate("drop table if exists users") void dropUserTable();
	 */

	@SqlUpdate("create table users (" + "uno integer primary key autoincrement,"
			+ " login varchar(200), password varchar(60)," + " nom varchar(100), prenom varchar(100),"
			+ "fonction varchar(500),"+" cno integer,"
			+ " CONSTRAINT fk_cno FOREIGN KEY (cno)" + "REFERENCES corporate(cno) )")
	void createUserTable();
	
	@SqlUpdate("DROP TABLE IF EXISTS users")
	void dropTable();

	@SqlUpdate("insert into users (login, password, nom, prenom, fonction, cno) values (:login, :pass, :nom, :prenom, :fonction, :cno)")
	@GetGeneratedKeys
	int insert(@BindBean() User user);

	@SqlQuery("select * from users where login = :login")
	@RegisterMapper(User.UserMapper.class)
	User findByLogin(@Bind("login") String login);

	@SqlQuery("select * from users where login = :login and password = :password")
	@RegisterMapper(User.UserMapper.class)
	User checkUser(@Bind("login") String login, @Bind("password") String password);

	@SqlQuery("select * from users order by uno")
	@RegisterMapper(User.UserMapper.class)
	List<User> all();

	@SqlQuery("select * from users where uno = :uno")
	@RegisterMapper(User.UserMapper.class)
	User findById(@Bind("uno") int uno);

	void close();
}
