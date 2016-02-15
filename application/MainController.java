package application;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class MainController implements Initializable{
	@FXML private Pane puzzleArea;
    @FXML private Pane hLables;
    @FXML private Pane vLables;
    @FXML private Pane cluesTab;
	@FXML private Button startOver;
	@FXML private Button hints;
	@FXML private Button clearErrors;
	@FXML private TextArea textArea;
	@FXML private Button submitAnswers;
	@FXML private MenuItem closeButton;
	@FXML Parent rootPane;

	private int[][] answers = {{0,0,1,0,1,0,0,0},
                               {0,1,0,0,0,0,0,1},
                               {1,0,0,0,0,1,0,0},
                               {0,0,0,1,0,0,1,0},
                               {0,0,1,0,3,3,3,3},
                               {1,0,0,0,3,3,3,3},
                               {0,0,0,1,3,3,3,3},
                               {0,1,0,0,3,3,3,3}};
	private Puzzle master;


	@Override
    public void initialize(URL url, ResourceBundle rb) {
	 master = new Puzzle(answers);
         puzzleArea.getChildren().add(master.returnGrid());
         hLables.getChildren().add(master.returnHLabels());
         vLables.getChildren().add(master.returnVLabels());
         cluesTab.getChildren().add(master.returnClues());
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
      	    	Label secondLabel = new Label("Correct!");
      	       if(master.checkAnswers()){
                    secondLabel = new Label("Correct!");
               }
               else {
            	   secondLabel = new Label("Wrong, try again!");
               }
               StackPane secondaryLayout = new StackPane();
               secondaryLayout.getChildren().add(secondLabel);

               Scene secondScene = new Scene(secondaryLayout, 200, 100);

               Stage secondStage = new Stage();
               secondStage.setTitle("Second Stage");
               secondStage.setScene(secondScene);
               secondStage.show();
           }
       });
         startOver.setOnAction(new EventHandler<ActionEvent>() {
      	    @Override public void handle(ActionEvent e) {
     	    	master.startOver();
     	    }
     });


    }

}
