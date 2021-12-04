package pt.ulusofona.lp2.deisiGreatGame;

public class ErroSintaxe extends Trap{

    public ErroSintaxe() {
        this.id=0;
        this.titulo="Erro de sintaxe";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "erro_sintaxe2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
