package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public class CicloInfinito extends Abismo{

    public CicloInfinito() {
        this.titulo="Ciclo infinito";
        this.id=8;
    }

    @Override
    public boolean consequencia(HashMap<Integer, Programmer> players, int nrSpaces, int turno) {
        if(!players.get(turno).removeFerramenta(new ProgramacaoFuncional())){
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getPosicao() == players.get(turno).getPosicao() && players.get(i).getId() != players.get(turno).getId()) {
                    players.get(i).removeAbismo();
                }
            }
            players.get(turno).abismo=this;
            return true;
        }
        return false;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "infinite-loop.png";
    }
    public String getConsequencia() {
        return "Vai ficar aqui ate um jogador vier nesta casa";
    }

    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
        return false;
    }
}
