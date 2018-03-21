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
		ResultSet rs = sql_Query(
				"Select * from users where login = '" + user.getLogin() + "' and password = '" + user.getPass() + "'");
		User tmp = null;
		try {
			rs.next();
			int uno = rs.getInt("pno");
			String login = rs.getString("login");
			String passw = rs.getString("password");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String fonct = rs.getString("fonction");
			int cno = rs.getInt("cno");
			Corp corp = corpDAO.getCorpById(cno);
			tmp = new User(uno, login, passw, nom, prenom, fonct, corp);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tmp;
	}

	public User getUserByLogin(String loginUser) {
		ResultSet rs = sql_Query("Select * from users where login = '" + loginUser + "'");
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

	public User getUserByID(int id) {
		ResultSet rs = sql_Query("Select * from users where uno =" + id + "");

		try {
			rs.next();
			int uno = rs.getInt("pno");
			String login = rs.getString("login");
			String passw = rs.getString("password");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String fonct = rs.getString("fonction");
			int cno = rs.getInt("cno");
			User user = new User(uno, login, passw, nom, prenom, fonct, null);
			user.setCorp(corpDAO.getCorpById(cno));
			return user;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public User addUser(User user) {
		Corp c = getCorpByDomain(user);
		if (c == null) {
			return null;
		}
		String query = "insert into users values (default, '" + user.getLogin() + "', '" + user.getPass() + "', '"
				+ user.getNom() + "', '" + user.getPrenom() + "', '" + user.getFonction() + "', " + c.getCno() + " ";
		System.out.println(query);
		sql_Update(query);
		return user;
	}

	private Corp getCorpByDomain(User user) {
		String[] tab = user.getLogin().split("@");
		if (tab.length > 2) {
			return null;
		}
		String domaine = tab[tab.length - 1];
		return corpDAO.getCorpByDomainName(domaine);
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
