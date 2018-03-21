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
	
<<<<<<< HEAD:server/src/main/java/fr/iutinfo/rest/UserDAO.java
	public List<Utilisateur> getAllUsers() {
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		ResultSet rs = sql_Query("Select * from users", con);
		try {
=======
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		//ResultSet rs = sql_Query("Select * from Utilisateur where role = '"+"' ", con);
		/*try {
>>>>>>> aed32dd6dea8071001f1bf53b081a34108ad1e83:server/src/main/java/fr/iutinfo/rest/UtilisateurDAO.java
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
	
	public User checkUser(User user) {
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
