package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	private Connection con;
	
	public UserDAO() {
		con = new BDDFactory().getConnection();
	}
	
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		ResultSet rs = sql_Query("Select * from users", con);
		try {
			while(rs.next()) {
				int uno = rs.getInt("pno");
				String login = rs.getString("login");
				String passw = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonct = rs.getString("fonction");
				int cno = rs.getInt("cno");
				list.add(new User(uno, login, passw, nom, prenom, fonct));
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
