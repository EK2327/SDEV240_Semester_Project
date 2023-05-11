package application;

public class Responses {
	
	//Create static variables
	private static String[] responses = {"Too Low!", "Too High!", "Correct!"};
	
	//Constants
	final static int LOW_GUESS = 0;
	final static int HIGH_GUESS = 1;
	final static int CORRECT_GUESS = 2;
	
	//Constructor
	private Responses() {
		
	}
	
	public static String getResponse(int answer, int guess) {
		if (answer > guess)
			return responses[LOW_GUESS];
		else if (answer < guess)
			return responses[HIGH_GUESS];
		else
			return responses[CORRECT_GUESS];
		
	}

}
