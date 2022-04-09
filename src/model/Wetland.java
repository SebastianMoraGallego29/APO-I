package model;

public class Wetland {

	private String id, wetlandName, url;
	private double area;
	private Location wetlandLocationArea;
	private Type wetlandType;
	private Species[] species;
	private WetlandEvent eventType;
	private Event[] events;

	public Wetland(String wetlandName, int wetlandLocationArea, int wetlandType, double area, String url) {

		this.wetlandName = wetlandName;

		switch (wetlandLocationArea) {

		case 1:
			this.wetlandLocationArea = Location.URBAN;
			break;
		case 2:
			this.wetlandLocationArea = Location.RURAL;
			break;

		}

		switch (wetlandType) {

		case 1:
			this.wetlandType = Type.PRIVATE;
			break;
		case 2:
			this.wetlandType = Type.PUBLIC;
			break;

		}

		this.area = area;
		this.url = url;
		species = new Species[50];
		events = new Event[50];

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWetlandName() {
		return wetlandName;
	}

	public void setWetlandName(String wetlandName) {
		this.wetlandName = wetlandName;
	}

	public Location getWetlandLocationArea() {
		return wetlandLocationArea;
	}

	public void setWetlandLocationArea(Location wetlandLocationArea) {
		this.wetlandLocationArea = wetlandLocationArea;
	}

	public Type getWetlandType() {
		return wetlandType;
	}

	public void setWetlandType(Type wetlandType) {
		this.wetlandType = wetlandType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Species[] getSpecies() {
		return species;
	}

	public void setSpecies(Species[] species) {
		this.species = species;
	}

	public Event[] getEvents() {
		return events;
	}

	public void setEvents(Event[] events) {
		this.events = events;
	}

	public boolean addSpecies(String speciesName, String speciesScientificName, int speciesKind) {

		boolean stopFlag = false;

		Species mySpecies = new Species(speciesName, speciesScientificName, speciesKind);

		for (int i = 0; i < species.length && !stopFlag; i++) {

			if (species[i] == null) {

				species[i] = mySpecies;
				stopFlag = true;

			}

		}

		return stopFlag;

	}

	public String speciesList() {

		String msg = "";

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {

				msg += species[i].getSpeciesName();
			}
		}

		return msg;

	}

	public boolean addEvent(int eventType, int year, int month, int day, String eventHost, double eventValue,
			String eventDescription) {

		boolean stopFlag = false;

		Event myEvent = new Event(eventType, year, month, day, eventHost, eventValue, eventDescription);

		for (int i = 0; i < events.length && !stopFlag; i++) {

			if (events[i] == null) {

				events[i] = myEvent;
				stopFlag = true;

			}

		}

		return stopFlag;

	}

	public int wetlandMaintenances(int y) {

		int m = 0;

		for (int i = 0; i < events.length; i++) {

			if (events[i] != null) {

				if ((events[i].getYear() == y)) {

					m++;

				}

			}

		}

		return m;

	}

	public int wetlandLessFlora() {

		int m = 0;

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {

				if ((species[i].getSpeciesKind().equals(Kind.TERRESTRIAL_FLORA))
						|| (species[i].getSpeciesKind().equals(Kind.AQUATIC_FLORA))) {

					m += 1;

				}

			}

		}

		return m;

	}

	public int wetlandMostFauna() {

		int m = 0;

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {

				if ((species[i].getSpeciesKind().equals(Kind.BIRD)) || (species[i].getSpeciesKind().equals(Kind.MAMMAL))
						|| (species[i].getSpeciesKind().equals(Kind.AQUATIC))) {

					m += 1;

				}

			}

		}

		return m;

	}

	public boolean wetlandsOfSpecies(String s) {
		
		boolean wetlandsOfSpecies = true;

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {

				if ((species[i].getSpeciesName().equals(s))) {

					wetlandsOfSpecies = false;

				}

			}

		}

		return wetlandsOfSpecies;

	}

	@Override
	public String toString() {

		String msg = "";

		msg += "Wetland info:\nName: " + wetlandName + "\nLocation area: " + wetlandLocationArea + "\nType: "
				+ wetlandType + "\nArea: " + area + "\nurl: " + url;

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {

				msg += "\n" + species[i].toString();
			}

		}

		return msg;

	}

}