package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abismo{
    public Crash(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Crash";
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
