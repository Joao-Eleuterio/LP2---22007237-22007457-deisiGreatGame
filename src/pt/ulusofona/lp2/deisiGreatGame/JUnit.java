package pt.ulusofona.lp2.deisiGreatGame;

public class JUnit extends Ferramenta{

    public JUnit() {
        this.titulo="Testes unitários";
        this.id=2;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "Sapato50x50.png";
    }
    public String getConsequencia() {
        return "Encontraste uns sapatos leves que não fazem barulho a andar. Mantém-te discreto!";
    }
}
