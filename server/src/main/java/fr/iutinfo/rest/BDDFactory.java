package fr.iutinfo.rest;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.inject.Singleton;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class BDDFactory {
    private static DBI dbi = null;
    final static Logger logger = LoggerFactory.getLogger(BDDFactory.class);

    public static DBI getDbi() {
        if(dbi == null) {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:" + System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "data.db");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            ds.setConfig(config);
            dbi = new DBI(ds);
            logger.debug("user.dir : " + System.getProperty("user.dir"));
            logger.debug("java.io.tmpdir : " + System.getProperty("java.io.tmpdir"));
        }
        return dbi;
    }

    public static boolean tableExist(String tableName) throws SQLException {
        DatabaseMetaData dbm = getDbi().open().getConnection().getMetaData();
        ResultSet tables = dbm.getTables(null, null, tableName, null);
        boolean exist = tables.next();
        tables.close();
        return exist;
    }
    
    public static void initializeBdd() {
    	
    	CorpDAO cDao = getDbi().open(CorpDAO.class);
    	UserDAO uDao = getDbi().open(UserDAO.class);
    	
       	uDao.dropTable();
    	cDao.dropTable();
 
    	
    	cDao.createCorpTable();
    	uDao.createUserTable();
    	
		/*cDao.insert("Auchan", "auchan.com");
		cDao.insert("Decathlon", "decathlon.com");		
		cDao.insert("Carrefour", "carrefour.net");
		cDao.insert("SportIn", "sportin.fr");
		
		User u0 = new User();
		u0.setLogin("fabien.h@decathlon.com");
		u0.setPass("azerty");
		u0.setNom("Haingue");
		u0.setPrenom("Fabien");
		//u0.setCorp(cDao.getByDomain(u0.g));
		uDao.insert(u0);
		
		User u1 = new User();
		u1.setLogin("toto.t@auchan.com");
		u1.setPass("azerty");
		u1.setNom("Tartampion");
		u1.setPrenom("Toto");
		uDao.insert(u1);*/
    }
}