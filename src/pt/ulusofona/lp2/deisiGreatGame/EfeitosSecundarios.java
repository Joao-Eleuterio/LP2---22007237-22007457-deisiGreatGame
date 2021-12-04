package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitosSecundarios extends Trap{

    public EfeitosSecundarios() {
        this.titulo="Efeitos secundários";
        this.id=6;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
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
