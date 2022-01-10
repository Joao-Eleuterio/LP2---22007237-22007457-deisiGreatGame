package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Ferramenta{

    public Heranca() {
        this.id=0;
        this.titulo="Herança";
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage(){
        return "Corda50x50.png";
    }
    public String  getConsequencia(){
        return "Encontraste uma corda. Guarda-a e usa-a quando precisares!";
    }
}
