package application;

public class Cell {
   final char BLANK = 'B';
   final char WRONG = 'X';
   final char RIGHT = 'O';
   final char HIDDEN = 'H';
   private boolean isLocked;
   char configState;
   char userState;

   public Cell(char aconfigState) {
       configState = aconfigState;
       userState = 'B';
       isLocked = false;
   }

   public void setUserState(char auserState) {
          //TODO Throw Error if not B, X, O
          userState = auserState;
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

   public boolean areSame(){
	   if (configState == userState)
		   return true;
	   return false;
   }

   public char getConfigState() {
          return configState;
    }
}
