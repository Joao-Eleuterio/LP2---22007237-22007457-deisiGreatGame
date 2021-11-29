package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameManager {
    int turno;
    HashMap<Integer, Programmer> players = new HashMap<>();
    int tamanhoTab;
    int nrTurnos = 1;
    Programmer vencedor;
    HashMap<Integer, Trap> abismos = new HashMap<>();

    public GameManager() {
    }

    //cria e faz o tratamento de dados dos players

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {
        players.clear();
        nrTurnos = 0;
        turno = 0;
        vencedor = null;
        if (playerInfo == null) {
            return false;
        }
        ArrayList<Programmer> a = new ArrayList<>();
        if (worldSize >= playerInfo.length * 2) {
            this.tamanhoTab = worldSize;
        }
        for (String[] strings : playerInfo) {
            if (strings[1] == null || strings[1].equals("") || !temCor(strings[3], a) || !temNovoId(strings[0], a) || !((playerInfo.length * 2) <= worldSize)) {
                return false;
            }
            a.add(new Programmer(strings[1], linguagens(String.valueOf(strings[2])), Integer.parseInt(String.valueOf(strings[0])), ProgrammerColor.getColor(strings[3])));
        }
        a.sort(Comparator.comparingInt(Programmer::getId));
        for (int i = 0; i < a.size(); i++) {
            players.put(i, a.get(i));
            players.get(i).casas.add(1);
        }
        //se tiver os players certos
        return players.size() > 1 && players.size() < 5;
    }

    public boolean temCor(String cor, ArrayList<Programmer> programadores) {
        switch (cor) {
            case "Purple", "Green", "Brown", "Blue" -> {
                for (pt.ulusofona.lp2.deisiGreatGame.Programmer programmer : programadores) {
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
        for (pt.ulusofona.lp2.deisiGreatGame.Programmer programmer : programadores) {
            if (Integer.parseInt(id) == programmer.id) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> linguagens(String linguagens) {
        String[] linguagem = linguagens.split(";");
        return new ArrayList<String>(List.of(linguagem));
    }

    //cria e faz tratamento de dados das traps
    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {

        boolean abismo, dentroTab, inicialboard = createInitialBoard(playerInfo, worldSize);
        for (String[] abyssesAndTool : abyssesAndTools) {
            if (abyssesAndTool[0].equals("0")) {
                abismo = Integer.parseInt(abyssesAndTool[1]) >= 0 && (Integer.parseInt(abyssesAndTool[1])) <= 9;
            } else {
                abismo = Integer.parseInt(abyssesAndTool[1]) >= 0 && (Integer.parseInt(abyssesAndTool[1])) <= 5;
            }
            dentroTab = Integer.parseInt(abyssesAndTool[2]) > 0 && Integer.parseInt(abyssesAndTool[2]) <= tamanhoTab;
            if (!((abyssesAndTool[0].equals("0") || abyssesAndTool[0].equals("1")) && abismo && dentroTab)) {
                return false;
            } else {
                if (abyssesAndTool[0].equals("0")) {
                    abismos.put(Integer.valueOf(abyssesAndTool[2]), new Abismo(Integer.parseInt(abyssesAndTool[1])));
                } else {
                    abismos.put(Integer.valueOf(abyssesAndTool[2]), new Ferramenta(Integer.parseInt(abyssesAndTool[1])));
                }
            }
        }
        if (playerInfo == null) {
            return false;
        }

        abismos.put(5, new Abismo(7));

        return inicialboard;
    }


    //FUNCAO CRIADA PARA VERIFICAR SE TEM COR VALIDA
    public boolean corValida(String corDoPlayer) {
        switch (corDoPlayer) {
            case "PURPLE", "BLUE", "GREEN", "BROWN" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
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
        ArrayList<pt.ulusofona.lp2.deisiGreatGame.Programmer> a = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getDefeat() && includeDefeated) {
                a.add(players.get(i));
            }
            if (!players.get(i).getDefeat()) {
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
                if (players.get(i).posicao == position) {
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
        if(players.get(turno).getDefeat()){
            for(int i= turno;i<players.size();){

                if(!players.get(i).getDefeat()){
                    turno=i;
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

    //TODO PARTE DE NAO CONSEGUIR ANDAR
    //O jogador atual está impossibilitado de se mover (por ex., por ter caído num ciclo infinito)
    public boolean moveCurrentPlayer(int nrSpaces) {

        if (nrSpaces < 1 || nrSpaces > 6 || players.get(turno).defeat) {
            return false;
        }
        mover(nrSpaces, turno);

        return true;
    }

    public void mover(int nrSpaces, int turno) {

        if (players.get(turno).getDefeat()) {
            nextTurn();
            return;
        }
        if (players.get(turno).abismo == null) {
            if (players.get(turno).posicao + nrSpaces <= tamanhoTab) {
                players.get(turno).posicao += nrSpaces;
            } else {
                players.get(turno).posicao = tamanhoTab + (tamanhoTab - players.get(0).posicao - nrSpaces);
            }
        }
        players.get(turno).casas.add(players.get(turno).getPosicao());
        if (abismos.containsKey(players.get(turno).getPosicao()) && !players.get(turno).consequencias(abismos.get(players.get(turno).getPosicao()), nrSpaces)) {
            if (abismos.get(players.get(turno).getPosicao()).titulo.equals("Ciclo infinito")) {
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getPosicao() == players.get(turno).getPosicao() && players.get(i) != players.get(turno)) {
                        players.get(i).abismo = null;
                    }
                }
                players.get(turno).cicloInfinito();
                players.get(turno).abismo = (Abismo) abismos.get(players.get(turno).getPosicao());

            } else if (abismos.get(players.get(turno).getPosicao()).titulo.equals("Segmentation Fault")) {
                int posicaoAbismo = players.get(turno).getPosicao();
                for (int i = 0, j = 0; i < players.size(); i++) {
                    if (players.get(i).getPosicao() == posicaoAbismo) {
                        j++;
                    }
                    if (j >= 3) {
                        for (int h = 0; h < players.size(); h++) {
                            if (players.get(h).getPosicao() == posicaoAbismo) {
                                players.get(h).posicao -= 3;
                            }
                        }
                        return;
                    }
                }

            }
        }

    }

    public void nextTurn() {
        System.out.println(getProgrammersInfo());
        nrTurnos++;
        if (turno == players.size() - 1) {
            turno = 0;
        } else {
            turno++;
        }
    }

    public boolean gameIsOver() {
        int emJogo=0;
        Programmer winner=null;
            for(int i=0;i<players.size();i++){
                if(!players.get(i).getDefeat()){
                    emJogo++;
                    winner=players.get(i);
                }
            }
            if(emJogo==1){
               vencedor=winner;
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
        strings.add("O GRANDE JOGO DO DEISI");
        strings.add("");
        strings.add("NR. DE TURNOS");
        strings.add("" + nrTurnos);
        strings.add("");
        strings.add("VENCEDOR");
        strings.add("" + vencedor.nome);
        strings.add("");
        strings.add("RESTANTES");
        if (players == null) {
            return null;
        }
        Collection<Programmer> values = players.values();
        ArrayList<Programmer> organizado = new ArrayList<>(values);
        organizado.sort(Comparator.comparingInt((Programmer b) -> b.posicao).reversed());

        for (pt.ulusofona.lp2.deisiGreatGame.Programmer programmer : organizado) {
            if (programmer.posicao != tamanhoTab) {
                strings.add(programmer.nome + " " + programmer.posicao);
            }
        }
        return strings;
    }

    public JPanel getAuthorsPanel() {
        JPanel a = new JPanel();
        JTextArea text = new JTextArea();

        text.setText("""
                                                 DeisiGreatGame
                                                 
                Programadores: João Eleutério
                                               Mário Silva
                               
                Professores:   Pedro Alves
                                           Lúcio Studer
                                           Bruno Cipriano
                                
                                
                                
                                
                              
                             
                                                                                    © 2021 DEISI
                """);
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
            txt.append(players.get(i).nome).append(" : ");
            if (players.get(i).ferramentas.size() == 0) {
                txt.append("No tools");
            }
            for (int j = 0; j < players.get(i).ferramentas.size(); j++) {

                if (j == 0) {
                    txt.append(players.get(i).ferramentas.get(j).titulo);
                } else {
                    txt.append(";").append(players.get(i).ferramentas.get(j).titulo);
                }
            }
            if (!(i == players.size() - 1)) {
                txt.append(" | ");
            }
        }

        return txt.toString();
    }

    public String getTitle(int position) {
        if (position > 0 && position <= tamanhoTab && abismos.containsKey(position)) {
            return abismos.get(position).titulo;
        } else {
            return null;
        }
    }

    public String reactToAbyssOrTool() {
        String txt = "";
        if (abismos.containsKey(players.get(turno).getPosicao())) {
            txt = "Caiu " + abismos.get(players.get(turno).getPosicao()).titulo + "! " + abismos.get(players.get(turno).getPosicao()).getConsequencia();
            nextTurn();
            return txt;
        }
        nextTurn();
        return null;
    }
}


