package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abismo extends Trap {

    public abstract boolean consequencia(Programmer player, int nrSpaces);
    public int AbismoFerramenta() {return abismoFerramenta;}
    public int getId(){return id;}

}
