package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameManager {
    int turno;
    HashMap<Integer, Programmer> players = new HashMap<>();
    int tamanhoTab;
    int nrTurnos = 0;
    Programmer vencedor;

    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        if (playerInfo == null) {
            return false;
        }
        ArrayList<Programmer> a = new ArrayList<>();
        this.tamanhoTab = boardSize;

        for (String[] strings : playerInfo) {
            if (strings[1] == null || strings[1].equals("") || !temCor(strings[3]) || !temNovoId(strings[0]) || !((playerInfo.length * 2) <= boardSize)) {
                return false;
            }
            a.add(new Programmer(strings[1], linguagens(String.valueOf(strings[2])), Integer.parseInt(String.valueOf(strings[0])), ProgrammerColor.getColor(strings[3])));
        }
        a.sort(Comparator.comparingInt(Programmer::getId));
        for (int i = 0; i < a.size(); i++) {
            players.put(i, a.get(i));
        }

        return players.size() > 1 && players.size() < 5;
    }

    public boolean temCor(String cor) {
        switch (cor) {
            case "Purple", "Green", "Brown", "Blue" -> {
                for (int i = 0; i < players.size(); i++) {
                    if (cor.equals(players.get(i).cor.nome)) {
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

    public boolean temNovoId(String id) {
        for (int i = 0; i < players.size(); i++) {
            if (Integer.parseInt(id) == players.get(i).id) {
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
        }
        //retorna imagem 50x50 glory.png
        return "";
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
        return switch (turno) {
            case 0 -> players.get(0).getId();
            case 1 -> players.get(1).getId();
            case 2 -> players.get(2).getId();
            case 3 -> players.get(3).getId();
            default -> 0;
        };
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
                nextTurn();
            }
            case 1 -> {
                if (players.get(1).posicao + nrPositions <= tamanhoTab) {
                    players.get(1).posicao += nrPositions;
                } else {
                    players.get(1).posicao = tamanhoTab + (tamanhoTab - players.get(1).posicao - nrPositions);
                }
                nextTurn();
            }
            case 2 -> {
                if (players.get(2).posicao + nrPositions <= tamanhoTab) {
                    players.get(2).posicao += nrPositions;
                } else {
                    players.get(2).posicao = tamanhoTab + (tamanhoTab - players.get(2).posicao - nrPositions);
                }
                nextTurn();
            }
            case 3 -> {
                if (players.get(3).posicao + nrPositions <= tamanhoTab) {
                    players.get(3).posicao += nrPositions;
                } else {
                    players.get(3).posicao = tamanhoTab + (tamanhoTab - players.get(3).posicao - nrPositions);
                }
                nextTurn();
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

    public boolean gameIsOver() {
        if (players == null) {
            return false;
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).posicao == tamanhoTab) {
                vencedor = players.get(i);
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
        strings.add("");
        strings.add("" + nrTurnos);
        strings.add("");
        strings.add("VENCEDOR");
        strings.add("" + vencedor.nome);
        strings.add("");
        strings.add("RESTANTES");
        strings.add("");
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
        JLabel label = new JLabel("Créditos");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        a.add(label);
        JLabel nomes = new JLabel("João Eleutério        Mário Silva");
        nomes.setVerticalAlignment(SwingConstants.CENTER);
        nomes.setHorizontalAlignment(SwingConstants.CENTER);
        a.add(nomes);

        return a;
    }


}
