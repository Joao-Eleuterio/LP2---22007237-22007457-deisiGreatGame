package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class EfeitosSecundarios extends Abismo {

    public EfeitosSecundarios() {
        this.titulo = "Efeitos secundários";
        this.id = 6;
    }



    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
        if (!(player.removeFerramenta(new ProgramacaoFuncional()))) {
            if (player.getCasas().size() <= 2) {
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
    public boolean consequencia(HashMap<Integer, Programmer> player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "side-effects2.png";
    }

    @Override
    public String getConsequencia() {
        return "Recua 2 casas anteriores";
    }
}
