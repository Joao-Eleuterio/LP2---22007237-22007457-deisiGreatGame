package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Abismo{

    public CicloInfinito(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Ciclo infinito";
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
