package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorpDAO {

	public Corp getCorpById(int id) {
		Corp corp = null;
		Connection con = new BDDFactory().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM corp WHERE cno=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String domain = rs.getString("domain");
				corp = new Corp(id, name, domain);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		}

		return corp;
	}

}
