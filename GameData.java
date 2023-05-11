package application;

public class GameData {
	
	//Create instance variables
	protected int lowerBound;
	protected int upperBound;
	protected int guess;
	protected int answer;
	
	//Create Constructors
	public GameData() {
		this.lowerBound = 0;
		this.upperBound = 100;
		this.answer = (int) (Math.random() * 100);
	}
	
	public GameData(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.answer = (int) (Math.random() * (upperBound - lowerBound) + lowerBound);
	}
	
	//Mutator for lowerBound
	public void setLowerBound(int newLowerBound) {
		lowerBound = (newLowerBound >= 0) ? newLowerBound : 0;
	}
	
	//Accessor for lowerBound
	public int getLowerBound() {
		return lowerBound;
	}
	//Mutator for upperBound
	public void setUpperBound(int newUpperBound) {
		upperBound = (newUpperBound >= 0) ? newUpperBound : 0;
	}
		
	//Accessor for upperBound
	public int getUpperBound() {
		return upperBound;
	}
	
	//Accessor for answer
	public int getAnswer() {
		return answer;
	}
	
	//Mutator for answer
	public void setAnswer(int newAnswer) {
		answer = newAnswer;
	}
	
	//Mutator for guess
	public void setGuess(int newGuess) {
		guess = newGuess;
	}
	
	//Accessor for guess
	public int getGuess() {
		return guess;
	}
	
	public String toString() {
		return ("Lower Bound: " + lowerBound + "\nUpper Bound: " + upperBound + "\nAnswer: " + answer);
	}
	
}
