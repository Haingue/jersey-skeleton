package fr.iutinfo.rest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.ResultSetMapperFactory;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class User {

	private int uno;
	private String login;
	private String pass;
	private String nom;
	private String prenom;
	private String fonction;
	private Corp corp;


	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int uno, String login, String pass, String nom, String prenom, String fonction, Corp corp) {
		super();
		this.uno = uno;
		this.login = login;
		this.pass = pass;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.corp = corp;
	}

	public User(int uno, String login, String pass, String nom, String prenom, String fonction, int cno) {
		super();
		this.uno = uno;
		this.login = login;
		this.pass = pass;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;

		Corp corp = BDDFactory.getDbi().open(CorpDAO.class).getById(cno);
		this.corp = corp;
	}


	public Corp getCorp() {
		return corp;
	}
	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getCorpName() {
		return corp.getNom();
	}
	public int getCno() {
		return corp.getCno();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fonction == null) ? 0 : fonction.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + uno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (fonction == null) {
			if (other.fonction != null)
				return false;
		} else if (!fonction.equals(other.fonction))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (uno != other.uno)
			return false;
		return true;
	}

	public UserDto convertToDto() {
		UserDto tmp = new UserDto();
		tmp.setUno(uno);
		tmp.setNom(nom);
		tmp.setPrenom(prenom);
		tmp.setLogin(login);
		tmp.setPass(pass);
		tmp.setFonction(fonction);
		tmp.setCorp(this.corp.getNom());
		return tmp;
	}

	public void initFromDto(UserDto dto) {
		this.nom = dto.getNom();
		this.prenom = dto.getPrenom();
		this.login = dto.getLogin();
		this.pass = dto.getPass();
		this.uno = dto.getUno();
		this.fonction = dto.getFonction();
		CorpDAO corpDao = BDDFactory.getDbi().open(CorpDAO.class);
		Corp corp = corpDao.getByName(dto.getCorp());
		this.corp = corp;
	}

	public class UserMapper implements ResultSetMapper<User>{

		@Override
		public User map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
			CorpDAO dao = BDDFactory.getDbi().open(CorpDAO.class);
			Corp  corp = dao.getById(rs.getInt("cno"));
			int uno = rs.getInt("uno");
			String login = rs.getString("login");
			String pass = rs.getString("password");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String fonction = rs.getString("fonction");
			
			return new User(uno,login,pass,nom,prenom,fonction,corp);
		}

	}

}
