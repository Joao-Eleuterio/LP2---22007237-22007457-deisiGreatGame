package pt.ulusofona.lp2.deisiGreatGame;

public class TesteUnitario extends Trap{

    public TesteUnitario() {
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
