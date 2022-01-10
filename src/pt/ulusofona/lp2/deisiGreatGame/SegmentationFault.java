package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class SegmentationFault extends Abismo{

    public SegmentationFault() {
        this.titulo="Segmentation Fault";
        this.id=9;
    }

    @Override
    public boolean consequencia(ArrayList<Programmer> players, int nrSpaces, int turno) {
        int posicaoAbismo = players.get(turno).getPosicao();
        for (int i = 0, j = 0; i < players.size(); i++) {
            if (players.get(i).getPosicao() == posicaoAbismo ) {
                j++;
            }
            if (j >= 2) {
                for (Programmer player : players) {
                    if (player.getPosicao() == posicaoAbismo) {
                        player.posicao -= 3;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "Ponte50x50.png";
    }

    @Override
    public String getConsequencia() {
        return "Numa ponte de corda só pode ir um de cada vez, por isso caiu, voltem para tras para descobrir um caminho novo";
    }


    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {return false;}
}
