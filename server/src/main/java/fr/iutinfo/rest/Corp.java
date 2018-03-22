package fr.iutinfo.rest;

public class Corp {
	
	private int cno;
	private String nom;
	private String domain;
	
	public Corp() {}
	
	public Corp(int cno, String nom, String domain) {
		super();
		this.cno = cno;
		this.nom = nom;
		this.domain = domain;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cno;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Corp other = (Corp) obj;
		if (cno != other.cno)
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	public CorpDto convertToDto() {
		CorpDto dto = new CorpDto();
		dto.setDomain(domain);
		dto.setName(nom);
		return dto;
	}
	
	public void initDto(CorpDto dto) {
		this.nom = dto.getName();
		this.domain = dto.getDomain();
	}

}
