package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitosSecundários extends Abismo{
    public EfeitosSecundários(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Efeitos Secundários";
    }

    @Override
    public String getImage() {
        return "side-effects2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
