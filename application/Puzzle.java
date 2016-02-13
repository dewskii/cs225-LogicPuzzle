package application;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Puzzle {
	private Block block1;
	private Block block2;
	private Block block3;
	private HBox hLables;
	private VBox vLables;
	private GridPane masterGrid;

	public Puzzle(int[][] answers){
		 initializePuzzle(answers);
		 masterGrid = new GridPane();
		 GridPane grid1 = block1.returnGrid();
         GridPane grid2 = block2.returnGrid();
         GridPane grid3 = block3.returnGrid();
         masterGrid.add(grid1, 1, 1);
         masterGrid.add(grid2, 1, 2);
         masterGrid.add(grid3, 2, 1);

	}

	public void initializePuzzle(int[][] array){
		int[][] tempArray1 = new int[4][4];
		int[][] tempArray2 = new int[4][4];
		int[][] tempArray3 = new int[4][4];
		 for(int i=0; i<=3; i++){
	           for( int j = 0; j<=3; j++) {
	        	   tempArray1[i][j] = array[i][j];
	           }
		 }
		 for(int i=4; i<array.length; i++){
	           for( int j = 0; j<=3; j++) {
	        	   tempArray2[i-4][j] = array[i][j];
	           }
		 }
		 for(int i=0; i<=3; i++){
	           for( int j = 4; j<array.length; j++) {
	        	   tempArray3[i][j-4]=array[i][j];
	           }
		 }
		 block1 = new Block(tempArray1); block1.setButtons();
		 block2 = new Block(tempArray2); block2.setButtons();
		 block3 = new Block(tempArray3); block3.setButtons();
	}

	public GridPane returnGrid() {
		return masterGrid;
	}


	//NOT DONE
	public void showHints(){

	}
	//NOT DONE
	public void clearErrors(){
	}

    //NOT DONE
	public void checkAnswers(){
		block1.checkAnswers();
		block2.checkAnswers();
		block3.checkAnswers();
	}

	//NOT DONE
	public void setHLables(){
	}

	//NOT DONE
	public void setVLables(){
	}

	//NOT DONE
	public HBox returnHLables() {
		return hLables;
	}

	//NOT DONE
	public VBox returnVLables() {
		return vLables;
	}

	}


