package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	private Connection con;
	
	public UserDAO() {
		con = new BDDFactory().getConnection();
	}
	
	public List<Utilisateur> getAllUsers() {
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		ResultSet rs = sql_Query("Select * from users", con);
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
		return list;
	}
	
	public Utilisateur checkUser(Utilisateur user) {
		return null;
	}
	
	private ResultSet sql_Query(String request, Connection con) {
		System.out.println("request:\n" + request);
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(request);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception er) {
			System.out.println("Error");
		}
		return rs;
	}

}
