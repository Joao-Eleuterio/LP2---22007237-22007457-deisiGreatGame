package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Trap{

    public FileNotFoundException() {
        this.id=3;
        this.titulo="File Not Found Exception";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "file_not_found_exception2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
