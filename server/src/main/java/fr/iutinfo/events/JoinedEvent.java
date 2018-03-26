package fr.iutinfo.events;

public class JoinedEvent {
	
	private int user_id;
	private int event_eno;
	
	public JoinedEvent() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + event_eno;
		result = prime * result + user_id;
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
		JoinedEvent other = (JoinedEvent) obj;
		if (event_eno != other.event_eno)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getEvent_eno() {
		return event_eno;
	}

	public void setEvent_eno(int event_eno) {
		this.event_eno = event_eno;
	}
	
	

}
