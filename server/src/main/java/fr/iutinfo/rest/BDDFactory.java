package fr.iutinfo.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDFactory {
	
	public Connection getConnection() {
		Connection con = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			// System.out.println("Driver loaded !");
			String url = "jdbc:postgresql://psqlserv/n3p1";
			// port 5432 de la base n3p1
			String nom = "hainguef";
			String mdp = "moi";
			con = DriverManager.getConnection(url, nom, mdp);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
