package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestGameManager {
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

    //temCor
    @Test
    public void test00_GameManager() {
        ArrayList<Programmer> programmers = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        linguagens.add("Python");
        linguagens.add("Java");
        programmers.add(new Programmer("Joao", linguagens, 10, ProgrammerColor.BROWN));
        programmers.add(new Programmer("Joao", linguagens, 11, ProgrammerColor.PURPLE));
        GameManager manager = new GameManager();
        assertFalse("cor dup", manager.temCor("Brown", programmers));
        assertFalse("cor Errada", manager.temCor("Red", programmers));
    }

    //temNovoID
    @Test
    public void test01_GameManager() {

        ArrayList<Programmer> programmers = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        linguagens.add("Python");
        linguagens.add("Java");
        programmers.add(new Programmer("Joao", linguagens, 10, ProgrammerColor.BROWN));
        programmers.add(new Programmer("Joao", linguagens, 11, ProgrammerColor.PURPLE));
        GameManager manager = new GameManager();
        assertFalse("id dup", manager.temNovoId("10", programmers));
    }

    @Test
    public void test02_GameManager() {
        GameManager manager = new GameManager();
        String[][] abismo = new String[3][3];
        abismo[0][0] = "1";
        abismo[0][1] = "1";
        abismo[0][2] = "21";
        abismo[1][0] = "0";
        abismo[1][1] = "2";
        abismo[1][2] = "2";
        abismo[2][0] = "0";
        abismo[2][1] = "2";
        abismo[2][2] = "22";
        try {
            manager.createInitialBoard(creat4Players(), 30, abismo);
        } catch (java.lang.Exception c) {
            c.printStackTrace();
        }
        assertNull("fora do tabuleiro", manager.getImagePng(50));
        assertNull("fora do tabuleiro", manager.getImagePng(0));
        assertEquals("fora do tabuleiro", "preto50x50.png", manager.getImagePng(15));

    }

    @Test
    public void test04_GameManager() {

        GameManager manager = new GameManager();
        String[][] abismo = new String[1][3];
        abismo[0][0] = "0";
        abismo[0][1] = "10";
        abismo[0][2] = "11";
        try {
            manager.createInitialBoard(creat4Players(), 30, abismo);
            manager.moveCurrentPlayer(4);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(3);
            manager.moveCurrentPlayer(1);
            manager.reactToAbyssOrTool();
        } catch (java.lang.Exception c) {
            c.printStackTrace();
        }
        assertEquals("Nao arrendondaste", 8, manager.players.get(0).getPosicao());
    }

    @Test
    public void test05_GameManager() {

        GameManager manager = new GameManager();
        String[][] abismo = new String[1][3];
        abismo[0][0] = "0";
        abismo[0][1] = "10";
        abismo[0][2] = "11";
        try {
            manager.createInitialBoard(creat4Players(), 30, abismo);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(6);
            manager.reactToAbyssOrTool();
        } catch (java.lang.Exception c) {
            c.printStackTrace();
        }
        assertEquals("Nao arrendondaste", 4, manager.players.get(0).getPosicao());
    }

    @Test
    public void test06_GameManager() {

        GameManager manager = new GameManager();
        String[][] abismo = new String[3][3];
        abismo[0][0] = "0";
        abismo[0][1] = "7";
        abismo[0][2] = "11";
        abismo[1][0] = "0";
        abismo[1][1] = "8";
        abismo[1][2] = "3";
        abismo[2][0] = "0";
        abismo[2][1] = "8";
        abismo[2][2] = "4";

        try {
            manager.createInitialBoard(creat4Players(), 30, abismo);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(6);
            manager.reactToAbyssOrTool();
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(2);
            manager.moveCurrentPlayer(6);
            manager.reactToAbyssOrTool();
            manager.moveCurrentPlayer(3);
            manager.reactToAbyssOrTool();
            manager.moveCurrentPlayer(2);
            manager.reactToAbyssOrTool();
            assertTrue("ninguem pode andar", manager.gameIsOver());
        } catch (java.lang.Exception c) {
            c.printStackTrace();
        }

    }

    @Test
    public void test07_GameManager() {
        String b= ", Jazz Jack-a-Rabbit 11 Ciclo Infinito, Goiaba 9 Ciclo Infinito, Pato Donald 7 Blue Screen of Death, Bruninho 5 Blue Screen of Death";
        boolean a=b.equals(", Jazz Jack-a-Rabbit 11 Ciclo infinito, Goiaba 9 Ciclo infinito, Pato Donald 7 Blue Screen of Death, Bruninho 5 Blue Screen of Death");
        System.out.println(a);
    }
}
//O GRANDE JOGO DO DEISI, , NR. DE TURNOS, 7, , O jogo terminou empatado., , Participantes:, Jazz Jack-a-Rabbit 11 Ciclo Infinito, Goiaba 9 Ciclo Infinito, Pato Donald 7 Blue Screen of Death, Bruninho 5 Blue Screen of Death
//O GRANDE JOGO DO DEISI, , NR. DE TURNOS, 7, , O jogo terminou empatado., , Participantes:, Jazz Jack-a-Rabbit 11 Blue Screen of Death, Goiaba 9 Blue Screen of Death, Pato Donald 7 Blue Screen of Death, Bruninho 5 Blue Screen of Death