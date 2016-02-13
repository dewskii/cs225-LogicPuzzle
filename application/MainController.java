package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

public class MainController implements Initializable{
	@FXML private Pane puzzleArea;
	@FXML private Button startOver;
	@FXML private Button hints;
	@FXML private Button clearErrors;
	@FXML private TextArea textArea;
	@FXML private Button submitAnswers;

	private int[][] answers = { {0,0,1,0,0,0,1,0},
                                {0,0,0,1,1,0,0,0},
                                {1,0,0,0,0,1,0,0},
                                {0,1,0,0,0,0,0,1},
                                {0,0,0,1,3,3,3,3},
                                {1,0,0,0,3,3,3,3},
                                {0,0,1,0,3,3,3,3},
                                {0,1,0,0,3,3,3,3} };
	private Puzzle master;

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		 master = new Puzzle(answers);
         puzzleArea.getChildren().add(master.returnGrid());
         textArea.setWrapText(true);
         hints.setOnAction(new EventHandler<ActionEvent>() {
        	    @Override public void handle(ActionEvent e) {
        	    	master.showHints();
        	    }
         });
         clearErrors.setOnAction(new EventHandler<ActionEvent>() {
     	    @Override public void handle(ActionEvent e) {
    	    	master.clearErrors();
    	    }
     });
         submitAnswers.setOnAction(new EventHandler<ActionEvent>() {
      	    @Override public void handle(ActionEvent e) {
     	    	master.checkAnswers();
     	    }
      });

    }

}
