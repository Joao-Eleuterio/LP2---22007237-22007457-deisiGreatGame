package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Ferramenta{

    public ProgramacaoFuncional() {
        this.titulo="Programação Funcional";
        this.id=1;
    }
    @Override
    public String getTitulo() {
        return this.titulo;
    }

    public String getImage(){
        return "Mapa50x50.png";
    }

    public String  getConsequencia(){
        return "Um mapa antigo da gruta dá bastante jeito para não te perderes";
    }
}
