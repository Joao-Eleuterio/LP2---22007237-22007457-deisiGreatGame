package pt.ulusofona.lp2.deisiGreatGame;

public class TestesUnitários extends Ferramenta{
    public TestesUnitários(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Testes unitários";
    }
    @Override
    public String getImage() {
        return "junit.png";
    }

    @Override
    public String getConsequencia() {
        return "anula qualquer coisa";
    }
}
