package pt.ulusofona.lp2.deisiGreatGame;

public class TestesUnitarios extends Trap{

    public TestesUnitarios() {
        this.titulo="Testes unitários";
        this.id=2;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "junit2.png";
    }
    public String getConsequencia() {
        return "anula qualquer coisa";
    }
}
