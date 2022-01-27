package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class DuplicatedCode extends Abismo {
    public DuplicatedCode() {
        this.titulo = "Duplicated Code";
        this.id = 5;
    }


    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {

        if (!(player.removeFerramenta(new Heranca()))) {
            if (player.getCasas().size() <= 1) {
                player.setPosicao(1);
            } else {
                player.setPosicao(player.getCasas().get(player.getCasas().size() - 2));
            }
            player.removeAbismo();
            return true;
        }
        return false;
    }

    @Override
    public boolean consequencia(ArrayList<Programmer>  player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "Buraco50x50.png";
    }

    @Override
    public String getConsequencia() {
        return "Caís-te num buraco e voltaste à mesma posição.";
    }
}
