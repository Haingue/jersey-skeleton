package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

/**
 * Classe qui sert a la communication client/serveur d'utilisateur.
 * 
 * @author equipe3
 *
 */
public class UserDto {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private String name;
    private String surname;
    private int id = 0;
    private String login;
    private String password;
    private String fonction;
    private String profilUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getProfilUrl() {
		return profilUrl;
	}

	public void setProfilUrl(String profilUrl) {
		this.profilUrl = profilUrl;
	}
	
	



}
