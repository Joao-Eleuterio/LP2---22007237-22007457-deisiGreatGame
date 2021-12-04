package pt.ulusofona.lp2.deisiGreatGame;

public class ErroLogica extends Trap{

    public ErroLogica() {
        this.id=1;
        this.titulo="Erro de lógica";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "logic.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
