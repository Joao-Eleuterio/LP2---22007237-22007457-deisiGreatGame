package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    String nome;
    ArrayList<String> linguagens;
    int id;
    ProgrammerColor cor;
    int posicao;
    boolean defeat;
    Trap abismo;
    ArrayList<Trap> ferramentas = new ArrayList<>();
    ArrayList<Integer> casas = new ArrayList<>();
    boolean cicloIfinito = false;

    public Programmer(String nome, ArrayList<String> linguagens, int id, ProgrammerColor cor) {
        this.nome = nome;
        this.linguagens = linguagens;
        this.id = id;
        this.cor = cor;
        this.posicao = 1;
        this.defeat = false;
    }

    public Trap getAbismo() {
        return abismo;
    }
    public void addAbismo(Trap abismo){this.abismo=abismo;}
    public void removeAbismo(){this.abismo=null; }

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

    public void addCasa(int posicao){
        casas.add(posicao);
    }
    public ProgrammerColor getColor() {
        return cor;
    }

    public int getPosicao() {
        return this.posicao;
    }
    public void setPosicao(int posicao){
        this.posicao=posicao;
    }
    void andar(int nrSpaces) throws java.lang.Exception {
        if((this.posicao+=nrSpaces)<=0){
            throw new java.lang.Exception();
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

    public void cicloInfinito(boolean estaCiclo) {
        this.cicloIfinito=estaCiclo;
    }
    public boolean getCicloIfinito(){ return cicloIfinito;}

    public void addFerramenta(Trap ferramenta){
        ferramentas.add(ferramenta);
    }
    boolean removeFerramenta(Trap ferramenta) {
        for (int i=0;i< ferramentas.size();i++) {
            if (ferramenta.titulo.equals(ferramentas.get(i).titulo)) {
                ferramentas.remove(i);
                return true;
            }
        }
        return false;
    }
    boolean temFerramenta(Trap ferramenta){
        for (Trap value : ferramentas) {
            if (ferramenta.titulo.equals(value.titulo)) {
                return true;
            }
        }
        return false;
    }

    public boolean consequencias(Trap trap, int nrSpaces) {
        switch (trap.getTitulo()) {
            case "Erro de sintaxe": {
                if (!(removeFerramenta(new IDE()) || removeFerramenta(new AjudaProfessor()))) {
                    try {
                        andar(-1);
                    }catch (java.lang.Exception c){
                        c.printStackTrace();
                    }
                }
                return true;
            }
            case "Erro de lógica": {
                if (!(removeFerramenta(new ProgramaçãoFuncional()) || removeFerramenta(new AjudaProfessor()))) {
                    try {
                        andar(-(nrSpaces / 2));
                    }catch (java.lang.Exception c){
                        c.printStackTrace();
                    }
                }
                return true;
            }
            case "Exception": {
                if (!(removeFerramenta(new TratamentoExcepções()) || removeFerramenta(new AjudaProfessor()))) {
                    try {
                        andar(-2);
                    }catch (java.lang.Exception c){
                        c.printStackTrace();
                    }
                }
                return true;
            }
            case "File Not Found Exception": {
                if (!(removeFerramenta(new TratamentoExcepções()) || removeFerramenta(new AjudaProfessor()))) {
                    try {
                        andar(-3);
                    }catch (java.lang.Exception c){
                        c.printStackTrace();
                    }

                }
                return true;
            }
            case "Crash (aka Rebentanço)": {
                this.posicao = 1;
                return true;
            }
            case "Duplicated Code": {
                try {
                    this.posicao = casas.get(casas.size() - 1);
                }catch (java.lang.Exception c){
                    c.printStackTrace();
                }
                return true;
            }
            case "Efeitos secundários": {
                if (!(removeFerramenta(new ProgramaçãoFuncional()))) {
                    try {
                        this.posicao = casas.get(casas.size() - 2);
                    }catch (java.lang.Exception c){
                        c.printStackTrace();
                    }
                }
                return true;
            }
            case "Blue Screen of Death": {
                perdeu();
                return true;
            }
            case "Ciclo infinito": {
                return removeFerramenta(new ProgramaçãoFuncional());
            }
            case "Herança": {
                if (!temFerramenta(new Herança())) {
                    ferramentas.add(new Herança());
                }
                return true;
            }
            case "Programação Funcional": {
                if (!temFerramenta(new ProgramaçãoFuncional())) {
                    ferramentas.add(new ProgramaçãoFuncional());
                }
                return true;
            }
            case "Testes unitários": {
                if (!temFerramenta(new TestesUnitários())) {
                    ferramentas.add(new TestesUnitários());
                }
                return true;
            }
            case "Tratamento de Excepções": {
                if (!temFerramenta(new TratamentoExcepções())) {
                    ferramentas.add(new TratamentoExcepções());
                }
                return true;
            }
            case "IDE": {
                if (!temFerramenta(new IDE())) {
                    ferramentas.add(new IDE());
                }
                return true;
            }
            case "Ajuda Do Professor": {
                if (!temFerramenta(new AjudaProfessor())) {
                    ferramentas.add(new AjudaProfessor());
                }
                return true;
            }
            case "Segmentation Fault":
            default:
                return false;

        }
    }

}