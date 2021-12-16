package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public class BlueScreenOfDeath extends Abismo {

    public BlueScreenOfDeath() {
        this.titulo = "Blue Screen of Death";
        this.id = 7;
    }


    public boolean consequencia(Programmer player, int nrSpaces) {
            player.perdeu();
            player.removeAbismo();
            return true;
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
        return "bsod.png";
    }

    @Override
    public String getConsequencia() {
        return "Perdeu :(";
    }
}
