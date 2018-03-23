package fr.iutinfo.events;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Event {
	
	private int eno = 0;
	private String label;
	private String dateEvent;
	private int participantsNeeded;
	private int price;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}


	public Event(int eno, String label, String date, int participantsNeeded, int price) {
		super();
		this.eno = eno;
		this.label = label;
		this.dateEvent = date;
		this.participantsNeeded = participantsNeeded;
		this.price = price;
	}


	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}



	public String getDateEvent() {
		return dateEvent;
	}



	public void setDateEvent(String date) {
		this.dateEvent = date;
	}



	public int getParticipantsNeeded() {
		return participantsNeeded;
	}

	public void setParticipantsNeeded(int participantsNeeded) {
		this.participantsNeeded = participantsNeeded;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEvent == null) ? 0 : dateEvent.hashCode());
		result = prime * result + eno;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + participantsNeeded;
		result = prime * result + price;
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
		Event other = (Event) obj;
		if (dateEvent == null) {
			if (other.dateEvent != null)
				return false;
		} else if (!dateEvent.equals(other.dateEvent))
			return false;
		if (eno != other.eno)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (participantsNeeded != other.participantsNeeded)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	public EventDto convertToDto() {
		EventDto dto = new EventDto();
		dto.setId(eno);
		dto.setLabel(label);
		dto.setParticipants(participantsNeeded);
		dto.setPrice(price);
		dto.setDateEvent(dateEvent);
		return dto;
	}
	
	public void initFromDto(EventDto dto) {
		setDateEvent(dto.getDateEvent());
		setLabel(dto.getLabel());
		setPrice(dto.getPrice());
		setEno(dto.getId());
		setParticipantsNeeded(dto.getParticipants());
	}
	
	

}
