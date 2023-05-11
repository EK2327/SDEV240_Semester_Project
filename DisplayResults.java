package application;

public class DisplayResults {

	//Create instance variables
	private int totalGuesses;
	private int lowerBound;
	private int upperBound;
	
	//Constructor
	public DisplayResults() {
		this.lowerBound = 0;
		this.upperBound = 100;
	}
	
	//Mutator for totalGuesses
	public void incrementTotalGuesses() {
		totalGuesses += 1;
	}
	
	//Mutator for totalGuesses
	public void setTotalGuesses(int newTotalGuesses) {
		totalGuesses = newTotalGuesses;
	}
	
	//Access for totalGuesses
	public int getTotalGuesses() {
		return totalGuesses;
	}
	
	//Mutator for lowerBound
	public void setLowerBound(int newLowerBound) {
		lowerBound = newLowerBound;
	}
	
	//Accessor for lowerBound
	public int getLowerBound() {
		return lowerBound;
	}
	
	//Mutator for upperBound
	public void setUpperBound(int newUpperBound) {
		upperBound = newUpperBound;
	}
	
	//Accessor for upperBound
	public int getUpperBound() {
		return upperBound;
	}
	
	//toString method
	public String toString() {
		return ("It took " + totalGuesses + " guesses. The final guess was made within the bounds of "
	+ lowerBound + " and " + upperBound);
	}
}
