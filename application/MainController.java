package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

public class MainController implements Initializable{
	@FXML private Pane puzzleArea;

	private int[][] answers = { {0,0,1,0,0,0,1,0},
            {0,0,0,1,1,0,0,0},
            {1,0,0,0,0,1,0,0},
            {0,1,0,0,0,0,0,1},
            {0,0,0,1,3,3,3,3},
            {1,0,0,0,3,3,3,3},
            {0,0,1,0,3,3,3,3},
            {0,1,0,0,3,3,3,3}
            };
	private Puzzle master;

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		 master = new Puzzle(answers);

         puzzleArea.getChildren().add(master.returnGrid());

    }

}
