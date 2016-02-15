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
	public Cell[][] cells;
	public Button[][] btn;
	 public final Image imageX = new Image("/application/X.png");
	 private final Image imageO = new Image("/application/Circle.png");
	 public final Image imageBlank = new Image("/application/Blank.png");


	public Block(int[][] array){
		cells = new Cell[array.length][array.length];
		btn = new Button[array.length][array.length];
		grid = new GridPane();
		 for(int row=0; row<cells.length; row++){
             for( int column = 0; column<cells.length; column++) {
                  if(array[row][column] == 0)
                     cells[row][column] = new Cell('X');
                  if(array[row][column] == 1)
                     cells[row][column] = new Cell('O');
                  btn[row][column] = new Button();
                  btn[row][column].setPrefSize(30,30);
                  btn[row][column].setGraphic(new ImageView(imageBlank));
                  btn[row][column].setPadding(Insets.EMPTY);
                  grid.add(btn[row][column], column, row);

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
						if(cells[row][column].isLocked())
							return;
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

        public Button[][] getButton(){
            return btn;
        }

        public Cell[][] getCell(){
            return cells;
        }

	public void unlockCells(int row, int column){
       for(int i=row+1; i<cells.length; i++){
			cells[i][column].setUserState('B');
			cells[i][column].setLockState(false);
			btn[i][column].setGraphic(new ImageView(imageBlank));
		}
		for(int i=0; i<row; i++){
			cells[i][column].setUserState('B');
			cells[i][column].setLockState(false);
			btn[i][column].setGraphic(new ImageView(imageBlank));
		}
		for(int j=0; j<column; j++){
			cells[row][j].setUserState('B');
			cells[row][j].setLockState(false);
			btn[row][j].setGraphic(new ImageView(imageBlank));
		}
		for(int j=column+1; j<cells.length; j++){
			cells[row][j].setUserState('B');
			cells[row][j].setLockState(false);
			btn[row][j].setGraphic(new ImageView(imageBlank));
		}

	}

	public void lockCells(int row, int column){
		for(int i=row+1; i<cells.length; i++){
			cells[i][column].setUserState('X');
			cells[i][column].setLockState(true);
			btn[i][column].setGraphic(new ImageView(imageX));
		}
		for(int i=0; i<row; i++){
			cells[i][column].setUserState('X');
			cells[i][column].setLockState(true);
			btn[i][column].setGraphic(new ImageView(imageX));
		}
		for(int j=0; j<column; j++){
			cells[row][j].setUserState('X');
			cells[row][j].setLockState(true);
			btn[row][j].setGraphic(new ImageView(imageX));
		}
		for(int j=column+1; j<cells.length; j++){
			cells[row][j].setUserState('X');
			cells[row][j].setLockState(true);
			btn[row][j].setGraphic(new ImageView(imageX));
		}
	}

	public void clearErrors(){

		for(int i = 0; i<cells.length; i++){
			for(int j = 0; j<cells.length; j++){
	                        if(!cells[i][j].areSame()){
	                           cells[i][j].setLockState(false);
	                           cells[i][j].setUserState('B');
				               btn[i][j].setGraphic(new ImageView(imageBlank));
	                        }
	                }
	}
	}
    //NOT DONE
	public boolean checkAnswers() {

		for(int i = 0; i<cells.length; i++){
			for(int j = 0; j<cells.length; j++){
                            //int row = i;
                            //int column = j;
                            if(cells[i][j].getUserState() != cells[i][j].getConfigState())
                            {


                                return false;
                            }
			}
		}


           return true;
        }




        public void startOver(){
            for(int i = 0; i<cells.length; i++){
		for(int j = 0; j<cells.length; j++){
			int row = i;
			int column = j;
			if(cells[row][column].getUserState() == 'X'){
				cells[row][column].setUserState('B');
				btn[row][column].setGraphic(new ImageView(imageBlank));
				return;
						}
			if(cells[row][column].getUserState() == 'O'){
				cells[row][column].setUserState('B');
				btn[row][column].setGraphic(new ImageView(imageBlank));
				return;
						}
        }
        }
        }
}




