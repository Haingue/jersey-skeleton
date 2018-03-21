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
	
	public List<Utilisateur> getAllUsers() {
		/*List<Utilisateur> list = new ArrayList<Utilisateur>();
		ResultSet rs = sql_Query("Select * from Personne where role = '"+"' ", con);
		try {
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
		}
		return list;*/
	}

}
