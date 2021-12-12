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

    public String [] [] abyssesAndTools1 (){
        String[][] abysses = new String[4][3];
        abysses[0][0] = "1";
        abysses[0][1] = "0";
        abysses[0][2] = "2";

        abysses[1][0] = "0";
        abysses[1][1] = "5";
        abysses[1][2] = "3";

        abysses[2][0] = "1";
        abysses[2][1] = "0";
        abysses[2][2] = "4";

        abysses[3][0] = "0";
        abysses[3][1] = "5";
        abysses[3][2] = "5";


      return abysses;
    }



    //normal
    @Test
    public void test01CreateInitialBoard2() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertTrue("Tem de conseguir criar", manager.createInitialBoard(creat4Players(), 10,abyssesAndTools1()));

    }



    //boardSize demasiado pequeno
    @Test
    public void test02CreateInitialBoard2() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        assertFalse("O tabuleiro tem de ter, pelo menos, duas posições por cada jogador que esteja em jogo.", manager.createInitialBoard(creat4Players(), 6,abyssesAndTools1()));
    }



    //nome vazio
    @Test
    public void test03CreateInitialBoard2() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        jogadores[0][1] = "";
        assertFalse("Não podem ter o nome vazio", manager.createInitialBoard(jogadores, 30,abyssesAndTools1()));
    }

    //getProgrammers
    @Test
    public void test04CreateInitialBoard2() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 30,abyssesAndTools1());
        assertNotEquals("Tem de ordenar por id", "2 | Ines | 1 | Python | Em Jogo", manager.getProgrammers(1).get(0).toString());
    }





    @Test
    public void test05CreateInitialBoard2() {
        pt.ulusofona.lp2.deisiGreatGame.GameManager manager = new pt.ulusofona.lp2.deisiGreatGame.GameManager();
        String[][] jogadores = creat4Players();
        manager.createInitialBoard(jogadores, 25,abyssesAndTools1());
        assertTrue(manager.moveCurrentPlayer(1));
        String esperada = "Caiu Herança! Anula os feitos de codigo duplicado";
        assertEquals(esperada,manager.reactToAbyssOrTool());
    }













}
