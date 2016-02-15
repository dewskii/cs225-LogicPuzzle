package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Puzzle {
	private Block block1;
	private Block block2;
	private Block block3;
	private HBox hLabels;
	private VBox vLabels;
    private Text clues;
	private GridPane masterGrid;



	public Puzzle(int[][] answers){

		  initializePuzzle(answers);
            masterGrid = new GridPane();
            GridPane grid1 = block1.returnGrid();
            GridPane grid2 = block2.returnGrid();
            GridPane grid3 = block3.returnGrid();
            masterGrid.add(grid1, 0, 0);
            masterGrid.add(grid2, 1, 0);
            masterGrid.add(grid3, 0, 1);
            setHLabels();
            setVLabels();
            setClues();
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
		 for(int i=0; i<=3; i++){
	           for( int j = 4; j<array.length; j++) {
	        	   tempArray2[i][j-4] = array[i][j];
	           }
		 }
		 for(int i=4; i<array.length; i++){
	           for( int j = 0; j<=3; j++) {
	        	   tempArray3[i-4][j]=array[i][j];
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
		clearErrors();
	}

	public void clearErrors(){
              block1.clearErrors();
              block2.clearErrors();
              block3.clearErrors();
        }

    //NOT DONE
	public boolean checkAnswers(){
		if(block1.checkAnswers() && block2.checkAnswers())
			return true;
		else
			return false;
	}

	public void setHLabels(){
            hLabels = new HBox();
            Label label8 = new Label("Gladys"); label8.setFont(new Font("Arial", 10));
            Label label7 = new Label("Hannah"); label7.setFont(new Font("Arial", 10));
            Label label6 = new Label("Pam");    label6.setFont(new Font("Arial", 10));
            Label label5 = new Label("Roberta"); label5.setFont(new Font("Arial", 10));
            Label label4 = new Label("canary");  label4.setFont(new Font("Arial", 10));
            Label label3 = new Label("finch");   label3.setFont(new Font("Arial", 10));
            Label label2 = new Label("lorikeet"); label2.setFont(new Font("Arial", 10));
            Label label1 = new Label("parrot");  label1.setFont(new Font("Arial", 10));
            label1.setRotate(-90);
            label2.setRotate(-90);
            label3.setRotate(-90);
            label4.setRotate(-90);
            label5.setRotate(-90);
            label6.setRotate(-90);
            label7.setRotate(-90);
            label8.setRotate(-90);
            hLabels.getChildren().add(label1);
            hLabels.getChildren().add(label2);
            hLabels.getChildren().add(label3);
            hLabels.getChildren().add(label4);
            hLabels.getChildren().add(label5);
            hLabels.getChildren().add(label6);
            hLabels.getChildren().add(label7);
            hLabels.getChildren().add(label8);
	}

	public void setVLabels(){
            vLabels = new VBox(14);
            Label label1 = new Label("January");
            Label label2 = new Label("Feb");
            Label label3 = new Label("March");
            Label label4 = new Label("April");
            Label label5 = new Label("canary");
            Label label6 = new Label("finch");
            Label label7 = new Label("lorikeet");
            Label label8 = new Label("parrot");
            vLabels.getChildren().add(label1);
            vLabels.getChildren().add(label2);
            vLabels.getChildren().add(label3);
            vLabels.getChildren().add(label4);
            vLabels.getChildren().add(label5);
            vLabels.getChildren().add(label6);
            vLabels.getChildren().add(label7);
            vLabels.getChildren().add(label8);
	}

	public HBox returnHLabels() {
		return hLabels;
	}

	public VBox returnVLabels() {
		return vLabels;
	}

        public void setClues(){
            clues = new Text("\n" + "  1. Roberta's pet was bought sometime" + "\n" + "    after the finch." + "\n"
                    + "  2. The finch was bought 2 months" + "\n" + "    after Pam's pet." + "\n"
                    + "  3. The parrot was bought 2 months" + "\n" + "    before the lorikeet." + "\n"
                    + "  4. Gladys' pet is either the bird bought" + "\n" + "    in March or the lorikeet.");
        }

        public Text returnClues(){
            return clues;
        }

    void startOver() {
        int z = 0;
        while (z < 16){
        block1.startOver();
        block2.startOver();
        block3.startOver();
        z++;
        }
    }

	}


