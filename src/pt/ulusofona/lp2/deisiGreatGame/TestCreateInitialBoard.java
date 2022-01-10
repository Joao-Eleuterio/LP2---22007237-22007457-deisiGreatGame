package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestCreateInitialBoard {
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

    public String[][] creat3Players() {
        String[][] jogadores = new String[3][4];
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
        return jogadores;
    }

    public String[][] creat2Players() {
        String[][] jogadores = new String[2][4];
        jogadores[0][0] = "19";
        jogadores[0][1] = "João";
        jogadores[0][2] = "Java;Python";
        jogadores[0][3] = "Purple";

        jogadores[1][0] = "10";
        jogadores[1][1] = "Ana";
        jogadores[1][2] = "C;Java";
        jogadores[1][3] = "Green";
        return jogadores;
    }

    public String[][] creat1Players() {
        String[][] jogadores = new String[1][4];
        jogadores[0][0] = "19";
        jogadores[0][1] = "João";
        jogadores[0][2] = "Java;Python";
        jogadores[0][3] = "Purple";
        return jogadores;
    }

    //normal
    @Test
    public void test01CreateInitialBoard() {
        GameManager manager = new GameManager();
        try {
            manager.createInitialBoard(creat4Players(), 10);
        } catch (java.lang.Exception c) {
            assertFalse("Tem de conseguir criar", false);
        }
    }

    //boardSize demasiado pequeno
    @Test
    public void test02CreateInitialBoard() {
        GameManager manager = new GameManager();
        try {
            manager.createInitialBoard(creat4Players(), 6);
        } catch (java.lang.Exception c) {
            assertFalse("O tabuleiro tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.", false);
        }
    }

    //boardSize negativo
    @Test
    public void test03CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, -1);
        } catch (java.lang.Exception c) {
            assertFalse("Não pode ter número negativo", false);
        }

    }

    //So 1 jogador
    @Test
    public void test04CreateInitialBoard() {
        GameManager manager = new GameManager();
        try {
            manager.createInitialBoard(creat1Players(), 10);
        } catch (java.lang.Exception c) {
            assertFalse("Nao pode ter 1 jogador", false);
        }

    }

    //boardSize demasiado pequeno
    @Test
    public void test05CreateInitialBoard() {
        GameManager manager = new GameManager();
        try {
            manager.createInitialBoard(creat2Players(), 3);
        } catch (java.lang.Exception c) {
            assertFalse("O tabuleiro tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.", false);
        }
    }

    //normal
    @Test
    public void test06CreateInitialBoard() {
        GameManager manager = new GameManager();
        try {
            manager.createInitialBoard(creat2Players(), 4);
        } catch (java.lang.Exception c) {
            assertFalse("Tem que conseguir", false);
        }

    }

    //mesma cor
    @Test
    public void test07CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][3] = "Purple";
        jogadores[2][3] = "Purple";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter a mesma cor", false);
        }

    }

    //mesmo id
    @Test
    public void test08CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][0] = "44";
        jogadores[2][0] = "44";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter o mesmo id", false);
        }

    }

    //nome vazio
    @Test
    public void test09CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][1] = "";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter o nome vazio", false);
        }

    }

    //nome a null
    @Test
    public void test10CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][1] = null;
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter o nome a null", false);
        }

    }

    //outra cor
    @Test
    public void test11CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][3] = "Black";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não pode ter outra cor", false);
        }
    }


    //getProgrammers
    @Test
    public void test12CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNotEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(1).get(0).toString());
    }

    //getProgrammers Position
    @Test
    public void test13CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        String[][] jogadores1 = creat3Players();
        try {
            manager.createInitialBoard(jogadores, 30);

        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNotEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(1).get(0).toString());
    }


    //getProgrammers Position
    @Test
    public void test14CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        manager.moveCurrentPlayer(5);
        assertNotEquals("Tem de ordenar por id", "19 | João | 6 | Java; Python | Em Jogo", manager.getProgrammers(6).get(0).toString());
    }

    //ordenou
    @Test
    public void test15CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        manager.moveCurrentPlayer(5);
        assertNotEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(6).get(0).toString());
    }

    //ordenou
    @Test
    public void test16CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("Tem de ordenar por id", 2, manager.getCurrentPlayerID());
        manager.nextTurn();
        assertEquals("Tem de ordenar por id", 10, manager.getCurrentPlayerID());
    }

    //nao ordenou
    @Test
    public void test17CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNotEquals("Tem de ordenar por id", 19, manager.getCurrentPlayerID());
        manager.nextTurn();
        assertEquals("Tem de ordenar por id", 10, manager.getCurrentPlayerID());
    }

    //andar a mais
    @Test
    public void test18CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertFalse("Só pode andar de 1-6", manager.moveCurrentPlayer(19));

    }

    //normal
    @Test
    public void test19CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertTrue("Só pode andar de 1-6", manager.moveCurrentPlayer(5));

    }

    //boardSize nulo
    @Test
    public void test20CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();

        try {
            manager.createInitialBoard(jogadores, 0);
        } catch (java.lang.Exception c) {
            assertFalse("Não pode ter número nulo", false);
        }

    }


    //cor vazio
    @Test
    public void test21CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][3] = "";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter a cor vazio", false);
        }
    }

    //normal 2 players
    @Test
    public void test22CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertTrue("Só pode andar de 1-6", manager.moveCurrentPlayer(5));

    }


    //a mais 2 players
    @Test
    public void test23CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertFalse("Só pode andar de 1-6", manager.moveCurrentPlayer(75));

    }

    //normal 3 players
    @Test
    public void test24CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat3Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertTrue("Só pode andar de 1-6", manager.moveCurrentPlayer(5));

    }

    //a mais 3 players
    @Test
    public void test25CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat3Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertFalse("Só pode andar de 1-6", manager.moveCurrentPlayer(45));

    }


    //getProgrammers Position
    @Test
    public void test26CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat3Players();
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        manager.moveCurrentPlayer(5);
        assertNotEquals("Tem de ordenar por id", "19 | João | 6 | Java; Python | Em Jogo", manager.getProgrammers(6).get(0).toString());
    }

    //nome vazio 3 players
    @Test
    public void test27CreateInitialBoard() {
        GameManager manager = new GameManager();
        String[][] jogadores = creat3Players();
        jogadores[0][1] = "";
        try {
            manager.createInitialBoard(jogadores, 30);
        } catch (java.lang.Exception c) {
            assertFalse("Não podem ter o nome vazio", false);
        }

    }


}
