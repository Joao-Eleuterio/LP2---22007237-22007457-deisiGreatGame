package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abismo{
    public Exception(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Exception";
    }
    @Override
    public String getImage() {
        return "exception.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
