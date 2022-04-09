package model;

public class WetlandController {

	private Wetland[] wetlands;
	private Event[] events;

	public WetlandController() {

		wetlands = new Wetland[80];
		events = new Event[50];

	}

	public boolean registerWetland(String wetlandName, int wetlandLocationArea, int wetlandType, double area,
			String url) {

		boolean stopFlag = false;

		Wetland myWetland = new Wetland(wetlandName, wetlandLocationArea, wetlandType, area, url);

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] == null) {

				myWetland.setId((i + 1) + "");
				wetlands[i] = myWetland;
				stopFlag = true;

			}

		}

		return stopFlag;

	}

	public String showWetlandsList() {

		String msg = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "\n" + wetlands[i].getId() + ". " + wetlands[i].getWetlandName();
			}
		}

		return msg;

	}

	public boolean registerSpecies(String wetlandID, String speciesName, String speciesScientificName,
			int speciesKind) {

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)) {

					stopFlag = wetlands[i].addSpecies(speciesName, speciesScientificName, speciesKind);

				}

			}

		}

		return stopFlag;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "-" + wetlands[i].speciesList();

						}
					}
	
		return msg;
		
	}

	public boolean registerEvent(String wetlandID, int eventType, int year, int month, int day, String eventHost,
			double eventValue, String eventDescription) {

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)) {

					stopFlag = wetlands[i].addEvent(eventType, year, month, day, eventHost, eventValue,
							eventDescription);

				}

			}

		}

		return stopFlag;

	}

	public String showWetlands() {

		String msg = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "\n" + wetlands[i].toString();

			}

		}

		return msg;

	}

	public String consultMaintenancesPerYear(int y) {

		String msg = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].wetlandMaintenances(y) > 0) {

					msg += "The Wetland " + wetlands[i].getWetlandName() + " had " + wetlands[i].wetlandMaintenances(y)
							+ " maintenances in " + y + "\n";

				}

			}

		}

		return msg;

	}

	public String consultWetlandLessFlora() {

		String msg = "";
		int min = 100;

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].wetlandLessFlora() < min) {

					min = wetlands[i].wetlandLessFlora();
					msg = "The Wetland " + wetlands[i].getWetlandName() + " has the less Flora";

				}

			}

		}

		return msg;

	}

	public String consultWetlandMostFauna() {

		String msg = "";
		int max = 0;

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].wetlandMostFauna() > max) {

					max = wetlands[i].wetlandMostFauna();
					msg = "The Wetland " + wetlands[i].getWetlandName() + " has the Most Fauna";

				}

			}

		}

		return msg;

	}

	public String consultWetlandsOfSpeceis(String s) {

		String msg = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "-" + wetlands[i].getWetlandName() + "\n";

			}

		}

		return msg;

	}

}