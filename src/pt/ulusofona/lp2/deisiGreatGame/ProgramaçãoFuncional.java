package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramaçãoFuncional extends Ferramenta{
    int id=1;

    public ProgramaçãoFuncional(int id) {
        super(id);
    }

    @Override
    public String getTitulo() {
        return "Programação Funcional";
    }

    public String getImage(){
        return "functional.png";
    }

    public String  getConsequencia(){
        return "Anula Duplicated Code, efeitos secundários";
    }
}
