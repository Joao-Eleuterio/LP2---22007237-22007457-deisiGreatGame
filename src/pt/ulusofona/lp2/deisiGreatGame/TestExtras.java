package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestExtras {
    public String[][] creat2Players() {
        String[][] jogadores = new String[2][4];
        jogadores[0][0] = "1";
        jogadores[0][1] = "Joao";
        jogadores[0][2] = "Python;Java";
        jogadores[0][3] = "Purple";

        jogadores[1][0] = "3";
        jogadores[1][1] = "Ana";
        jogadores[1][2] = "";
        jogadores[1][3] = "Brown";

        return jogadores;
    }
    @Test
    public void test00_InvalidInitialBoardException() throws InvalidInitialBoardException {
        ArrayList<InvalidInitialBoardException> invalidInitialBoardExceptions = new ArrayList<>();
        invalidInitialBoardExceptions.add(new InvalidInitialBoardException("ola",0,0));
        invalidInitialBoardExceptions.add(new InvalidInitialBoardException("",1,0));
        invalidInitialBoardExceptions.add(new InvalidInitialBoardException("",2,0));
        assertEquals("","ola",invalidInitialBoardExceptions.get(0).getMessage());
        assertEquals("",-1,invalidInitialBoardExceptions.get(0).getTypeId());
        GameManager manager = new GameManager();
        manager.createInitialBoard(creat2Players(),10,null);
    }

}
