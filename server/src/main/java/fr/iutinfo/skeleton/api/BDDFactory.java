package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteDataSource;

import fr.iutinfo.events.EventDao;

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
    
    public static void initializeBDD() {
    	UserDao dao = getDbi().open(UserDao.class);
    	try {
    	if(!tableExist("users")) {
    		dao.createUserTable();
    		User user = new User(0,"admin");
    		user.setPassword("admin");
    		dao.insert(user);
    	}else {
    		dao.dropUserTable();
    		dao.createUserTable();
    		User user = new User(0,"admin");
    		user.setPassword("admin");
    		dao.insert(user);
    	}
    	}catch(SQLException e) {
    		
    	}
    }
}