package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class CicloInfinito extends Abismo{

    public CicloInfinito() {
        this.titulo="Ciclo infinito";
        this.id=8;
    }

    @Override
    public boolean consequencia(ArrayList< Programmer> players, int nrSpaces, int turno) {
        boolean entrou=false;
        if(!players.get(turno).removeFerramenta(new ProgramacaoFuncional())){
            for (Programmer player : players) {
                if (player.getPosicao() == players.get(turno).getPosicao() && player.getId() != players.get(turno).getId()) {
                    player.removeAbismo();
                    entrou = true;
                }
            }
            players.get(turno).addAbismo(this);
            return entrou;
        }
        players.get(turno).removeAbismo();
        return true;
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
