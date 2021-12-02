package pt.ulusofona.lp2.deisiGreatGame;

public class Herança extends Ferramenta{
    int id=0;

    public Herança(int id) {
        super(id);
    }
    @Override
    public String getTitulo() {
        return "Herança";
    }

    public String getImage(){
        return "herança.png";
    }
    public String  getConsequencia(){
        return "Anula os feitos de codigo duplicado";
    }
}
