package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Crash extends Abismo{

    public Crash() {
        this.titulo="Crash (aka Rebentanço)";
        this.id=4;
    }

    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
            player.setPosicao(1);
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
        return "crash2.png";
    }

    @Override
    public String getConsequencia() {
        return "Volta a 1º casa";
    }
}
