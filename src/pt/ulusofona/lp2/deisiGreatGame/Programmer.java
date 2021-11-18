package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    String nome = "";
    ArrayList<String> linguagens;
    ArrayList<String> ferramentas;
    int id = 0;
    pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor cor;
    int posicao;

    public Programmer(String nome, ArrayList<String> linguagens,ArrayList<String> ferramentas, int id, pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor cor) {
        this.nome = nome;
        this.linguagens = linguagens;
        this.id = id;
        this.cor = cor;
        this.posicao = 1;
        this.ferramentas = ferramentas;
        ;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.nome == null ? "" : this.nome;
    }

    public pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor getColor() {
        return cor;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public String toString() {
        StringBuilder txtLinguagens = new StringBuilder();
        StringBuilder txtferramentas = new StringBuilder();
        Collections.sort(this.linguagens);
        for (int i = 0; i < this.linguagens.size(); i++) {
            if (i == 0) {
                txtLinguagens.append(this.linguagens.get(i));
            } else {
                txtLinguagens.append("; ").append(this.linguagens.get(i));
            }
        }
        if(ferramentas != null || ferramentas.size() != 0){
            for(int j = 0; j < this.ferramentas.size();j++){
                if(j == 0){
                    txtferramentas.append(this.ferramentas.get(j));
                }else{
                    txtferramentas.append("; ").append(this.ferramentas.get(j));
                }
            }


        } else{
            txtferramentas.append("No tools");
        }




        return this.id + " | " + this.nome + " | " + this.posicao + " | " + txtferramentas + " | " +  txtLinguagens + " | Em Jogo";
    }
}