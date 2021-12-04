package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Trap{

    public CicloInfinito() {
        this.titulo="Ciclo infinito";
        this.id=8;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "infinite-loop.png";
    }
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
