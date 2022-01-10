package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoExcepcoes extends Ferramenta{
    public TratamentoExcepcoes() {
        this.titulo="Tratamento de Excepções";
        this.id=3;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getImage() {
        return "Tocha50x50.png";
    }
    public String getConsequencia() {
        return "Hm!? Uma tocha? É melhor guardar";
    }
}
