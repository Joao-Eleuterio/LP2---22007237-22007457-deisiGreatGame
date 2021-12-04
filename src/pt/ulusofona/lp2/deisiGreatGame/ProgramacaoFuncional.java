package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Trap{

    public ProgramacaoFuncional() {
        this.titulo="Programação Funcional";
        this.id=1;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    public String getImage(){
        return "functional.png";
    }

    public String  getConsequencia(){
        return "Anula Duplicated Code, efeitos secundários";
    }
}
