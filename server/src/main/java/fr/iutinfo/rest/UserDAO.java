package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private BDDFactory bddFact;
	private CorpDAO corpDAO;

	public UserDAO() {
		bddFact = new BDDFactory();
		corpDAO = new CorpDAO();
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		ResultSet rs = sql_Query("Select * from users");
		try {
			while (rs.next()) {
				int uno = rs.getInt("pno");
				String login = rs.getString("login");
				String passw = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonct = rs.getString("fonction");
				int cno = rs.getInt("cno");
				User user = new User(uno, login, passw, nom, prenom, fonct, null);
				user.setCorp(corpDAO.getCorpById(cno));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public User checkUser(User user) {
		ResultSet rs = sql_Query("Select * from users where uno=" + user.getUno() + "");
		try {
			rs.next();
			int uno = rs.getInt("pno");
			String login = rs.getString("login");
			String passw = rs.getString("password");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String fonct = rs.getString("fonction");
			int cno = rs.getInt("cno");
			User tmp = new User(uno, login, passw, nom, prenom, fonct, null);
			tmp.setCorp(corpDAO.getCorpById(cno));
			return tmp;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<User> getUsersByCorpId(int idCorp) {
		List<User> list = new ArrayList<User>();
		ResultSet rs = sql_Query("Select * from users where cno =" + idCorp + "");

		try {
			while (rs.next()) {
				int uno = rs.getInt("pno");
				String login = rs.getString("login");
				String passw = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String fonct = rs.getString("fonction");
				int cno = rs.getInt("cno");
				User user = new User(uno, login, passw, nom, prenom, fonct, null);
				user.setCorp(corpDAO.getCorpById(cno));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public void addUser(User user) {
		try {
			String domaine = user.getLogin().split("@")[1];
		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}

	private ResultSet sql_Query(String request) {
		Connection con = bddFact.getConnection();
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(request);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception er) {
			System.out.println("Error");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	private void sql_Update(String request) {
		Connection con = bddFact.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(request);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception er) {
			System.out.println("Error");
		}
	}

}
