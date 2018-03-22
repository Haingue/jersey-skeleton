package fr.iutinfo.rest;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

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
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Corp getById(@Bind("id") int id);
	

	@SqlQuery("select * from corporate where domain = :domain")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Corp getByDomain(@Bind("domain") String domain);
	
	@SqlQuery("select * from corporate where name = :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Corp getByName(@Bind("name") String name);
	
	@SqlQuery("select * from corporate")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public List<Corp> getAll();
	
	void close();
}
