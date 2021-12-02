package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenOfDeath extends Abismo{

    public BlueScreenOfDeath(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Blue screen of Death";
    }

    @Override
    public String getImage() {
        return "bsod.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
