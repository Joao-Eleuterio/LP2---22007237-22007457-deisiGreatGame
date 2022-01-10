package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaProfessor extends Ferramenta{

    public AjudaProfessor() {
        this.titulo="Ajuda do Professor";
        this.id=5;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "pilha50x50.png";
    }
    public String getConsequencia() {
        return "Um pack de pilhas é bom para não ficar sem bateria";
    }
}
