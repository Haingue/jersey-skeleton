package fr.iutinfo.rest;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CorpDAO {
	
	@SqlUpdate("create table corporate("
			+ "cno integer primary key autoincrement,"
			+ "name varchar(50) not null,"
			+ "domain varchar(50) not null,"
			+ "constraint uniq_corporate_name unique (name),"
			+ "constraint uniq_domain unique (domain))")
	public void createCorpTable();
	
	@SqlUpdate("DROP TABLE IF EXISTS corporate")
	void dropTable();
	
	@SqlQuery("select * from corporate where cno = :id")
	public Corp getById(@Bind("id") int id);
	

	@SqlQuery("select * from corporate where domain = :domain")
	public Corp getByDomain(@Bind("domain") String domain);
	
	@SqlQuery("select * from corporate where name = :name")
	public Corp getByName(@Bind("name") String name);
	
	void close();
}
