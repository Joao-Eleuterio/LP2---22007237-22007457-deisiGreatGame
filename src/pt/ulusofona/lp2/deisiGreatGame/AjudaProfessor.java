package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaProfessor extends Ferramenta{
    public AjudaProfessor(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Ajuda do Professor";
    }

    @Override
    public String getImage() {
        return "ajudaProf2.png";
    }

    @Override
    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
