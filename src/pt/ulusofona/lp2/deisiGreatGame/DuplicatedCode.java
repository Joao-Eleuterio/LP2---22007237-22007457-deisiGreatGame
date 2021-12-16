package pt.ulusofona.lp2.deisiGreatGame;

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
                player.setPosicao(player.getCasas().get(player.getCasas().size() - 1));
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
        return "duplicate_code2.png";
    }

    @Override
    public String getConsequencia() {
        return "Recua na casa anterior";
    }
}
