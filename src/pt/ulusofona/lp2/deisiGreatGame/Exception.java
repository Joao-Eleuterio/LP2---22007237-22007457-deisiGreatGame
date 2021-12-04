package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Trap{

    public Exception() {
        this.id=2;
        this.titulo="Exception";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
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
