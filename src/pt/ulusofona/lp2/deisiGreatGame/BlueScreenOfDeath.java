package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenOfDeath extends Trap{

    public BlueScreenOfDeath() {
        this.titulo="Blue Screen of Death";
        this.id=7;
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
        return "Qualquer coisa";
    }
}
