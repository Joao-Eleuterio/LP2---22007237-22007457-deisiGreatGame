package pt.ulusofona.lp2.deisiGreatGame;

public class TestesUnitários extends Trap{

    public TestesUnitários() {
        this.titulo="Testes unitários";
        this.id=2;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "junit.png";
    }
    public String getConsequencia() {
        return "anula qualquer coisa";
    }
}
