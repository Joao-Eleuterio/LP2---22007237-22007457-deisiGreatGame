package pt.ulusofona.lp2.deisiGreatGame;



import org.junit.Test;

import static org.junit.Assert.*;
public class TestCreateInitialBoard2 {

    public String[][] creat4Players() {
        String[][] jogadores = new String[4][4];
        jogadores[0][0] = "19";
        jogadores[0][1] = "João";
        jogadores[0][2] = "Java;Python";
        jogadores[0][3] = "Purple";

        jogadores[1][0] = "10";
        jogadores[1][1] = "Ana";
        jogadores[1][2] = "C;Java";
        jogadores[1][3] = "Green";

        jogadores[2][0] = "2";
        jogadores[2][1] = "Ines";
        jogadores[2][2] = "Python";
        jogadores[2][3] = "Blue";

        jogadores[3][0] = "99";
        jogadores[3][1] = "Carlos";
        jogadores[3][2] = "C";
        jogadores[3][3] = "Brown";

        return jogadores;
    }

    public String [] [] createAbyssesAndTools (){
        String[][] abysses = new String[0][16];
        abysses[0] [0] = "ErroSintaxe";
        abysses[0] [1] = "ErroLogica";
        abysses[0] [2] = "Exception";
        abysses[0] [3] = "FileNotFoundException";
        abysses[0] [4] = "Crash";
        abysses[0] [5] = "DuplicatedCode";
        abysses[0] [6] = "EfeitosSecundarios";
        abysses[0] [7] = "BlueScreenOfDeath";
        abysses[0] [8] = "CicloInfinito";
        abysses[0] [9] = "SegmentationFault";
        abysses[0] [10] = "Heranca";
        abysses[0] [11] = "ProgramacaoFuncional";
        abysses[0] [12] = "JUnit";
        abysses[0] [13] = "TratamentoExcepcoes";
        abysses[0] [14] = "IDE";
        abysses[0] [15] = "AjudaProfessor";


      return abysses;
    }


}
