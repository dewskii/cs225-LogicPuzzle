package application;

//import javafx.application.Application;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
import javafx.geometry.Insets;
//import javafx.scene.input.MouseEvent;

public class Puzzle extends GridPane {
     //Will remove eventually and load in externally to allow for more puzzles
     private int[][] answers = { {0,0,1,0,0,0,1,0},
                                 {0,0,0,1,1,0,0,0},
                                 {1,0,0,0,0,1,0,0},
                                 {0,1,0,0,0,0,0,1},
                                 {0,0,0,1,3,3,3,3},
                                 {1,0,0,0,3,3,3,3},
                                 {0,0,1,0,3,3,3,3},
                                 {0,1,0,0,3,3,3,3}
                        };
   private final Image imageX = new Image("X.png");
   private final Image imageO = new Image("Circle.png");
   private final Image imageBlank = new Image("Blank.png");
   private GridPane gridPane = new GridPane();
   private Button[][] btn;
   private Cell[][] cellBlock1;
   private Cell[][] cellBlock2;
   private Cell[][] cellBlock3;
   private String clues;

   public Puzzle() {
	   btn = new Button[answers.length][answers.length];
       cellBlock1 = new Cell[4][4];
       cellBlock2 = new Cell[4][4];
       cellBlock3 = new Cell[4][4];
   }


   //To Be Called by Main GUI
   public boolean checkAnswers() {

    }
   public void clearErrors(){}

   public void getHint(){}

   public void setAnswers(){
	   for(int row=0; row<=3; row++){
           for( int column = 0; column<=3; column++) {
                if(answers[row][column] == 0)
                   cellBlock1[row][column] = new Cell('X');
                else if(answers[row][column] == 1)
                   cellBlock1[row][column] = new Cell('O');
                else if(answers[row][column] == 3)
                   cellBlock1[row][column] = new Cell('H');
            }
         }
	   for(int row=4; row<answers.length; row++){
           for( int column = 0; column<=3; column++) {
                if(answers[row][column] == 0)
                   cellBlock2[row][column] = new Cell('X');
                else if(answers[row][column] == 1)
                   cellBlock2[row][column] = new Cell('O');
                else if(answers[row][column] == 3)
                   cellBlock2[row][column] = new Cell('H');
            }
         }
	   for(int row=0; row<=3; row++){
           for( int column = 4; column<answers.length; column++) {
                if(answers[row][column] == 0)
                   cellBlock3[row][column] = new Cell('X');
                else if(answers[row][column] == 1)
                   cellBlock3[row][column] = new Cell('O');
                else if(answers[row][column] == 3)
                   cellBlock3[row][column] = new Cell('H');
            }
         }
   }

   public void generateGrid() {

       setAnswers();

       for(int i=0; i<btn.length; i++){
               for(int j=0; j<btn.length;j++){
               final int ii = i;
               final int jj = j;
               btn[i][j] = new Button();
               btn[i][j].setPrefSize(30,30);
               btn[i][j].setGraphic(new ImageView(imageBlank));
               btn[i][j].setPadding(Insets.EMPTY);

               gridPane.add(btn[i][j], i, j);
                 if( i>=4 && j>=4)
                     btn[i][j].setVisible(false);
		      //gridPane.getChildren().remove(btn[i][j]);
              }

        }
  }

   /*btn[ii][jj].setOnMousePressed((event) -> {

                   switch(event.getClickCount()) {
                   case 1:
                     cells[ii][jj].setUserState('X');
                     System.out.println(cells[ii][jj].getUserState());
                     btn[ii][jj].setGraphic(new ImageView(imageX));
                     btn[ii][jj].setPadding(Insets.EMPTY);
                     break;

                   case 2:
                     cells[ii][jj].setUserState('O');
                     System.out.println(cells[ii][jj].getUserState());
                     btn[ii][jj].setGraphic(new ImageView(imageO));
                     btn[ii][jj].setPadding(Insets.EMPTY);
                     break;

                   case 3:
                      cells[ii][jj].setUserState('B');
                      System.out.println(cells[ii][jj].getUserState());
                      btn[ii][jj].setGraphic(new ImageView(imageBlank));
                      btn[ii][jj].setPadding(Insets.EMPTY);
                      break;
                   }
         });
         */


}
