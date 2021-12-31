package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Programmer {
    String nome;
    ArrayList<String> linguagens = new ArrayList<>();
    int id;
    ProgrammerColor cor;
    int posicao;
    boolean defeat;
    Trap abismo=null;
    ArrayList<Trap> ferramentas = new ArrayList<>();
    ArrayList<Integer> casas = new ArrayList<>();


    public Programmer(String nome, ArrayList<String> linguagens, int id, ProgrammerColor cor) {
        this.nome = nome;
        this.linguagens = linguagens;
        this.id = id;
        this.cor = cor;
        this.posicao = 1;
        this.defeat = false;
    }

    public Programmer(String nome, String linguagens, String id, String cor, String pos, String defeat, String abismo, String ferramentas, String casas) throws java.lang.Exception {
        this.nome = nome;
        if (!linguagens.equals("null")) {
            String[] linguagensProg = linguagens.split(",");
            this.linguagens.addAll(List.of(linguagensProg));
        } else {
            this.linguagens = new ArrayList<>();
        }
        this.id = Integer.parseInt(id);
        if (ProgrammerColor.getColor(cor) != null) {
            this.cor = ProgrammerColor.valueOf(cor.toUpperCase());
        }
        this.posicao = Integer.parseInt(pos);
        this.defeat = defeat.equals("true");

        if (!abismo.equals("null")) {
            String[] abismoTrapStr = abismo.split(" ");
            this.abismo = Trap.addTrap(Integer.parseInt(abismoTrapStr[0]), Integer.parseInt(abismoTrapStr[1]));
        } else {
            this.abismo = null;
        }
        if (!ferramentas.equals("null") && !ferramentas.equals("")) {
            String[] ferramentasTrapStr = ferramentas.split(",");
            for (String s : ferramentasTrapStr) {
                String[] ferramentaIds = s.split(" ");
                this.ferramentas.add(Trap.addTrap(Integer.parseInt(ferramentaIds[0]), Integer.parseInt(ferramentaIds[1])));
            }
        } else {
            this.ferramentas = new ArrayList<>();
        }
        if (!casas.equals("null")) {
            String[] casasAndadas = casas.split(",");
            for (String casasAndada : casasAndadas) {
                this.casas.add(Integer.valueOf(casasAndada));
            }
        } else {
            this.casas = new ArrayList<>();
        }
    }

    public Trap getAbismo() {
        return abismo;
    }

    public void addAbismo(Trap abismo) {
        this.abismo = abismo;
    }

    public void removeAbismo() {
        this.abismo = null;
    }

    public boolean getDefeat() {
        return defeat;
    }

    public void perdeu() {
        this.defeat = true;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.nome == null ? "" : this.nome;
    }

    public void addCasa(int posicao) {
        casas.add(posicao);
    }

    public ProgrammerColor getColor() {
        return cor;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    void andar(int nrSpaces) {
        addCasa(getPosicao());
        if (getPosicao() + nrSpaces > 0) {
            this.posicao += nrSpaces;
        }
    }

    public String toString() {
        StringBuilder txtLinguagens = new StringBuilder();
        Collections.sort(this.linguagens);
        for (int i = 0; i < this.linguagens.size(); i++) {
            if (i == 0) {
                txtLinguagens.append(this.linguagens.get(i));
            } else {
                txtLinguagens.append("; ").append(this.linguagens.get(i));
            }
        }
        StringBuilder txtFerramentas = new StringBuilder();
        if (this.ferramentas == null || this.ferramentas.size() == 0) {
            txtFerramentas.append("No tools");
        } else {
            for (int i = 0; i < this.ferramentas.size(); i++) {
                if (i == 0) {
                    txtFerramentas.append(this.ferramentas.get(i).titulo);
                } else {
                    txtFerramentas.append("; ").append(this.ferramentas.get(i).getTitulo());
                }
            }
        }
        String txtEstado = "Em Jogo";
        if (getDefeat()) {
            txtEstado = "Derrotado";
        }
        return this.id + " | " + this.nome + " | " + this.posicao + " | " + txtFerramentas + " | " + txtLinguagens + " | " + txtEstado;
    }

    public boolean getCicloIfinito() {
        return abismo != null && abismo.titulo.equals("Ciclo infinito");
    }

    public void addFerramenta(Trap ferramenta) {
        ferramentas.add(ferramenta);
    }

    boolean removeFerramenta(Trap ferramenta) {
        for (int i = 0; i < ferramentas.size(); i++) {
            if (ferramenta.titulo.equals(ferramentas.get(i).titulo)) {
                ferramentas.remove(i);
                return true;
            }
        }
        return false;
    }

    boolean temFerramenta(Trap ferramenta) {
        for (Trap value : ferramentas) {
            if (ferramenta.titulo.equals(value.titulo)) {
                return true;
            }
        }
        return false;
    }

    ArrayList<Integer> getCasas() {
        return casas;
    }


    boolean temEstaLinguagem(String linguagem) {
        for (int i = 0; linguagens != null && i < linguagens.size(); i++) {
            if (linguagens.get(i).equals(linguagem)) {
                return true;
            }
        }
        return false;
    }

    public StringBuilder getFerramentas() {
        StringBuilder ferramentas = new StringBuilder();
        for (int j = 0; this.ferramentas != null && j < this.ferramentas.size(); j++) {
            if (this.ferramentas.get(j) != null) {
                if (j == 0) {
                    ferramentas.append(this.ferramentas.get(j).abismoFerramenta()).append(" ").append(this.ferramentas.get(j).getId());
                } else {
                    ferramentas.append(",").append(this.ferramentas.get(j).abismoFerramenta()).append(" ").append(this.ferramentas.get(j).getId());
                }
            }
        }
        if (this.ferramentas == null || this.ferramentas.size() == 0) {
            ferramentas = new StringBuilder("null");
        }
        return ferramentas;
    }

    public StringBuilder getLinguagens() {
        StringBuilder linguagens = new StringBuilder();
        for (int j = 0; this.linguagens != null && j < this.linguagens.size(); j++) {
            if (this.linguagens.get(j) != null) {
                if (j == 0) {
                    linguagens.append(this.linguagens.get(j));
                } else {
                    linguagens.append(",").append(this.linguagens.get(j));
                }
            }
        }
        if (this.linguagens == null || this.linguagens.size() == 0) {
            linguagens = new StringBuilder("null");
        }
        return linguagens;
    }

    public StringBuilder getCasa() {
        StringBuilder casa = new StringBuilder();
        for (int j = 0; this.casas != null && j < this.casas.size(); j++) {
            if (this.casas.get(j) != null) {
                if (j == 0) {
                    casa.append(this.casas.get(j));
                } else {
                    casa.append(",").append(this.casas.get(j));
                }
            }
        }
        if (this.casas == null || this.casas.size() == 0) {
            casa = new StringBuilder("null");
        }
        return casa;
    }
}
