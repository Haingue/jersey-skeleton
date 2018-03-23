package fr.iutinfo.events;

public class EventDto {
	
	private int id = 0;
	private String label;
	private String dateEvent;
	private int price;
	private int participants;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(String date) {
		this.dateEvent = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	
	

}
