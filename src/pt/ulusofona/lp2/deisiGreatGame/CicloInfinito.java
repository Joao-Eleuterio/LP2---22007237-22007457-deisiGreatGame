package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Trap{


    public CicloInfinito() {
        this.titulo="Ciclo infinito";
        this.id=8;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "infinite-loop.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
