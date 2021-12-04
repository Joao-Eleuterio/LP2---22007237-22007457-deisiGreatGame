package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Trap{
    public DuplicatedCode() {
        this.titulo="Duplicated Code";
        this.id=5;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "duplicate_code2.png";
    }
    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
