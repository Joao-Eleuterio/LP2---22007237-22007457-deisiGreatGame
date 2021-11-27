package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    String nome = "";
    ArrayList<String> linguagens;
    int id = 0;
    ProgrammerColor cor;
    int posicao;
    boolean defeat;
    Abismo abismo;
    ArrayList<Ferramenta> ferramentas= new ArrayList<>();
    ArrayList<Integer> casas = new ArrayList<>();

    public Programmer(String nome, ArrayList<String> linguagens, int id, pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor cor) {
        this.nome = nome;
        this.linguagens = linguagens;
        this.id = id;
        this.cor = cor;
        this.posicao = 1;
        this.defeat=false;
    }

    public Trap getAbismo(){
        return abismo;
    }
    public boolean getDefeat(){
        return defeat;
    }
    public void perdeu(){
        this.defeat=true;
    }
    int cicloIfinito=0;
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
        if(this.ferramentas.size()==0){
            txtFerramentas.append("No tools");
        }else{
            for(int i=0;i<this.ferramentas.size();i++){
                if (i == 0) {
                    txtFerramentas.append(this.ferramentas.get(i));
                }else{
                    txtFerramentas.append("; ").append(this.ferramentas.get(i));
                }
            }
        }
        String txtEstado="";
        if(getDefeat()){
            txtEstado="Derrotado";
        }else{
            txtEstado="Em Jogo";
        }
        return this.id + " | " + this.nome + " | " + this.posicao + " | " + txtFerramentas + " | " + txtLinguagens + " | " + txtEstado;
    }


    void cicloInfinito(){
        if(cicloIfinito==0){
            cicloIfinito=3;
        }else{
            cicloIfinito--;
        }
    }
    //TODO o que acontece nas casas com abismos
    public boolean consequencias(Trap trap,int nrSpaces){
         switch (trap.titulo){
            case "Erro de sintaxe":{ this.posicao-=1; return true;}
            case "Erro de lógica":{ this.posicao-=nrSpaces/2; return true; }
            case "Exception": {this.posicao-=2; return true;}
            case "File Not Found Exception": {this.posicao-=3; return true;}
            case "Crash (aka Rebentanço)": {this.posicao=1; return true;}
            case "Duplicated Code":{ this.posicao= casas.get(casas.size()-1); return true;}
            case "Efeitos secundários" : {this.posicao=casas.get(casas.size()-2); return true;}
            case "Blue Screen of Death": {this.defeat=true; return true;}
            case "Ciclo infinito":
            case "Segmentation Fault":
            default:    return false;

         }

    }

}