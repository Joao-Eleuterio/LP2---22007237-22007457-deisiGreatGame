package pt.ulusofona.lp2.deisiGreatGame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();

        try {
            List<String> a=new ArrayList<>();
            a.add("Player");
            a.add("João");
            manager.createInitialBoard(creat4Players(),50,abyssesAndTools());
            System.out.println(FunctionsKt.getPlayer(manager,a));
            List<String> b=new ArrayList<>();
            b.add("Player");
            b.add("Java");
            manager.moveCurrentPlayer(2);
            manager.nextTurn();
            manager.moveCurrentPlayer(2);
            manager.nextTurn();
            manager.moveCurrentPlayer(5);
            manager.nextTurn();
            manager.moveCurrentPlayer(1);
            System.out.println(FunctionsKt.getPlayersByLanguage(manager,b));
            System.out.println(FunctionsKt.getPolyglots(manager,b));
            System.out.println(FunctionsKt.getMostUsedPositions(manager,b));
            System.out.println(FunctionsKt.getMostUsedAbysses(manager,b));
        } catch (InvalidInitialBoardException e) {
            e.printStackTrace();
        }




    }
    public static String[][] creat4PlayersExtra() {
        String[][] jogadores = new String[4][4];
        jogadores[0][0] = "19";
        jogadores[0][1] = "kjjjjjj";
        jogadores[0][2] = "Java;Python";
        jogadores[0][3] = "PuAAAA";

        jogadores[1][0] = "10";
        jogadores[1][1] = "aaaaaaaa";
        jogadores[1][2] = "C;Java";
        jogadores[1][3] = "Green";

        jogadores[2][0] = "2";
        jogadores[2][1] = "iiiiiiii";
        jogadores[2][2] = "Python;AA";
        jogadores[2][3] = "Blue";

        jogadores[3][0] = "99";
        jogadores[3][1] = "Carlos";
        jogadores[3][2] = "C";
        jogadores[3][3] = "Brown";

        return jogadores;
    }
    public static String[][] creat4Players() {
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
        jogadores[3][2] = "C;Java;Python";
        jogadores[3][3] = "Brown";

        return jogadores;
    }
    public static String [] [] abyssesAndTools(){
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
}
