package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Programmer {
    String nome;
    ArrayList<String> linguagens=new ArrayList<>();
    int id;
    ProgrammerColor cor;
    int posicao;
    boolean defeat;
    Trap abismo;
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
    public Programmer(String nome,String linguagens,String id,String cor,String pos,String defeat,String casas){
        this.nome=nome;
        String[] linguagensProg = linguagens.split(",");
        this.linguagens.addAll(List.of(linguagensProg));
        this.id=Integer.parseInt(id);
        this.cor=ProgrammerColor.valueOf(cor.toUpperCase());
        this.posicao=Integer.parseInt(pos);
        this.defeat= defeat.equals("true");
        if(!casas.equals("null")){
            String[] casasAndadas = casas.split(",");
            this.casas.addAll(Collections.singleton(Integer.parseInt(Arrays.toString(casasAndadas))));
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
        if (this.ferramentas.size() == 0) {
            txtFerramentas.append("No tools");
        } else {
            for (int i = 0; i < this.ferramentas.size(); i++) {
                if (i == 0) {
                    txtFerramentas.append(this.ferramentas.get(i).titulo);
                } else {
                    txtFerramentas.append("; ").append(this.ferramentas.get(i).titulo);
                }
            }
        }
        String txtEstado = "";
        if (getDefeat()) {
            txtEstado = "Derrotado";
        } else {
            txtEstado = "Em Jogo";
        }
        return this.id + " | " + this.nome + " | " + this.posicao + " | " + txtFerramentas + " | " + txtLinguagens + " | " + txtEstado;
    }

    public boolean getCicloIfinito() {
        return abismo!=null && abismo.titulo.equals("Ciclo infinito");
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

}