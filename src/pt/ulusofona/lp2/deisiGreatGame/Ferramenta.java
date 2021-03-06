package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Ferramenta extends Trap{
    @Override
    public boolean consequencia(ArrayList< Programmer> player, int nrSpaces, int turno) {
        if(player.get(turno).temFerramenta(this)){
            return false;
        }
        player.get(turno).addFerramenta(this);
        return false;
    }
    public int abismoFerramenta() {return 1;}
    public int getId(){return id;}
}
