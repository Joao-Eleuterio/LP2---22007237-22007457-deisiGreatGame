package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Exception {
    String message;

    InvalidInitialBoardException(String message) {
        this.message = message;
    }
    String  getMessage(){ return message;}

    Boolean isInvalidAbyss(){return true;}


    Boolean isInvalidTool(){
      return true;
   }

    Integer getTypeId(){
      return 0;
   }
}
