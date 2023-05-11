package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {			
			
			//Create game objects
			Game currentGame = new Game();
			DisplayResults result = new DisplayResults();
			
			//Create GridPane
			GridPane root = new GridPane();
			root.setHgap(15);
		    root.setVgap(10);
			root.setPadding(new Insets(10, 15, 5, 15));
			
			//Create HBoxes
			HBox lowerBoundRow = new HBox(15);
			lowerBoundRow.setAlignment(Pos.CENTER_LEFT);
			HBox upperBoundRow = new HBox(15);
			upperBoundRow.setAlignment(Pos.CENTER_LEFT);
			HBox guessRow = new HBox(15);
			guessRow.setAlignment(Pos.CENTER_LEFT);
			
			//Create nodes
			Label lowerBoundLabel = new Label("Lower Bound:");
			Label upperBoundLabel = new Label("Upper Bound:");
			Label guessLabel = new Label("Guess:");
			
			Button startButton = new Button("Start Game");
			Button guessButton = new Button("Input Guess");
			
			TextField lowerBoundField = new TextField("0");
			lowerBoundField.setEditable(true);
			TextField upperBoundField = new TextField("100");
			upperBoundField.setEditable(true);
			TextField input = new TextField("0");
			input.setEditable(true);
			
			TextArea output = new TextArea("Press Start");
			output.setWrapText(true);
			output.setEditable(false);
			
			//Set action events
			startButton.setOnAction(
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							try {
								if(Integer.parseInt(lowerBoundField.getText()) >= Integer.parseInt(upperBoundField.getText())) {
									output.setText("Could not create game, please check input bounds");
									return;
								}
							}
							catch (NumberFormatException ex) {
								output.setText("Please enter integer values for bounds");
								return;
							}
							Game newGame = new Game(Integer.parseInt(lowerBoundField.getText()),
									Integer.parseInt(upperBoundField.getText()));
							currentGame.setLowerBound(newGame.getLowerBound());
							currentGame.setUpperBound(newGame.getUpperBound());
							currentGame.setClosestHigh(newGame.getClosestHigh());
							currentGame.setClosestLow(newGame.getClosestLow());
							currentGame.setAnswer(newGame.getAnswer());
							result.setTotalGuesses(0);
							output.setText("New game created with bounds of " + currentGame.getLowerBound() +
									" and " + currentGame.getUpperBound());
						}
					}
			);
			
			guessButton.setOnAction(
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							try {
								if(!((Integer.parseInt(input.getText()) <= currentGame.getUpperBound())
										&& (Integer.parseInt(input.getText()) >= currentGame.getLowerBound()))) {
									output.setText(output.getText() + "\nPlease enter a number between the bounds");
									return;
								}
							}
							catch (NumberFormatException ex){
								output.setText(output.getText() + "\nPlease enter an integer value for your guess");
								return;
							}
							result.incrementTotalGuesses();
							int curGuess = Integer.parseInt(input.getText());
							currentGame.setGuess(curGuess);
							output.setText(output.getText() + "\n" + curGuess + 
							" is " + Responses.getResponse(currentGame.getAnswer(), currentGame.getGuess()));
							if (curGuess == currentGame.getAnswer()){
								output.setText(output.getText() + "\n" + result.toString());
							}
							else {
								if (curGuess < currentGame.getAnswer()) {
									currentGame.setClosestLow(curGuess);
									result.setLowerBound(curGuess);
								}else {
									currentGame.setClosestHigh(curGuess);
									result.setUpperBound(curGuess);
								}
							}
						}
					}
			);
			
			//Put nodes into HBoxes
			lowerBoundRow.getChildren().addAll(lowerBoundLabel, lowerBoundField);
			upperBoundRow.getChildren().addAll(upperBoundLabel, upperBoundField);
			guessRow.getChildren().addAll(guessLabel, input);
			
			//Put elements into GridPane
			root.add(lowerBoundRow, 0, 0);
			root.add(upperBoundRow, 0, 1);
			root.add(startButton, 0, 2);
			root.add(guessRow, 0, 3);
			root.add(guessButton, 0, 4);
			root.add(output, 0, 5);
			
			//Create scene
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Number Guessing Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
