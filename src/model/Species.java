package model;

public class Species {

	private String speciesName, speciesScientificName;
	private Kind speciesKind;

	public Species(String speciesName, String speciesScientificName, int speciesKind) {

		this.speciesName = speciesName;
		this.speciesScientificName = speciesScientificName;

		switch (speciesKind) {

		case 1:
			this.speciesKind = Kind.TERRESTRIAL_FLORA;
			break;
		case 2:
			this.speciesKind = Kind.AQUATIC_FLORA;
			break;
		case 3:
			this.speciesKind = Kind.BIRD;
			break;
		case 4:
			this.speciesKind = Kind.MAMMAL;
			break;
		case 5:
			this.speciesKind = Kind.AQUATIC;
			break;

		}

	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getSpeciesScientificName() {
		return speciesScientificName;
	}

	public void setSpeciesScientificName(String speciesScientificName) {
		this.speciesScientificName = speciesScientificName;
	}

	public Kind getSpeciesKind() {
		return speciesKind;
	}

	public void setSpeciesKind(Kind speciesKind) {
		this.speciesKind = speciesKind;
	}

	@Override
	public String toString() {

		return "Species:\nSpecies name: " + speciesName + "\nSpecies scientific name: " + speciesScientificName
				+ "\nKind: " + speciesKind;

	}

}