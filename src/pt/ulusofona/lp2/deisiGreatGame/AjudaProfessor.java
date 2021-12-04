package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaProfessor extends Trap{

    public AjudaProfessor() {
        this.titulo="Ajuda do Professor";
        this.id=5;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getImage() {
        return "ajudaProf2.png";
    }


    public String getConsequencia() {
        return "Qualquer coisa";
    }
}
