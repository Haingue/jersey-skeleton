package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
	
	private Connection con;
	
	public UtilisateurDAO() {
		con = new BDDFactory().getConnection();
	}
	
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		//ResultSet rs = sql_Query("Select * from Utilisateur where role = '"+"' ", con);
		/*try {
			while (rs.next()) {
				int pno = rs.getInt("pno");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String addr = rs.getString("addresse");
				String mdp = rs.getString("mdp");
				list.add(new Utilisateur());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}*/
		return list;
	}
	
	public User checkUser(User user) {
		return null;
	}

}
