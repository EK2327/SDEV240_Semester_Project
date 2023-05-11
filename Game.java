package application;

public class Game extends GameData {
	
	//Create instance variables
	private int guessesMade;
	private int closestHigh;
	private int closestLow;
		
	//Create Constructors
	public Game() {
		this.closestHigh = upperBound;
		this.closestLow = lowerBound;
	}
	
	public Game(int lowerBound, int upperBound) {
		super(lowerBound, upperBound);
		this.closestHigh = upperBound;
		this.closestLow = lowerBound;
	}
	
	//Mutator for guess
	@Override
	public void setGuess(int newGuess) {
		guess = newGuess;
		guessesMade += 1;
	}
	
	//Accessor for guessesMade
	public int getGuessesMade() {
		return guessesMade;
	}
	
	//Mutator for closestHigh
	public void setClosestHigh(int newClosestHigh) {
		closestHigh = newClosestHigh;
	}
	
	//Accessor for closestHugh
	public int getClosestHigh() {
		return closestHigh;
	}
	//Mutator for closestLow
	public void setClosestLow(int newClosestLow) {
		closestLow = newClosestLow;
	}
		
	//Accessor for closestLow
	public int getClosestLow() {
		return closestLow;
	}
	

}
