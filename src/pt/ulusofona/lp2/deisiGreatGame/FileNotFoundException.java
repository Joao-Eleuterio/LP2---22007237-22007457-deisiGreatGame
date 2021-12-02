package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abismo{

    public FileNotFoundException(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "File Not Found Exception";
    }
    @Override
    public String getImage() {
        return "file-not-found-exception2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
