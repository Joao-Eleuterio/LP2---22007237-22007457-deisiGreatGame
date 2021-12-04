package pt.ulusofona.lp2.deisiGreatGame;

public class ErroLógica extends Trap{

    public ErroLógica() {
        this.id=1;
        this.titulo="Erro lógica";
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
