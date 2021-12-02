package pt.ulusofona.lp2.deisiGreatGame;

public class ErroLógica extends Abismo{
    public ErroLógica(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Erro lógica";
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
