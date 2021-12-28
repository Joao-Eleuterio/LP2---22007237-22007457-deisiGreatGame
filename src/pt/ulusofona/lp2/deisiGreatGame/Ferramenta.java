package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public abstract class Ferramenta extends Trap{
    @Override
    public boolean consequencia(HashMap<Integer, Programmer> player, int nrSpaces, int turno) {
        if(player.get(turno).temFerramenta(this)){
            return false;
        }
        player.get(turno).addFerramenta(this);
        return false;
    }
    public int abismoFerramenta() {return abismoFerramenta;}
    public int getId(){return id;}
}
