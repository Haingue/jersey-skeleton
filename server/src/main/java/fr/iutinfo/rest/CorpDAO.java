package fr.iutinfo.rest;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface CorpDAO {
	
	@SqlQuery("select * from corporate where cno = :id")
	public Corp getById(@Bind("id") int id);
	

	@SqlQuery("select * from corporate where domain = :domain")
	public Corp getByDomain(@Bind("domain") String domain);
	

}
