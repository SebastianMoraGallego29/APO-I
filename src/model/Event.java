package model;

public class Event {
	
	private WetlandEvent eventType;
	private Date eventDate;
	private String eventHost, eventDescription;
	private double eventValue;
	
	public Event(int eventType, int year, int month, int day, String eventHost, double eventValue, String eventDescription) {
		
		switch(eventType) {
		
			case 1: 
				this.eventType = WetlandEvent.MAINTENANCE;
			break;
			case 2: 
				this.eventType = WetlandEvent.SCHOOL_VISIT;
			break;
			case 3: 
				this.eventType = WetlandEvent.IMPROVEMENT_ACTIVITY;
			break;
			case 4: 
				this.eventType = WetlandEvent.CELEBRATION;
			break;
			
		}
		
		this.eventDate = new Date(day, month, year);
		this.eventHost = eventHost;
		this.eventValue = eventValue;
		this.eventDescription = eventDescription;
		
	}
	
	public WetlandEvent getEventType() {
		return eventType;
	}

	public void setEventType(WetlandEvent eventType) {
		this.eventType = eventType;
	}
	
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public void setEventDate(int day, int month, int year) {
		this.eventDate = new Date(day, month, year);
	}
	
	public String getEventHost() {
		return eventHost;
	}

	public void setEventHost(String eventHost) {
		this.eventHost = eventHost;
	}
	
	public double getEventValue() {
		return eventValue;
	}

	public void setEventValue(double eventValue) {
		this.eventValue = eventValue;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	@Override
	public String toString() {
		
		return "Event:\nEvent type: " + eventType + "\nEvent date: " + eventDate + "\nEvent host: " + eventHost + "\nEvent value: " + eventValue + "\nEvent Description: " + eventDescription;
		
	}
	
}