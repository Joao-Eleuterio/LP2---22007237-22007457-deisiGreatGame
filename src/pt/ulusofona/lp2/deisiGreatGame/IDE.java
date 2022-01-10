package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta{
    public IDE() {
        this.titulo="IDE";
        this.id=4;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public String getImage() {
        return "Veneno50x50.png";
    }

    @Override
    public String getConsequencia() {
        return "Veneno para animais vai ser bom se me quiserem atacar";
    }
}
