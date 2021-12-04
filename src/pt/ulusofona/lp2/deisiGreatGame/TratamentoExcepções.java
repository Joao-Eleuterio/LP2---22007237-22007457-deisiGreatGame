package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoExcepções extends Trap{
    public TratamentoExcepções() {
        this.titulo="Tratamento de Excepções";
        this.id=3;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "catch.png";
    }
    public String getConsequencia() {
        return "qualquer coisa";
    }
}
