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
    int nrSpaces = 0;

    public GameManager() {
    }

    //cria e faz o tratamento de dados dos players
    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {
        players.clear();
        nrTurnos = 0;
        turno = 0;
        vencedor = null;
        abismos.clear();
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
        return new ArrayList<>(List.of(linguagem));
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
                //Trap  addTrap (idTrap, id)   = (abyssesAndTool[0].equals("0"),Integer.parseInt(abyssesAndTool[1]))
                escolheTrap(Integer.parseInt(abyssesAndTool[0]), Integer.parseInt(abyssesAndTool[1]), Integer.parseInt(abyssesAndTool[2]));
            }
        }
        return inicialboard;
    }

    public void escolheTrap(int idTrap, int id, int pos) {
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
                }

        }
        abismos.put(pos, trap);
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
        players.get(turno).addCasa(players.get(turno).getPosicao());
        if (players.get(turno).getAbismo() == null) {
            if ((players.get(turno).getPosicao() + nrSpaces) <= tamanhoTab) {
                try {
                    players.get(turno).andar(nrSpaces);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } else {
                players.get(turno).setPosicao(tamanhoTab + (tamanhoTab - players.get(0).getPosicao() - nrSpaces));
            }
        }
        this.nrSpaces = nrSpaces;
        return true;
    }

    public void mover(int nrSpaces, int turno) {

        if (players.get(turno).getDefeat()) {
            nextTurn();
            return;
        }
        if (abismos.containsKey(players.get(turno).getPosicao()) && !players.get(turno).consequencias(abismos.get(players.get(turno).getPosicao()), nrSpaces)) {
            if (abismos.get(players.get(turno).getPosicao()).titulo.equals("Ciclo infinito")) {
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getPosicao() == players.get(turno).getPosicao() && players.get(i) != players.get(turno)) {
                        players.get(i).abismo = null;
                        players.get(i).cicloInfinito(false);
                    }
                }
                players.get(turno).cicloInfinito(true);
                players.get(turno).addAbismo(abismos.get(players.get(turno).getPosicao()));
            } else if (abismos.get(players.get(turno).getPosicao()).titulo.equals("Segmentation Fault")) {
                int posicaoAbismo = players.get(turno).getPosicao();
                for (int i = 0, j = 0; i < players.size(); i++) {
                    if (players.get(i).getPosicao() == posicaoAbismo) {
                        j++;
                    }
                    if (j >= 2) {
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
        Collection<Programmer> values = players.values();
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
        organizado.sort(Comparator.comparingInt((Programmer b) -> b.posicao).reversed());
        for (Programmer programmer : organizado) {
            if (programmer.getPosicao() != tamanhoTab && !programmer.getDefeat()) {
                strings.add(programmer.getName() + " " + programmer.getPosicao());
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

                txt.append(players.get(i).nome).append(" : ");
                if (players.get(i).ferramentas.size() == 0) {
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
            String txt = "Caiu " + abismos.get(players.get(turno).getPosicao()).getTitulo() + "! " + abismos.get(players.get(turno).getPosicao()).getConsequencia();
            mover(nrSpaces, turno);
            nextTurn();
            return txt;

        }
        nextTurn();
        return null;
    }
}


