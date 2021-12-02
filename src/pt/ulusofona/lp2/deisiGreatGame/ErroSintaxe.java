package pt.ulusofona.lp2.deisiGreatGame;

public class ErroSintaxe extends Abismo{
    public ErroSintaxe(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Erro de sintaxe";
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
