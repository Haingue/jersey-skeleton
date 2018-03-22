package fr.iutinfo.rest;

import java.util.List;

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
	
	@SqlUpdate("insert into corporate (name, domain) values(:name,:domain)")
	public void insert(@Bind("name") String name, @Bind("domain") String domain);
	
	@SqlQuery("select * from corporate where cno = :id")
	public Corp getById(@Bind("id") int id);
	
	@SqlQuery("select * from corporate where domain = :domain")
	public Corp getByDomain(@Bind("domain") String domain);
	
	@SqlQuery("select * from corporate where name = :name")
	public Corp getByName(@Bind("name") String name);
	
	@SqlQuery("select * from corporate")
	public List<Corp> getAll();
	
	void close();
}
