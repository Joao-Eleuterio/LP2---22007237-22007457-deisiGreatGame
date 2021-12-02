package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoExcepções extends Ferramenta{
    public TratamentoExcepções(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Tratamento de Excepções";
    }
    @Override
    public String getImage() {
        return "catch.png";
    }

    @Override
    public String getConsequencia() {
        return "qualquer coisa";
    }
}
