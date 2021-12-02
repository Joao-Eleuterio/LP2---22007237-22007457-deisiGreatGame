package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta{
    public IDE(int id) {
        super(id);
    }
    @Override
    public String getTitulo() {
        return "IDE";
    }
    @Override
    public String getImage() {
        return "intellij2.png";
    }

    @Override
    public String getConsequencia() {
        return "Evita qualquer coisa";
    }
}
