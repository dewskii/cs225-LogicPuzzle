package application;

public class Cell {
   final char BLANK = 'B';
   final char WRONG = 'X';
   final char RIGHT = 'O';
   final char HIDDEN = 'H';
   private boolean isLocked;
   char configState;
   char userState;

   public Cell(char configState) {
       this.configState = configState;
       userState = 'B';
       isLocked = false;
   }

   public void setUserState(char userState) {
          //TODO Throw Error if not B, X, O
          this.userState = userState;
    }

   public char getUserState() {
          return userState;
   }

   public void setLockState(boolean isLocked) {
	   this.isLocked = isLocked;
   }

   public boolean isLocked() {
	   return isLocked;
   }

   public char getConfigState() {
          return configState;
    }
}
