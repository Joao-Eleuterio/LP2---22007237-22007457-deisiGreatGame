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
    HashMap<Integer, Trap> traps = new HashMap<>();

    public GameManager() {
    }


    boolean createInitialBoard(String[][] playerInfo, int worldSize) {
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
        }

//se tiver os players certos
        return players.size() > 1 && players.size() < 5;
    }

    boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        boolean abismo, dentroTab;
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
                    traps.put(Integer.valueOf(abyssesAndTool[2]),new Abismo(Integer.parseInt(abyssesAndTool[1])));
                } else {
                    traps.put(Integer.valueOf(abyssesAndTool[2]),new Ferramenta(Integer.parseInt(abyssesAndTool[1])));
                }
            }
        }
        return createInitialBoard(playerInfo, worldSize);
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

    String getImagePng(int position) {
        //position seja invalido retorna null

            //retorna imagem 50x50 glory.png
         if (position == tamanhoTab) {
             return "glory.png";
         }
         //position seja invalido retorna null ou entao a imagem
         return traps.get(position).getImage();


    }

    List<Programmer> getProgrammers(boolean includeDefeated) {
        ArrayList<pt.ulusofona.lp2.deisiGreatGame.Programmer> a = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getDefeat() && includeDefeated){
                a.add(players.get(i));
            }
            if(!players.get(i).getDefeat()){
                a.add(players.get(i));
            }

        }
        return a;
    }

    List<Programmer> getProgrammers(int position) {
        ArrayList<pt.ulusofona.lp2.deisiGreatGame.Programmer> programmers = new ArrayList<>();
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

    int getCurrentPlayerID() {
        return players.get(turno).getId();
    }

    //TODO PARTE DE NAO CONSEGUIR ANDAR
    //O jogador atual está impossibilitado de se mover (por ex., por ter caído num ciclo infinito)
    boolean moveCurrentPlayer(int nrSpaces) {
        if (nrSpaces < 1 || nrSpaces > 6) {
            return false;
        }

        switch (turno) {
            case 0 -> {
                if (players.get(0).posicao + nrSpaces <= tamanhoTab) {
                    players.get(0).posicao += nrSpaces;
                } else {
                    players.get(0).posicao = tamanhoTab + (tamanhoTab - players.get(0).posicao - nrSpaces);
                }
            }
            case 1 -> {
                if (players.get(1).posicao + nrSpaces <= tamanhoTab) {
                    players.get(1).posicao += nrSpaces;
                } else {
                    players.get(1).posicao = tamanhoTab + (tamanhoTab - players.get(1).posicao - nrSpaces);
                }
            }
            case 2 -> {
                if (players.get(2).posicao + nrSpaces <= tamanhoTab) {
                    players.get(2).posicao += nrSpaces;
                } else {
                    players.get(2).posicao = tamanhoTab + (tamanhoTab - players.get(2).posicao - nrSpaces);
                }
            }
            case 3 -> {
                if (players.get(3).posicao + nrSpaces <= tamanhoTab) {
                    players.get(3).posicao += nrSpaces;
                } else {
                    players.get(3).posicao = tamanhoTab + (tamanhoTab - players.get(3).posicao - nrSpaces );
                }
            }
        }
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

    boolean gameIsOver() {
        if (players.size() == 1) {
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

    List<String> getGameResults() {
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
        Collection<pt.ulusofona.lp2.deisiGreatGame.Programmer> values = players.values();
        ArrayList<pt.ulusofona.lp2.deisiGreatGame.Programmer> organizado = new ArrayList<>(values);
        organizado.sort(Comparator.comparingInt((pt.ulusofona.lp2.deisiGreatGame.Programmer b) -> b.posicao).reversed());

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

    //TODO Devolve uma String com um resumo da situação dos jogadores relativamente às
    //ferramentas que possuem.
    //A String deve ter o seguinte formato:
    //<INFO_JOGADOR_1> | <INFO_JOGADOR_2> | …
    //em que cada INFO_JOGADOR é:
    //<NOME_JOGADOR> : <DESCR_FERRAMENTA_1>;<DESCR_FERRAMENTA_2>;...
    //Caso o jogador não tenha ferramentas, deve ficar <NOME_JOGADOR> : No tools
    //Os jogadores devem estar ordenados por ID
    //Exemplo completo: Joshua Bloch : No tools | Ada Lovelace: Herança;Testes unitários
    String getProgrammersInfo() {
        return "";
    }

    String getTitle(int position) {
       if(position>0 && position<=tamanhoTab){
            return traps.get(position).titulo;
       }else{
           return null;
       }
    }


    //TODO "Ativa" uma possível reação do jogador atual à casa onde está atualmente.
    //Retorna uma mensagem explicativa se a casa é um abismo ou ferramenta. Caso contrário retorna null.
    // (ex:“Caiu num loop infinito! Irá ficar aqui retido até aparecer outro programador…”)
    // O efeito da reação poderá ser sobre o próprio jogador e/ou sobre a sua posição no tabuleiro
    String reactToAbyssOrTool() {
        nextTurn();
        return ";";
    }
}
