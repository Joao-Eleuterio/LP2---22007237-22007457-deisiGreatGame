package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class GameManager {
    int turno;
    int tamanhoTab;
    int nrTurnos = 1;
    Programmer vencedor;
    List<Programmer> players = new ArrayList<>();
    HashMap<Integer, Trap> abismos = new HashMap<>();
    int nrSpaces = 0;
    HashMap<Integer,Integer> posicoesPisadas= new HashMap<>();
    HashMap<String,Integer> abismosPisados= new HashMap<>();
    public GameManager() {
    }

    //cria e faz o tratamento de dados dos players
    public void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        createInitialBoard(playerInfo,worldSize,null);
    }


    public boolean temCor(String cor, ArrayList<Programmer> programadores) {
        switch (cor) {
            case "Purple", "Green", "Brown", "Blue" -> {
                for (Programmer programmer : programadores) {
                    if (cor.equals(programmer.cor.nome)) {
                        return false;
                    }
                }
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean temNovoId(String id, ArrayList<Programmer> programadores) {
        for (Programmer programmer : programadores) {
            if (Integer.parseInt(id) == programmer.id) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> linguagens(String linguagens) {
        String[] linguagem = linguagens.split(";");
        return  List.of(linguagem).get(0)==null || List.of(linguagem).get(0).equals("null") ? null : new ArrayList<>(List.of(linguagem));
    }

    //cria e faz tratamento de dados das traps
    public void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools)throws InvalidInitialBoardException {
        boolean abismo, dentroTab;
        players.clear();
        nrTurnos = 0;
        turno = 0;
        vencedor = null;
        abismos.clear();

        if (playerInfo == null) {
            throw new InvalidInitialBoardException("playerInfo é null");
        }
        if (worldSize >= playerInfo.length * 2) {
            this.tamanhoTab = worldSize;
        }
        if(abyssesAndTools!=null){
            for (String[] abyssesAndTool : abyssesAndTools) {
                if (abyssesAndTool[0].equals("0")) {
                    abismo = Integer.parseInt(abyssesAndTool[1]) >= 0 && (Integer.parseInt(abyssesAndTool[1])) <= 9;
                } else {
                    abismo = Integer.parseInt(abyssesAndTool[1]) >= 0 && (Integer.parseInt(abyssesAndTool[1])) <= 5;
                }
                dentroTab = Integer.parseInt(abyssesAndTool[2]) > 0 && Integer.parseInt(abyssesAndTool[2]) <= tamanhoTab;
                if (!((abyssesAndTool[0].equals("0") || abyssesAndTool[0].equals("1")) && abismo && dentroTab)) {
                    throw new InvalidInitialBoardException("erro");
                } else {
                    escolheTrap(Integer.parseInt(abyssesAndTool[0]), Integer.parseInt(abyssesAndTool[1]), Integer.parseInt(abyssesAndTool[2]));
                }
            }
        }
        ArrayList<Programmer> a = new ArrayList<>();
        for (String[] strings : playerInfo) {
            if (strings[1] == null || strings[1].equals("") || !temCor(strings[3], a) || !temNovoId(strings[0], a) || !((playerInfo.length * 2) <= worldSize)) {
                throw new InvalidInitialBoardException("erro");
            }
            ArrayList<String> linguagensDeProgramacao = linguagens(String.valueOf(strings[2]));
            if(linguagensDeProgramacao==null || linguagensDeProgramacao.size() == 0){
                throw new InvalidInitialBoardException("Sem linguagens de Programacao");
            }
            a.add(new Programmer(strings[1],linguagensDeProgramacao , Integer.parseInt(String.valueOf(strings[0])), ProgrammerColor.getColor(strings[3])));
        }
        a.sort(Comparator.comparingInt(Programmer::getId));
        players.addAll(a);

        //se tiver os players
        if(players.size()>=2 && players.size()<5){
            return;
        }
        throw new InvalidInitialBoardException("players invalidos");
    }

    public String escolheTrap(int idTrap, int id, int pos) {
        Trap trap = null;
        switch (idTrap) {
            case 0:
                switch (id) {
                    case 0 -> trap = new ErroSintaxe();
                    case 1 -> trap = new ErroLogica();
                    case 2 -> trap = new Exception();
                    case 3 -> trap = new FileNotFoundException();
                    case 4 -> trap = new Crash();
                    case 5 -> trap = new DuplicatedCode();
                    case 6 -> trap = new EfeitosSecundarios();
                    case 7 -> trap = new BlueScreenOfDeath();
                    case 8 -> trap = new CicloInfinito();
                    case 9 -> trap = new SegmentationFault();
                }
                break;
            case 1:
                switch (id) {
                    case 0 -> trap = new Heranca();
                    case 1 -> trap = new ProgramacaoFuncional();
                    case 2 -> trap = new JUnit();
                    case 3 -> trap = new TratamentoExcepcoes();
                    case 4 -> trap = new IDE();
                    case 5 -> trap = new AjudaProfessor();
                }break;
            default:return null;
        }
        abismos.put(pos, trap);
        abismosPisados.put(trap.titulo,0 );
        return "";
    }

    public String getImagePng(int position) {
        //position seja invalido retorna null
        if (position > tamanhoTab || position <= 0) {
            return null;
        }
        //retorna imagem 50x50 glory.png
        if (position == tamanhoTab) {
            return "glory.png";
        }
        if (abismos.containsKey(position)) {
            return abismos.get(position).getImage();
        }

        return null;

    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        ArrayList<Programmer> a = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            //includeDefeated = true acumula | includeDefeated= false nao adiciona
            if (players.get(i).getDefeat() && includeDefeated) {// os Fora de Jogo
                a.add(players.get(i));
            }
            if (!players.get(i).getDefeat()) {// os Em Jogo
                a.add(players.get(i));
            }
        }
        return a;
    }

    public List<Programmer> getProgrammers(int position) {
        ArrayList<Programmer> programmers = new ArrayList<>();
        boolean ocupado = false;
        if (position > tamanhoTab) {
            return null;
        } else {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getPosicao() == position) {
                    programmers.add(players.get(i));
                    ocupado = true;
                }
            }
        }
        if (!ocupado) {
            return null;
        }
        return programmers;
    }

    public int getCurrentPlayerID() {
        if (players.get(turno).getDefeat()) {
            for (int i = turno; i < players.size(); ) {

                if (!players.get(i).getDefeat()) {
                    turno = i;
                    return players.get(i).getId();
                }
                if (i == players.size() - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }

        }
        return players.get(turno).getId();
    }

    public boolean moveCurrentPlayer(int nrSpaces) {
        if (nrSpaces < 1 || nrSpaces > 6 || players.get(turno).getCicloIfinito()) {
            return false;
        }
            if ((players.get(turno).getPosicao() + nrSpaces) <= tamanhoTab) {
                    players.get(turno).andar(nrSpaces);
            } else {
                players.get(turno).setPosicao(tamanhoTab + (tamanhoTab - players.get(turno).getPosicao() - nrSpaces));
            }
            if(posicoesPisadas.containsKey(players.get(turno).getPosicao())){
                posicoesPisadas.put(players.get(turno).getPosicao(),(posicoesPisadas.get(players.get(turno).getPosicao())+1));
            }else{
                posicoesPisadas.put(players.get(turno).getPosicao(),1);
            }
            if(abismos.containsKey(players.get(turno).getPosicao()) && abismosPisados.containsKey(abismos.get(players.get(turno).getPosicao()).titulo)){
                abismosPisados.put(String.valueOf(abismos.get(players.get(turno).getPosicao()).titulo),(abismosPisados.get(abismos.get(players.get(turno).getPosicao()).titulo))+1);
            }
            this.nrSpaces=nrSpaces;
        return true;
    }

    public void nextTurn() {
        nrTurnos++;
        if (turno == players.size() - 1) {
            turno = 0;
        } else {
            turno++;
        }
    }

    public boolean gameIsOver() {
        int emJogo = 0;
        Programmer winner = null;
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).getDefeat()) {
                emJogo++;
                winner = players.get(i);
            }
        }
        if (emJogo == 1) {
            vencedor = winner;
            return true;
        }


        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).posicao == tamanhoTab) {
                vencedor = players.get(i);
                nextTurn();
                return true;
            }
        }
        return false;
    }

    public List<String> getGameResults() {
        ArrayList<String> strings = new ArrayList<>();
        if (vencedor != null) {

            strings.add("O GRANDE JOGO DO DEISI");
            strings.add("");
            strings.add("NR. DE TURNOS");
            strings.add("" + nrTurnos);
            strings.add("");
            strings.add("VENCEDOR");
            strings.add("" + vencedor.getName());
            strings.add("");
            strings.add("RESTANTES");
            if (players == null) {
                return null;
            }
            Collection<Programmer> values = players;
            ArrayList<Programmer> organizado = new ArrayList<>(values);

            organizado.sort((p1, p2) -> {
                if (p1.getPosicao() < p2.getPosicao()) {
                    return -1;
                } else if (p1.getPosicao() > p2.getPosicao()) {
                    return 1;
                } else {
                    return p1.getName().compareTo(p2.getName());
                }
            });
            organizado.sort(Comparator.comparingInt(Programmer::getPosicao).reversed());
            for (Programmer programmer : organizado) {
                if (programmer.getPosicao() != tamanhoTab) {
                    strings.add(programmer.getName() + " " + programmer.getPosicao());
                }
            }
        }
        return strings;
    }

    public JPanel getAuthorsPanel() {
        JPanel a = new JPanel();
        JTextArea text = new JTextArea();
        text.setText("                           DeisiGreatGame\n\nProgramadores: João Eleutério\n                               Mário Silva" +
                "\n\nProfessores:   Pedro Alves\n                          Lúcio Studer\n                           Bruno Cipriano\n\n\n\n\n" +
                "\n\n\n\n                                                                    © 2021 DEISI");

        text.setSize(100, 100);
        text.setEnabled(false);
        text.setBackground(a.getBackground());
        text.setDisabledTextColor(Color.BLACK);
        a.add(text);

        return a;
    }

    public String getProgrammersInfo() {
        StringBuilder txt = new StringBuilder();

        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).getDefeat()) {
                txt.append(players.get(i).getName()).append(" : ");
                if (players.get(i).ferramentas == null || players.get(i).ferramentas.size() == 0) {
                    txt.append("No tools");
                }
                for (int j = 0; j < players.get(i).ferramentas.size(); j++) {

                    if (j == 0) {
                        txt.append(players.get(i).ferramentas.get(j).getTitulo());
                    } else {
                        txt.append(";").append(players.get(i).ferramentas.get(j).getTitulo());
                    }
                }
                if (!(i == players.size() - 1)) {
                    txt.append(" | ");
                }
            }
        }

        return txt.toString();
    }

    public String getTitle(int position) {
        if (position > 0 && position <= tamanhoTab && abismos.containsKey(position)) {
            return abismos.get(position).getTitulo();
        } else {
            return null;
        }
    }

    public String reactToAbyssOrTool() {
        if (abismos.containsKey(players.get(turno).getPosicao())) {
            Trap trap= abismos.get(players.get(turno).getPosicao());
            String txt = "Caiu " + trap.titulo + "! " + trap.getConsequencia();
            players.get(turno).addAbismo(abismos.get(players.get(turno).getPosicao()));
            trap.consequencia((ArrayList<Programmer>) players,nrSpaces,turno);
            nextTurn();
            return txt;
        }
        nextTurn();
        return null;
    }


    public boolean saveGame(File file) {
        //worldSize
        //turno em que esta -/- turnos
        //abyssesAndTools
        //playerInfo     //player    ->  nome / posicao / ferramentas / abismo /...
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(tamanhoTab);
                printWriter.println(turno + ";" + nrTurnos);
                for (int i = 0;abismos!=null && i < tamanhoTab; i++) {
                    if (abismos.containsKey(i) ) {
                        printWriter.println(i + ";" + abismos.get(i).abismoFerramenta() + ";" + abismos.get(i).getId());
                    }
                }
                for (int i = 0; players != null && i < players.size(); i++) {

                    StringBuilder abismo = new StringBuilder();
                    if (players.get(i).getAbismo() == null) {
                        abismo = new StringBuilder("null");
                    } else {
                        abismo.append(players.get(i).getAbismo().getId()).append(" ").append(players.get(i).getAbismo().abismoFerramenta());
                    }
                    printWriter.println(players.get(i).getName() + ";" + players.get(i).getLinguagens() + ";" + players.get(i).getId() + ";"
                            + players.get(i).getColor() + ";" + players.get(i).getPosicao() + ";"
                            + players.get(i).getDefeat() + ";" + abismo + ";" + players.get(i).getFerramentas() + ";" + players.get(i).getCasa());
                }
            }catch (java.lang.Exception c){
                return false;
            }
            printWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadGame(File file){
        int linha=0,playerTurno=0;
        try {
            Scanner myReader = new Scanner(file);
            try {
                abismos.clear();
                players.clear();
                tamanhoTab=0;
                turno=0;
                nrTurnos=0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] linhas = data.split(";");
                    switch (linha) {
                        case 0 -> {
                            try {
                                tamanhoTab = Integer.parseInt(linhas[0]);
                                linha++;continue;
                            } catch (java.lang.Exception c) {
                                return false;
                            }
                        }
                        case 1 -> {
                            try {
                                turno = Integer.parseInt(linhas[0]);
                                nrTurnos = Integer.parseInt(linhas[1]);
                                linha++;continue;
                            } catch (java.lang.Exception c) {
                                return false;
                            }
                        }
                        default -> {
                            try {
                                if (linhas.length == 3) {
                                    try {
                                       if(escolheTrap(Integer.parseInt(linhas[1]), Integer.parseInt(linhas[2]), Integer.parseInt(linhas[0]))==null){
                                           return false;
                                       }
                                    } catch (java.lang.Exception c) {
                                        return false;
                                    }
                                } else if (linhas.length == 9) {

                                    players.add(new Programmer(linhas[0], linhas[1], linhas[2], linhas[3], linhas[4], linhas[5], linhas[6], linhas[7], linhas[8]));
                                    playerTurno++;
                                }
                            } catch (java.lang.Exception c) {
                                return false;
                            }
                        }
                    }
                    linha++;
                }
            }catch (java.lang.Exception c){
                return false;
            }myReader.close();
            return true;
        } catch (java.io.FileNotFoundException e) {
            return false;
        }
    }

    public boolean addAbismo(int idTrap,int pos){
        if(abismos.containsKey(pos)){
            return false;}else{
           escolheTrap(0,idTrap,pos);
           return true;
        }
    }


}


