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
    ArrayList<Ferramenta> ferramentas = new ArrayList<>();
    ArrayList<Integer> casas = new ArrayList<>();

    public Programmer(String nome, ArrayList<String> linguagens, int id, pt.ulusofona.lp2.deisiGreatGame.ProgrammerColor cor) {
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

    public boolean getDefeat() {
        return defeat;
    }

    public void perdeu() {
        this.defeat = true;
    }

    int cicloIfinito = 0;

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
        if (this.ferramentas.size() == 0) {
            txtFerramentas.append("No tools");
        } else {
            for (int i = 0; i < this.ferramentas.size(); i++) {
                if (i == 0) {
                    txtFerramentas.append(this.ferramentas.get(i));
                } else {
                    txtFerramentas.append("; ").append(this.ferramentas.get(i));
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


    void cicloInfinito() {
        if (cicloIfinito == 0) {
            cicloIfinito = 3;
        } else {
            cicloIfinito--;
        }
    }

    boolean getFerramenta(Ferramenta ferramenta) {
        for (int i=0;i< ferramentas.size();i++) {
            if (ferramenta.titulo.equals(ferramentas.get(i).titulo)) {
                ferramentas.remove(i);
                return true;
            }
        }
        return false;
    }

    boolean temFerramenta(Ferramenta ferramenta){
        for (Ferramenta value : ferramentas) {
            if (ferramenta.titulo.equals(value.titulo)) {
                return true;
            }
        }
        return false;
    }

    //TODO o que acontece nas casas com abismos
    public boolean consequencias(Trap trap, int nrSpaces) {
        switch (trap.titulo) {
            case "Erro de sintaxe": {
                if (!(getFerramenta(new Ferramenta(4)) || getFerramenta(new Ferramenta(5)))) {
                    this.posicao -= 1;
                }
                return true;
            }
            case "Erro de lógica": {
                if (!(getFerramenta(new Ferramenta(2)) || getFerramenta(new Ferramenta(5)))) {
                    this.posicao -= nrSpaces / 2;
                }
                return true;
            }
            case "Exception": {
                if (!(getFerramenta(new Ferramenta(3)) || getFerramenta(new Ferramenta(5)))) {
                    this.posicao -= 2;
                }
                return true;
            }
            case "File Not Found Exception": {
                if (!(getFerramenta(new Ferramenta(3)) || getFerramenta(new Ferramenta(5)))) {
                    this.posicao -= 3;
                }
                return true;
            }
            case "Crash (aka Rebentanço)": {
                this.posicao = 1;
                return true;
            }
            case "Duplicated Code": {
                this.posicao = casas.get(casas.size() - 2);
                return true;
            }
            case "Efeitos secundários": {
                if (!(getFerramenta(new Ferramenta(1)))) {
                    this.posicao = casas.get(casas.size() - 3);
                }
                return true;
            }
            case "Blue Screen of Death": {
                perdeu();
                return true;
            }
            case "Ciclo infinito": {
                return getFerramenta(new Ferramenta(1));
            }
            case "Herança": {
                if (temFerramenta(new Ferramenta(0))) {
                    ferramentas.add(new Ferramenta(0));
                }
                return true;
            }
            case "Programação funcional ": {
                if (temFerramenta(new Ferramenta(1))) {
                    ferramentas.add(new Ferramenta(1));
                }
                return true;
            }
            case "Testes unitários": {
                if (temFerramenta(new Ferramenta(2))) {
                    ferramentas.add(new Ferramenta(2));
                }
                return true;
            }
            case "Tratamento de Excepções": {
                if (temFerramenta(new Ferramenta(3))) {
                    ferramentas.add(new Ferramenta(3));
                }
                return true;
            }
            case "IDE": {
                if (temFerramenta(new Ferramenta(4))) {
                    ferramentas.add(new Ferramenta(4));
                }
                return true;
            }
            case "Ajuda Do Professor": {
                if (temFerramenta(new Ferramenta(5))) {
                    ferramentas.add(new Ferramenta(5));
                }
                return true;
            }
            case "Segmentation Fault":
            default:
                return false;

        }
    }

}