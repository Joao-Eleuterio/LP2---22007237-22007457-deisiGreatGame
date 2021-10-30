package pt.ulusofona.lp2.deisiGreatGame;


import java.util.ArrayList;

public class Programmer {
    String nome = "";
    ArrayList<String> linguagens;
    int id = 0;
    ProgrammerColor cor;
    int posicao;

        public Programmer(String nome, ArrayList<String> linguagens, int id, ProgrammerColor cor) {
        this.nome = nome;
        this.linguagens = linguagens;
        this.id = id;
        this.cor=cor;
        this.posicao = 1;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.nome == null ? "" : this.nome;
    }

    public ProgrammerColor getColor() {
        return cor;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public String toString() {
        return this.id + " | " + this.nome + " | " + this.posicao + " | " + this.linguagens + " | Em jogo";
    }
}