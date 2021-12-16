package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public class SegmentationFault extends Abismo{

    public SegmentationFault() {
        this.titulo="Segmentation Fault";
        this.id=9;
    }

    @Override
    public boolean consequencia(HashMap<Integer, Programmer> players, int nrSpaces, int turno) {
        int posicaoAbismo = players.get(turno).getPosicao();
        for (int i = 0, j = 0; i < players.size(); i++) {
            if (players.get(i).getPosicao() == posicaoAbismo ) {
                j++;
            }
            if (j >= 2) {
                for (int h = 0; h < players.size(); h++) {
                    if (players.get(h).getPosicao() == posicaoAbismo) {
                        players.get(h).posicao -= 3;
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
        return "core_dump2.png";
    }

    @Override
    public String getConsequencia() {
        return "Quando tiverem 2+ jogadores na casa todos recuam 3 casas";
    }


    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {return false;}
}
