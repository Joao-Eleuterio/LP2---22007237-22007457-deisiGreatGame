package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Trap{

    public Crash() {
        this.titulo="Crash (aka Rebentanço)";
        this.id=4;
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
        return "Qualquer coisa";
    }
}
