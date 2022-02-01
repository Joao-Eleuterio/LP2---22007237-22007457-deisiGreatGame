package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends java.lang.Exception {
    String mensagem;
    int id;
    int erro;

    InvalidInitialBoardException(String mensagem, int invalidAbyssOrTool, int numeroAbyssOuTool) {
        this.mensagem = mensagem;
        this.id = invalidAbyssOrTool;
        this.erro=numeroAbyssOuTool;
    }


    public int getErro() {return erro;}

    public String getMessage(){
        return mensagem;
    }

    public boolean isInvalidAbyss(){
        return erro==0;
    }

    public boolean isInvalidTool(){
        return erro==1;
    }

    public int getTypeId(){
        if (erro == 0 || erro == 1){
            return id;
        }
        return Integer.MIN_VALUE;
    }
}

