/*package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

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
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertTrue("Tem de conseguir criar", manager.createInitialBoard(creat4Players(), 10));

    }

    //boardSize demasiado pequeno
    @Test
    public void test02CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertFalse("O tabuleiro tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.", manager.createInitialBoard(creat4Players(), 6));
    }

    //boardSize negativo
    @Test
    public void test03CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();

        assertFalse("Não pode ter número negativo", manager.createInitialBoard(jogadores, -1));

    }

    //So 1 jogador
    @Test
    public void test04CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertFalse("Nao pode ter 1 jogador", manager.createInitialBoard(creat1Players(), 10));
    }

    //boardSize demasiado pequeno
    @Test
    public void test05CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertFalse("O tabuleiro tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.", manager.createInitialBoard(creat2Players(), 3));
    }

    //normal
    @Test
    public void test06CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertTrue("Tem que conseguir", manager.createInitialBoard(creat2Players(), 4));
    }

    //mesma cor
    @Test
    public void test07CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][3] = "Purple";
        jogadores[2][3] = "Purple";
        assertFalse("Não podem ter a mesma cor", manager.createInitialBoard(jogadores, 30));
    }

    //mesmo id
    @Test
    public void test08CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][0] = "44";
        jogadores[2][0] = "44";
        assertFalse("Não podem ter o mesmo id", manager.createInitialBoard(jogadores, 30));
    }

    //nome vazio
    @Test
    public void test09CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][1] = "";
        assertFalse("Não podem ter o nome vazio", manager.createInitialBoard(jogadores, 30));
    }

    //nome a null
    @Test
    public void test10CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][1] = null;
        assertFalse("Não podem ter o nome a null", manager.createInitialBoard(jogadores, 30));
    }

    //outra cor
    @Test
    public void test11CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][3] = "Black";
        assertFalse("Não podem ter outra cor", manager.createInitialBoard(jogadores, 30));
    }

    //getProgrammers
    @Test
    public void test12CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(1).get(0).toString());
    }

    //getProgrammers Position
    @Test
    public void test13CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(1).get(0).toString());
    }

    //getProgrammers Position
    @Test
    public void test14CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        manager.moveCurrentPlayer(5);
        assertNotEquals("Tem de ordenar por id", "19 | João | 6 | Java; Python | Em Jogo", manager.getProgrammers(6).get(0).toString());
    }

    //ordenou
    @Test
    public void test15CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        manager.moveCurrentPlayer(5);
        assertNotEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(6).get(0).toString());
    }

    //ordenou
    @Test
    public void test16CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertEquals("Tem de ordenar por id", 2, manager.getCurrentPlayerID());
        manager.nextTurn();
        assertEquals("Tem de ordenar por id", 10, manager.getCurrentPlayerID());
    }

    //nao ordenou
    @Test
    public void test17CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertNotEquals("Tem de ordenar por id", 19, manager.getCurrentPlayerID());
        manager.nextTurn();
        assertEquals("Tem de ordenar por id", 10, manager.getCurrentPlayerID());
    }

    //andar a mais
    @Test
    public void test18CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertFalse("Só pode andar de 1-6", manager.moveCurrentPlayer(19));

    }

    //normal
    @Test
    public void test19CreateInitialBoard() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30);
        assertTrue("Só pode andar de 1-6", manager.moveCurrentPlayer(5));

    }


}
*/