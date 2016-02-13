package application;

import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Block extends GridPane {

	private GridPane grid;
	private Cell[][] cells;
	private Button[][] btn;
	 private final Image imageX = new Image("/application/X.png");
	 private final Image imageO = new Image("/application/Circle.png");
	 private final Image imageBlank = new Image("/application/Blank.png");

	public Block(int[][] array){
		cells = new Cell[array.length][array.length];
		btn = new Button[array.length][array.length];
		grid = new GridPane();
		 for(int row=0; row<array.length; row++){
             for( int column = 0; column<array.length; column++) {
                  if(array[row][column] == 0)
                     cells[row][column] = new Cell('X');
                  else if(array[row][column] == 1)
                     cells[row][column] = new Cell('O');
                  else if(array[row][column] == 3)
                     cells[row][column] = new Cell('H');
                  btn[row][column] = new Button();
                  btn[row][column].setPrefSize(30,30);
                  btn[row][column].setGraphic(new ImageView(imageBlank));
                  btn[row][column].setPadding(Insets.EMPTY);
                  grid.add(btn[row][column], row, column);

              }
           }
	}
	public GridPane returnGrid(){
		return grid;
	}

	public void setButtons(){
		for(int i = 0; i<btn.length; i++){
			for(int j = 0; j<btn.length; j++){
				int row = i;
				int column = j;
				btn[i][j].setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event){
						if(cells[row][column].getUserState() == 'B'){
							cells[row][column].setUserState('X');
							btn[row][column].setGraphic(new ImageView(imageX));
							return;
							}
						if(cells[row][column].getUserState() == 'X'){
							cells[row][column].setUserState('O');
							btn[row][column].setGraphic(new ImageView(imageO));
							lockCells(row,column);
							return;
						}
						if(cells[row][column].getUserState() == 'O'){
							cells[row][column].setUserState('B');
						    btn[row][column].setGraphic(new ImageView(imageBlank));
						    unlockCells(row,column);
						    return;
						}

				      }
				});
			}
		}

	}

	public void unlockCells(int row, int column){
              	for(int i=row+1; i<cells.length; i++){
			cells[i][column].setUserState('B');
			btn[i][column].setGraphic(new ImageView(imageBlank));
		}
		for(int i=0; i<row; i++){
			cells[i][column].setUserState('B');
			btn[i][column].setGraphic(new ImageView(imageBlank));
		}
		for(int j=0; j<column; j++){
			cells[row][j].setUserState('B');
			btn[row][j].setGraphic(new ImageView(imageBlank));
		}
		for(int j=column+1; j<cells.length; j++){
			cells[row][j].setUserState('B');
			btn[row][j].setGraphic(new ImageView(imageBlank));
		}





	}

	public void lockCells(int row, int column){
		for(int i=row+1; i<cells.length; i++){
			cells[i][column].setUserState('X');
			btn[i][column].setGraphic(new ImageView(imageX));
		}
		for(int i=0; i<row; i++){
			cells[i][column].setUserState('X');
			btn[i][column].setGraphic(new ImageView(imageX));
		}
		for(int j=0; j<column; j++){
			cells[row][j].setUserState('X');
			btn[row][j].setGraphic(new ImageView(imageX));
		}
		for(int j=column+1; j<cells.length; j++){
			cells[row][j].setUserState('X');
			btn[row][j].setGraphic(new ImageView(imageX));
		}
	}

	public void checkAnswers() {}


}


