package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Trap{

    public Heranca() {

        this.id=0;
        this.titulo="Herança";
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage(){
        return "herança.png";
    }
    public String  getConsequencia(){
        return "Anula os feitos de codigo duplicado";
    }
}