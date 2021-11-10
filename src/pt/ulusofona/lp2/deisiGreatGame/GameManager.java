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

    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        players.clear();
        nrTurnos = 0;
        turno = 0;
        vencedor = null;
        if (playerInfo == null) {
            return false;
        }
        ArrayList<Programmer> a = new ArrayList<>();
        if (boardSize >= playerInfo.length * 2) {
            this.tamanhoTab = boardSize;
        }

        for (String[] strings : playerInfo) {
            if (strings[1] == null || strings[1].equals("") || !temCor(strings[3],a) || !temNovoId(strings[0],a) || !((playerInfo.length * 2) <= boardSize)) {
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

    public boolean temCor(String cor,ArrayList<Programmer> a) {
        switch (cor) {
            case "Purple", "Green", "Brown", "Blue" -> {
                for (Programmer programmer : a) {
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
    public boolean temNovoId(String id,ArrayList<Programmer> a) {
        for (Programmer programmer : a) {
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

    public String getImagePng(int position) {
        //position seja invalido retorna null
        if (position > tamanhoTab) {
            return null;
            //retorna imagem 50x50 glory.png
        } else if (position == tamanhoTab) {
            return "glory.png";
        }
        //position seja invalido retorna null
        return null;
    }

    public ArrayList<Programmer> getProgrammers() {
        ArrayList<Programmer> a = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            a.add(players.get(i));
        }
        return a;
    }

    public ArrayList<Programmer> getProgrammers(int position) {
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
        return players.get(turno).getId();
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }

        switch (turno) {
            case 0 -> {
                if (players.get(0).posicao + nrPositions <= tamanhoTab) {
                    players.get(0).posicao += nrPositions;
                } else {
                    players.get(0).posicao = tamanhoTab + (tamanhoTab - players.get(0).posicao - nrPositions);
                }
            }
            case 1 -> {
                if (players.get(1).posicao + nrPositions <= tamanhoTab) {
                    players.get(1).posicao += nrPositions;
                } else {
                    players.get(1).posicao = tamanhoTab + (tamanhoTab - players.get(1).posicao - nrPositions);
                }
            }
            case 2 -> {
                if (players.get(2).posicao + nrPositions <= tamanhoTab) {
                    players.get(2).posicao += nrPositions;
                } else {
                    players.get(2).posicao = tamanhoTab + (tamanhoTab - players.get(2).posicao - nrPositions);
                }
            }
            case 3 -> {
                if (players.get(3).posicao + nrPositions <= tamanhoTab) {
                    players.get(3).posicao += nrPositions;
                } else {
                    players.get(3).posicao = tamanhoTab + (tamanhoTab - players.get(3).posicao - nrPositions);
                }
            }
        }
        nextTurn();
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
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).posicao == tamanhoTab) {
                vencedor = players.get(i);
                nextTurn();
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getGameResults() {
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

        for (Programmer programmer : organizado) {
            if (programmer.posicao != tamanhoTab) {
                strings.add(programmer.nome + " " + programmer.posicao);
            }
        }
        return strings;
    }

    public JPanel getAuthorsPanel() {
        JPanel a = new JPanel();
        a.setSize(new Dimension(300, 300));
        JLabel autores = new JLabel("Autores: ");
        autores.setVerticalAlignment(SwingConstants.CENTER);
        autores.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        a.add(autores);
        JLabel nomes = new JLabel("João Eleutério        Mário Silva");
        nomes.setVerticalAlignment(SwingConstants.CENTER);
        nomes.setHorizontalAlignment(SwingConstants.CENTER);
        a.add(nomes);
        JLabel profs1 = new JLabel("Professores:");
        profs1.setVerticalAlignment(SwingConstants.CENTER);
        profs1.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        a.add(profs1);
        JLabel profs2 = new JLabel("Pedro Alves");
        JLabel prof = new JLabel("         Lúcio Studer         Bruno Cipriano");
        profs2.setHorizontalAlignment(SwingConstants.CENTER);
        profs2.setVerticalAlignment(SwingConstants.CENTER);
        a.add(profs2);
        prof.setHorizontalAlignment(SwingConstants.CENTER);
        prof.setVerticalAlignment(SwingConstants.CENTER);
        a.add(prof);
        JLabel space = new JLabel();
        space.setText("        ");
        a.add(space);
        JLabel space2 = new JLabel();
        space2.setText("                                     " );
        a.add(space2);
        JLabel copyright = new JLabel("                                      © 2021 DEISI");
        a.add(copyright);
        return a;
    }


}
