package application;

import javafx.scene.layout.GridPane;

public class Puzzle {
	private Block block1;
	private Block block2;
	private Block block3;
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

}
