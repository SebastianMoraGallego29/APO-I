package model;

public class WetlandController {
	
	private Wetland[] wetlands;
	
	public WetlandController() {
		
		wetlands = new Wetland[80];
		
	}
	
	public boolean registerWetland(String wetlandName, int wetlandLocationArea, int wetlandType, double area, String url) {
		
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
	
	public boolean registerSpecies(String wetlandID, String speciesName, String speciesScientificName, int speciesKind) {

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
	
	public boolean registerEvent(String wetlandID, int eventType, int year, int month, int day, String eventHost, double eventValue, String eventDescription) {

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)) {

					stopFlag = wetlands[i].addEvent(eventType, year, month, day, eventHost, eventValue, eventDescription);
					
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
	
}