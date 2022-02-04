package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestGameManager {
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

    public String[][] creatAbism() {
        String[][] abismo = new String[2][3];
        abismo[0][0] = "1";
        abismo[0][1] = "3";
        abismo[0][2] = "10";
        abismo[1][0] = "0";
        abismo[1][1] = "5";
        abismo[1][2] = "20";

        return abismo;
    }
    //createInitialBoard's
    @Test
    public void test00_createInitialBoard() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();

        manager.createInitialBoard(creat2Players(), 50);
        manager.createInitialBoard(creat2Players(), 50, creatAbism());
        try{String[][] abismos = creatAbism();
            abismos[0][1] = null;
            manager.createInitialBoard(creat2Players(), 50, abismos);}catch (java.lang.Exception ignored){}
        try{String[][] abismos = creatAbism();
            abismos[0][2] ="400";
            manager.createInitialBoard(creat2Players(), 50, abismos);}catch (java.lang.Exception ignored){}
        try{String[][] abismos = creatAbism();
            abismos[0][0] ="3";
            manager.createInitialBoard(creat2Players(), 50, abismos);}catch (java.lang.Exception ignored){}
        try {manager.createInitialBoard(null, 50, creatAbism());} catch (java.lang.Exception ignored) {}
        try {manager.createInitialBoard(null, 50, creatAbism());} catch (java.lang.Exception ignored) {}
        try{String[][] jogadores = creat2Players();
            jogadores[0][1]="";
            manager.createInitialBoard(jogadores, 50, creatAbism());}catch (java.lang.Exception ignored){}
        try{String[][] jogadores = creat2Players();
            jogadores[0][2]=null;
            manager.createInitialBoard(jogadores, 50, creatAbism());}catch (java.lang.Exception ignored){}
        try{
            String[][] jogadores = new String[1][4];
            jogadores[0][0] = "1";
            jogadores[0][1] = "Joao";
            jogadores[0][2] = "Python;Java";
            jogadores[0][3] = "Purple";


            manager.createInitialBoard(jogadores, 50, creatAbism());}catch (java.lang.Exception ignored){}

    }
    //temCor e temNovoId
    @Test
    public void test01_temCorNovoId(){
        GameManager manager = new GameManager();
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        //(String nome, ArrayList<String> linguagens, int id, ProgrammerColor cor)
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        jogadores.add(new Programmer("João", linguagens, 5, ProgrammerColor.BROWN));
        assertFalse("", manager.temCor("Brown",jogadores));
        assertFalse("", manager.temCor("Red",jogadores));
        jogadores.clear();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        jogadores.add(new Programmer("João", linguagens, 5, ProgrammerColor.PURPLE));
        assertTrue("", manager.temCor("Blue",jogadores));
        assertFalse("",manager.temNovoId("4",jogadores));

    }
    //escolheTrap
    @Test
    public void test02_escolheTrap() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] abismo = new String[11][3];
        abismo[0][0] = "0";
        abismo[0][1] = "1";
        abismo[0][2] = "1";
        assertEquals("","",manager.escolheTrap(0,1,1));
        abismo[1][0] = "0";
        abismo[1][1] = "2";
        abismo[1][2] = "2";
        assertEquals("","",manager.escolheTrap(0,2,2));
        abismo[2][0] = "0";
        abismo[2][1] = "3";
        abismo[2][2] = "3";
        assertEquals("","",manager.escolheTrap(0,3,3));
        abismo[3][0] = "0";
        abismo[3][1] = "4";
        abismo[3][2] = "4";
        assertEquals("","",manager.escolheTrap(0,4,4));
        abismo[4][0] = "0";
        abismo[4][1] = "5";
        abismo[4][2] = "5";
        assertEquals("","",manager.escolheTrap(0,5,5));
        abismo[5][0] = "0";
        abismo[5][1] = "6";
        abismo[5][2] = "6";
        assertEquals("","",manager.escolheTrap(0,6,6));
        abismo[6][0] = "0";
        abismo[6][1] = "7";
        abismo[6][2] = "7";
        assertEquals("","",manager.escolheTrap(0,7,7));
        abismo[7][0] = "0";
        abismo[7][1] = "8";
        abismo[7][2] = "8";
        assertEquals("","",manager.escolheTrap(0,8,8));
        abismo[8][0] = "0";
        abismo[8][1] = "9";
        abismo[8][2] = "9";
        assertEquals("","",manager.escolheTrap(0,9,9));
        abismo[9][0] = "0";
        abismo[9][1] = "10";
        abismo[9][2] = "10";
        assertEquals("","",manager.escolheTrap(0,10,10));
        abismo[10][0] = "0";
        abismo[10][1] = "0";
        abismo[10][2] = "10";
        assertEquals("","",manager.escolheTrap(0,0,10));
        abismo= new String[6][3];
        abismo[0][0] = "1";
        abismo[0][1] = "0";
        abismo[0][2] = "1";
        assertEquals("","",manager.escolheTrap(1,0,1));
        abismo[1][0] = "1";
        abismo[1][1] = "1";
        abismo[1][2] = "2";
        assertEquals("","",manager.escolheTrap(1,1,2));
        abismo[2][0] = "1";
        abismo[2][1] = "2";
        abismo[2][2] = "3";
        assertEquals("","",manager.escolheTrap(1,2,3));
        abismo[3][0] = "1";
        abismo[3][1] = "3";
        abismo[3][2] = "4";
        assertEquals("","",manager.escolheTrap(1,3,4));
        abismo[4][0] = "1";
        abismo[4][1] = "4";
        abismo[4][2] = "5";
        assertEquals("","",manager.escolheTrap(1,4,5));
        abismo[5][0] = "1";
        abismo[5][1] = "5";
        abismo[5][2] = "6";
        assertEquals("","",manager.escolheTrap(1,5,6));


        manager.createInitialBoard(creat2Players(),50,abismo);

        assertNull("",manager.escolheTrap(10,10,2));
    }
    //getImagePng
    @Test
    public void test03_getImagePng() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        manager.createInitialBoard(creat2Players(),50,creatAbism());
        assertNull(manager.getImagePng(56));
        assertNull(manager.getImagePng(-1));
        assertEquals("","Tocha50x50.png",manager.getImagePng(10));
        assertEquals("","saida50x50.png",manager.getImagePng(50));
        assertEquals("","preto50x50.png",manager.getImagePng(1));
    }

    //getProgrammer's
    @Test
    public void test04_getProgrammer() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        jogadores[1][2]="C";
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertEquals("","[1 | Joao | 1 | No tools | Java; Python | Em Jogo, 3 | Ana | 1 | No tools | C | Em Jogo]",manager.getProgrammers(false).toString());
        manager.players.get(0).perdeu();
        assertEquals("","[3 | Ana | 1 | No tools | C | Em Jogo]",manager.getProgrammers(false).toString());
        assertEquals("","[1 | Joao | 1 | No tools | Java; Python | Derrotado, 3 | Ana | 1 | No tools | C | Em Jogo]",manager.getProgrammers(true).toString());


        assertNull("",manager.getProgrammers(10));
        assertNull("",manager.getProgrammers(51));
        assertNull("",manager.getProgrammers(-1));
        assertEquals("","[1 | Joao | 1 | No tools | Java; Python | Derrotado, 3 | Ana | 1 | No tools | C | Em Jogo]",manager.getProgrammers(1).toString());
        manager.players.get(1).setPosicao(10);
        assertEquals("","[3 | Ana | 10 | No tools | C | Em Jogo]",manager.getProgrammers(10).toString());
    }
    //getCurrentPlayerID
    @Test
    public void test05_CurrentPlayer() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());

        assertEquals("",1,manager.getCurrentPlayerID());
        manager.players.get(0).perdeu();
        assertEquals("",3,manager.getCurrentPlayerID());
        manager.players.get(0).defeat=false;
        manager.players.get(1).perdeu();
        manager.turno=1;
        assertEquals("",1,manager.getCurrentPlayerID());
    }
    //moveCurrentPlayer
    @Test
    public void test06_move() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertFalse("",manager.moveCurrentPlayer(10));
        assertFalse("",manager.moveCurrentPlayer(0));
        assertTrue("",manager.moveCurrentPlayer(3));
        manager.nextTurn();
        assertTrue("",manager.moveCurrentPlayer(3));
        manager.players.get(0).setPosicao(49);
        manager.nextTurn();
        assertTrue("",manager.moveCurrentPlayer(6));
        manager.nextTurn();
        assertTrue("",manager.moveCurrentPlayer(6));
    }
    //gameIsOver
    @Test
    public void test07_GameIsOver() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertFalse("",manager.gameIsOver());
        manager.players.get(0).setPosicao(50);
        assertTrue("",manager.gameIsOver());
        manager.players.get(1).perdeu();
        manager.players.get(0).setPosicao(10);
        assertTrue("",manager.gameIsOver());
        manager.players.get(0).addAbismo(new CicloInfinito());
        assertTrue("",manager.gameIsOver());
    }
    //getGameResults
    @Test
    public void test08_getGameResults() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        manager.players.get(0).perdeu();
        manager.gameIsOver();
        assertEquals("","[O GRANDE JOGO DO DEISI, , NR. DE TURNOS, 0, , VENCEDOR, Ana, , RESTANTES, Ana 1, Joao 1]",manager.getGameResults().toString());
        manager.players=null;
        assertNull("",manager.getGameResults());
        manager.players=new ArrayList<>();
        manager.createInitialBoard(jogadores,50,creatAbism());
        manager.players.get(0).perdeu();
        manager.players.get(1).perdeu();
        assertEquals("","[O GRANDE JOGO DO DEISI, , NR. DE TURNOS, 1, , O jogo terminou empatado., , Participantes:, Ana : 1 : Blue Screen of Death, Joao : 1 : Blue Screen of Death]",manager.getGameResults().toString());
        manager.players.get(1).defeat=false;
        manager.players.get(1).addAbismo(new CicloInfinito());
        assertEquals("","[O GRANDE JOGO DO DEISI, , NR. DE TURNOS, 2, , O jogo terminou empatado., , Participantes:, Ana : 1 : Ciclo Infinito, Joao : 1 : Blue Screen of Death]",manager.getGameResults().toString());
        manager.players=null;
        assertNull("",manager.getGameResults());
    }

    //getAuthorsPanel
    @Test
    public void test09_getAuthorsPanel(){
        GameManager manager = new GameManager();
        assertEquals("","javax.swing.JPanel[,0,0,0x0,invalid,layout=java.awt.FlowLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]",manager.getAuthorsPanel().toString());
    }

    //getProgrammersInfo
    @Test
    public void test10_getProgrammersInfo() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertEquals("","Joao : No tools | Ana : No tools",manager.getProgrammersInfo());
        manager.players.get(0).addFerramenta(new Heranca());
        manager.players.get(0).addFerramenta(new AjudaProfessor());
        assertEquals("","Joao : Herança;Ajuda do Professor | Ana : No tools",manager.getProgrammersInfo());
    }
    //getTitle
    @Test
    public void test11_getTitle() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertNull("",manager.getTitle(-10));
        assertNull("",manager.getTitle(52));
        assertNull("",manager.getTitle(11));
        assertEquals("","Tratamento de Excepções",manager.getTitle(10));
    }
    //reactToAbyssOrTool
    @Test
    public void test12_reactToAbyssOrTool() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertNull("",manager.reactToAbyssOrTool());
        manager.players.get(1).setPosicao(10);
        assertEquals("","Hm!? Uma tocha? É melhor guardares.",manager.reactToAbyssOrTool());

    }
    //saveGame e loadGame
    @Test
    public void test13_saveLoadGame() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        File fp = new File("file.txt");
        assertTrue("",manager.saveGame(fp));
        manager.players.get(0).addAbismo(new ErroLogica());
        assertTrue("",manager.saveGame(fp));
        File fp1 = new File("filename.txt");
        assertTrue("",manager.saveGame(fp1));
        fp1=new File("filename");
        assertFalse("",manager.saveGame(fp1));


        assertTrue("",manager.loadGame(fp));
        File fp2=new File("erro.txt");
        assertFalse("",manager.loadGame(fp2));
        fp2=new File("naoExiste.txt");
        assertFalse("",manager.loadGame(fp2));
    }

    //addAbismo
    @Test
    public void test14_addAbismo() throws InvalidInitialBoardException {
        GameManager manager = new GameManager();
        String[][] jogadores = creat2Players();
        manager.createInitialBoard(jogadores,50,creatAbism());
        assertFalse("",manager.addAbismo(1,10));
        assertTrue("",manager.addAbismo(1,11));
    }
}
