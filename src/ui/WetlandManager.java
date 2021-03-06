package ui;

import java.util.Scanner;

import model.WetlandController;

public class WetlandManager {
	
	public static Scanner sc;
	public static WetlandController controller;
	
	public static void main(String[] args) {

		init();
		showMainMenu();
		
	}
	
	public static void init() {

		sc = new Scanner(System.in);
		controller = new WetlandController();
	}
	
	public static void showMainMenu() {

		System.out.println("\nWelcome to Wetland Manager");

		boolean stopFlag = false;

		while (!stopFlag){

			System.out.println("\nType an option");
			System.out.println("1. Register a Wetland");
			System.out.println("2. Register a new Species in a Wetland");
			System.out.println("3. Register a new Event in a Wetland");
			System.out.println("4. Show Wetlands maintenance per Year");
			System.out.println("5. Show Wetland with least flora");
			System.out.println("6. Show Wetland with most fauna");
			System.out.println("7. Show Wetlands per Species");
			System.out.println("8. Show all Wetlands info");
			System.out.println("0. Exit");

			int mainOption = sc.nextInt();	
			
			switch (mainOption) {

				case 1:
					registerWetland();
				break;
				case 2:
					registerSpecies();
				break;
				case 3:
					registerEvents();
				break;
				case 8:
					System.out.println("These are the Wetlands currently registered");
					System.out.println(controller.showWetlands());
				break;
				case 0:
					stopFlag = true;
					System.out.println("\nThanks for using our system\n");
				break;
				default: 
					System.out.println("\nYou must type a valid option");
				break;
				
			}
			
		}
		
	}
	
	private static void registerWetland() {

		System.out.println("\nType the name of the Wetland: ");
		String wetlandName = sc.next();

		System.out.println("Type the location area\n1.URBAN\n2.RURAL");
		int wetlandLocationArea = sc.nextInt();
		
		System.out.println("Enter the type of Wetland\n1.PRIVATE\n2.PUBLIC");
		int wetlandType = sc.nextInt();
		
		System.out.println("Type the area in square kilometers of the Wetland");
		double area = sc.nextDouble();
		
		System.out.println("Type the url photo of the Wetland");
		String url = sc.next();
		
		/*
		System.out.println("Type 1 if the Wetland is protected or 0 if doesn't"); PREGUNTAR COMO LO HAGO, SI CON OTRO ENUM O ASI COMO LO TENGO
		int p = sc.nextInt();
		if (p==1) {
			boolean isProtectedArea = true;
		} 
		if (p==0) {
			boolean isProtectedArea = false;
		}
		*/
		
		if (controller.registerWetland(wetlandName, wetlandLocationArea, wetlandType, area, url)) {
			
			System.out.println("\nThe Wetland " + wetlandName + " was successfully registered");
			
		} else {
			
			System.out.println("\nThe Wetland " + wetlandName + " couldn't be registered");
			
		}
		
	}
	
	private static void registerSpecies() {
		
		if (controller.showWetlandsList().equals("")) {
			
			System.out.println("\nThere aren't any Wetlands registered.");
			
		} else {
			
			System.out.println("\nThese are the Wetlands currently registered:" + controller.showWetlandsList());
			
			System.out.println("\nType the ID of the Wetland to which you want to register a Species: ");
			String wetlandID = sc.next();
			
			System.out.println("Type the name of the Species: ");
			String speciesName = sc.next();
			
			System.out.println("Type the scientific name of the Species: ");
			String speciesScientificName = sc.next();
			
			//Falta hacer si la especie es migratoria, primero preguntar como es si el humedal es protegido para despues hacer este
			
			System.out.println("Type the kind of the Species\n1.TERRESTRIAL_FLORA\n2.AQUATIC_FLORA\n3.BIRD\n4.MAMMAL\n5.AQUATIC");
			int speciesKind = sc.nextInt();
			
			if (controller.registerSpecies(wetlandID, speciesName, speciesScientificName, speciesKind)) {
			
				System.out.println("Species was successfully registered");
				
			} else {
				
				System.out.println("Species couldn't be registered");
				
			}
			
		}
		
	}
	
	private static void registerEvents() {
		
		if (controller.showWetlandsList().equals("")) {
			
			System.out.println("\nThere aren't any Wetlands registered.");
			
		} else {
			
			System.out.println("\nThese are the Wetlands currently registered:" + controller.showWetlandsList());
			
			System.out.println("\nType the ID of the Wetland to which you want to register a Event: ");
			String wetlandID = sc.next();
			
			System.out.println("Type the the event to be carried out in the wetland\n1.MAINTENANCE\n2.SCHOOL_VISIT\n3.IMPROVEMENT_ACTIVITY\n4.CELEBRATION");
			int eventType = sc.nextInt();
			
			System.out.println("Type the new event date (YYYY-MM-DD): ");
			String eventDate = sc.next();

			int year = Integer.parseInt(eventDate.split("-")[0]);
			int month = Integer.parseInt(eventDate.split("-")[1]);
			int day = Integer.parseInt(eventDate.split("-")[2]);
			
			System.out.println("Type the name of the event host: ");
			String eventHost = sc.next();
			
			System.out.println("Type the value of the event: ");
			double eventValue = sc.nextDouble();
			
			System.out.println("Type the description of the event: ");
			String eventDescription = sc.next();
			
		}
		
	}
	
}