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
        abismo[0][0]="1";
        abismo[0][1]="1";
        abismo[0][2]="21";
        abismo[1][0]="0";
        abismo[1][1]="2";
        abismo[1][2]="2";
        abismo[2][0]="2";
        abismo[2][1]="2";
        abismo[2][2]="22";
        assertFalse("Nao e ferramenta nem abismo",manager.createInitialBoard(creat4Players(),30,abismo));
        String[][] abismo1 = new String[3][3];
        abismo1[0][0]="1";
        abismo1[0][1]="1";
        abismo1[0][2]="21";
        abismo1[1][0]="0";
        abismo1[1][1]="10";
        abismo1[1][2]="2";
        abismo1[2][0]="1";
        abismo1[2][1]="2";
        abismo1[2][2]="22";
        assertFalse("Abismo errado",manager.createInitialBoard(creat4Players(),30,abismo1));
        String[][] abismo2 = new String[3][3];
        abismo2[0][0]="1";
        abismo2[0][1]="13";
        abismo2[0][2]="21";
        abismo2[1][0]="0";
        abismo2[1][1]="1";
        abismo2[1][2]="2";
        abismo2[2][0]="1";
        abismo2[2][1]="2";
        abismo2[2][2]="22";
        assertFalse("Ferramenta errada",manager.createInitialBoard(creat4Players(),30,abismo2));
        String[][] abismo3 = new String[3][3];
        abismo3[0][0]="1";
        abismo3[0][1]="13";
        abismo3[0][2]="32";
        abismo3[1][0]="0";
        abismo3[1][1]="1";
        abismo3[1][2]="2";
        abismo3[2][0]="1";
        abismo3[2][1]="2";
        abismo3[2][2]="22";
        assertFalse("Fora tabuleiro",manager.createInitialBoard(creat4Players(),30,abismo3));
    }
    @Test
    public void test03_GameManager(){
        GameManager manager = new GameManager();
        String[][] abismo = new String[3][3];
        abismo[0][0]="1";
        abismo[0][1]="1";
        abismo[0][2]="21";
        abismo[1][0]="0";
        abismo[1][1]="2";
        abismo[1][2]="2";
        abismo[2][0]="0";
        abismo[2][1]="2";
        abismo[2][2]="22";
        manager.createInitialBoard(creat4Players(),30,abismo);
        assertNull("fora do tabuleiro", manager.getImagePng(50));
        assertNull("fora do tabuleiro", manager.getImagePng(0));
        assertNull("fora do tabuleiro", manager.getImagePng(15));
    }


}